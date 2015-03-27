package com.ui.panel

import javax.swing.JPanel


import com.util.MainThreadTimer._
import java.awt.Point
import java.awt.Font
import java.awt.Color
import java.awt.Graphics
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent
import com.ui.gameelement.barricade.Barricades
import com.ui.gameelement.missile.MissilesInFlight
import com.ui.gameelement.invader.InvaderArmy
import com.ui.gameelement.bomb.DroppingBombs
import com.ui.gameelement.GameElementPosition
import com.ui.gameelement.player.types.Player
import com.ui.gameelement.gameover.GameOver
import com.ui.gameelement.invader.types.Invader
import com.{GameConfiguration, GameLogic, SpaceInvaderGame}

object GamePanel extends JPanel with Runnable with ActionListener {
    private[this] val SCREEN_REFRESH_RATE_IN_MILLIS = 1
    private[this] val PREFERRED_WIDTH = 580
    private[this] val PREFERRED_HEIGHT= 480

    private[this] val DELAY_BEFORE_CLOSING_MAIN_WINDOW= 1000

    private[this] var animator: Thread = null
    private[this] var gameLogic:GameLogic = new GameLogic()
    private[this] var spaceInvaderGame = new SpaceInvaderGame

    setPanelAttributes

    override def paintComponent(g: Graphics): Unit = {
        super.paintComponent(g)

        if(!gameLogic.isGameOver)
            updateScreen(g)
        else
            displayGameOverAnimation(g)
    }

    override def run(): Unit = mainGameLoop

    def updateScreen(g: Graphics) {
        val gameState = spaceInvaderGame.updatedGameElements(new GameElementPosition(getWidth, getHeight))

        if (gameState.isTimeToResetGame)
            spaceInvaderGame = spaceInvaderGame.resetAll

        gameLogic = if (gameState.elements.player.isHit && gameState.isTimeToResetGame) {
            gameLogic.playerShotOnce.setScore(gameState.score)
        } else {
            gameLogic.setScore(gameState.score)
        }

        GameConfiguration.setGameDifficulty(gameLogic.currentScore)

        GameStatusPanel.updateStats(gameLogic.livesLeft, gameLogic.currentScore)

        displayBarricades(gameState.elements.barricades, g)

        displayShooter(gameState.elements.player, g)

        displayMissiles(gameState.elements.missilesInFlight, g)

        displayBombs(gameState.elements.droppingBombs, g)

        displayInvaderArmy(gameState.elements.invaderArmy, g)

        displayMysteryInvader(gameState.elements.mysteryInvader, g)
    }

    def displayGameOverAnimation(g: Graphics) {
        val GAME_OVER_TEXT_LOCATION: Point = new Point(50+(getWidth/3), getHeight / 2)

        displayGameOver(GameOver(GAME_OVER_TEXT_LOCATION), g)
    }

    private def mainGameLoop: Unit = {

        var beforeTime = System.currentTimeMillis()
        do {

            repaint()

            sleep(beforeTime)

            beforeTime = System.currentTimeMillis()

        } while (!gameLogic.isGameOver)

        Thread.sleep(DELAY_BEFORE_CLOSING_MAIN_WINDOW)
        
        System.exit(0) // temp
    }

    private def sleep(beforeTime: Long) {
        try {
            Thread.sleep(calculateThreadSleepTime(beforeTime, SCREEN_REFRESH_RATE_IN_MILLIS))
        } catch {
            case e: InterruptedException => println("Interrupted: " + e.getMessage())
        }
    }

    override
    def addNotify: Unit = {
        super.addNotify()

        animator = new Thread(this)
        animator.start()
    }

    override
    def actionPerformed(e: ActionEvent): Unit = {

    }

    private class KeyBoardAdapter extends KeyAdapter {
        override
        def keyPressed(e:KeyEvent) {
            e.getKeyCode match {
                case KeyEvent.VK_SPACE =>
                    spaceInvaderGame.getPlayerPosition.map(spaceInvaderGame.shootSingleMissileFrom)
                case KeyEvent.VK_RIGHT =>
                    spaceInvaderGame.movePlayerRight(getWidth)
                case KeyEvent.VK_LEFT  =>
                    spaceInvaderGame.movePlayerLeft
                case _ => Unit
            }
        }
    }

    private def displayBarricades(barricades:Barricades, g:Graphics):Unit         = barricades.draw(g)
    private def displayShooter (shooter:Player, g:Graphics):Unit                  = shooter.draw(g)
    private def displayMissiles (missiles:MissilesInFlight, g:Graphics):Unit      = missiles.draw(g)
    private def displayBombs (bombs:DroppingBombs, g:Graphics):Unit               = bombs.draw(g)
    private def displayInvaderArmy (invaderArmy:InvaderArmy, g:Graphics):Unit     = invaderArmy.draw(g)
    private def displayGameOver(gameOver:GameOver, g:Graphics):Unit               = gameOver.draw(g)
    private def displayMysteryInvader (mysteryInvader:Option[Invader], g:Graphics):Unit = mysteryInvader.map(_.draw(g))

    private def setPanelAttributes {
        setBorder(javax.swing.BorderFactory.createTitledBorder("SI"))
        setToolTipText("")
        setFont(new Font("Waree", 1, 15))
        setName("mainPanel")
        setDoubleBuffered(true)
        setBackground(Color.BLACK)

        setBorder(javax.swing.BorderFactory.createTitledBorder(" SI "))

        val mainCanvasLayout = new org.jdesktop.layout.GroupLayout(this)
        setLayout(mainCanvasLayout)

        mainCanvasLayout
        .setHorizontalGroup(mainCanvasLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(0, PREFERRED_WIDTH, java.lang.Short.MAX_VALUE))


        mainCanvasLayout
        .setVerticalGroup(mainCanvasLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                          .add(0, PREFERRED_HEIGHT, java.lang.Short.MAX_VALUE))

        setFocusable(true)
        addKeyListener(new KeyBoardAdapter())
    }
}
