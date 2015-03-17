package com.ui.panel

import javax.swing.JPanel

import java.awt._

import com.ui.util.MainThreadDelayUtil._
import com.ui.{GameLogic, SpaceInvaderGame}
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
import com.ui.gameelement.GameElementPositionManager
import com.ui.gameelement.player.types.Player

object GamePanel extends JPanel with Runnable with ActionListener {

    private val SCREEN_REFRESH_RATE_IN_MILLIS = 1

    private[this] val PREFERRED_WIDTH : Int = 878
    private[this] val PREFERRED_HEIGHT: Int = 600
    private[this] var animator: Thread = null
    private[this] var gameLogic:GameLogic = new GameLogic()

    private[this] var spaceInvaderGame = new SpaceInvaderGame

    setPanelAttributes

    override def paintComponent(g: Graphics): Unit = {

        super.paintComponent(g)

        val gameState = spaceInvaderGame.updatedGameElements(new GameElementPositionManager(getWidth, getHeight))

        if(gameState.isTimeToResetGame)
            spaceInvaderGame = spaceInvaderGame.resetAll

        gameLogic = if (gameState.elements.player.isHit && gameState.isTimeToResetGame) {
            gameLogic.playerShotOnce.setScore(gameState.score)
        } else {
            gameLogic.setScore(gameState.score)
        }

        GameStatusPanel.updateStats(gameLogic.livesLeft, gameLogic.currentScore)

        displayBarricades(gameState.elements.barricades, g)

        displayShooter(gameState.elements.player, g)

        displayMissiles(gameState.elements.missilesInFlight, g)

        displayBombs(gameState.elements.droppingBombs, g)

        displayInvaderArmy(gameState.elements.invaderArmy, g)
    }

    override
    def run(): Unit = mainGameLoop

    private def mainGameLoop: Unit = {
        var beforeTime = System.currentTimeMillis()

        do {

            repaint()

            sleep(beforeTime)

            beforeTime = System.currentTimeMillis()

        } while (!gameLogic.isGameOver)

        System.exit(0)
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


    private def displayGameOver(g:Graphics) {
        g.setColor(Color.RED)
        g.drawString("GAME OVER", this.getHeight/2 , this.getWidth /2 )
    }

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
