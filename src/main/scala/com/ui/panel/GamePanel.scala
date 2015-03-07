package com.ui.panel

import javax.swing.JPanel

import java.awt._

import com.ui.util.MainThreadDelayUtil._
import com.ui.SpaceInvaderGame
import java.awt.Color
import java.awt.Graphics
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent
import com.ui.gameelement.barricade.Barricades
import com.ui.gameelement.player.Player
import com.ui.gameelement.missile.MissilesInFlight
import com.ui.gameelement.invader.InvaderArmy
import com.ui.gameelement.bomb.DroppingBombs
import com.ui.gameelement.GameElementPositionDirector

object GamePanel extends JPanel with Runnable with ActionListener {

    private val SCREEN_REFRESH_RATE_IN_MILLIS = 2

    private val PREFERRED_WIDTH : Int = 878
    private val PREFERRED_HEIGHT: Int = 600

    private var animator: Thread = null
    private val spaceInvaderGame = new SpaceInvaderGame

    setPanelAttributes

    override def paintComponent(g: Graphics): Unit = {

        super.paintComponent(g)

        val gameState = spaceInvaderGame.updatedGameElements(new GameElementPositionDirector(this.getWidth, this.getHeight))

        displayBarricades(gameState.barricades, g)

        displayShooter(gameState.player, g)

        displayMissiles(gameState.missilesInFlight, g)

        displayBombs(gameState.droppingBombs, g)

        displayInvaderArmy(gameState.invaderArmy, g)

        displayTotalDeathCount(spaceInvaderGame.invaderKillCount, g)
    }

    override
    def run(): Unit = mainGameLoop

    private def mainGameLoop: Unit = {
        var beforeTime = System.currentTimeMillis()

        do {

            repaint()

            sleep(beforeTime)

            beforeTime = System.currentTimeMillis()

        } while (true)
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
        super.addNotify();

        animator = new Thread(this);
        animator.start();
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

    private def displayBarricades(barricades:Barricades, g:Graphics):Unit = barricades.draw(g)
    private def displayShooter (shooter:Player, g:Graphics):Unit = shooter.draw(g)
    private def displayMissiles (missiles:MissilesInFlight, g:Graphics):Unit = missiles.draw(g)
    private def displayBombs (bombs:DroppingBombs, g:Graphics):Unit = bombs.draw(g)
    private def displayInvaderArmy (invaderArmy:InvaderArmy, g:Graphics):Unit = invaderArmy.draw(g)
    private def displayTotalDeathCount(count:Int, g: Graphics): Unit = {
        count match {
            case i if(i <= 10)=> g.setColor(Color.GREEN)
            case i if(i <= 30)=> g.setColor(Color.ORANGE)
            case i if(i > 30)=>  g.setColor(Color.RED)
        }

        g.drawString(s"Kill Count: ${count}",3, this.getHeight - 10)
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
