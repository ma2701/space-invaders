package com.ui.panel

import javax.swing.JPanel

import java.awt._

import com.ui.util.ThreadDelay._
import com.ui.SpaceInvaderGame
import java.awt.Color
import java.awt.Graphics
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent
import com.ui.gameelement.barricade.Barricades
import com.ui.gameelement.shooter.Shooter
import com.ui.gameelement.missile.MissilesInFlight
import com.ui.gameelement.invader.InvaderArmy

object GamePanel extends JPanel with Runnable with ActionListener {

    private val DELAY_IN_MILLIS = 1

    private val PREFERRED_WIDTH : Int = 878
    private val PREFERRED_HEIGHT: Int = 600

    private var animator: Thread = null
    private val spaceInvaderGame = new SpaceInvaderGame

    setPanelAttributes

    override def paintComponent(g: Graphics): Unit = {

        super.paintComponent(g)

        val gameState = spaceInvaderGame.updatedGameElements(this.getWidth, this.getHeight)

        displayBarricades(gameState.barricades, g)

        displayShooter(gameState.shooter, g)

        displayMissiles(gameState.missiles, g)

        displayMissiles(gameState.invaderArmy, g)

        displayTotalDeathCount(gameState.totalKilledInvaders, g)
    }

    override
    def run(): Unit = {
        var beforeTime = System.currentTimeMillis()

        do {

            repaint()

            sleep(beforeTime)

            beforeTime = System.currentTimeMillis()

        } while (true)
    }

    private def sleep(beforeTime: Long) {
        try {
            Thread.sleep(calculateThreadSleepTime(beforeTime, DELAY_IN_MILLIS))
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

    override
    def actionPerformed(e: ActionEvent): Unit = {

    }

    private class KeyBoardAdapter extends KeyAdapter {
        override
        def keyPressed(e:KeyEvent) {
            e.getKeyCode match {
                case KeyEvent.VK_SPACE =>
                    spaceInvaderGame.getShooterPosition.map(spaceInvaderGame.shootSingleMissileFrom)
                case KeyEvent.VK_RIGHT =>
                    spaceInvaderGame.moveShooterRight(getWidth)
                case KeyEvent.VK_LEFT  =>
                    spaceInvaderGame.moveShooterLeft
                case _ => Unit
            }
        }
    }

    private def displayBarricades(barricades:Barricades, g:Graphics):Unit = barricades.draw(g)
    private def displayShooter (shooter:Shooter, g:Graphics):Unit = shooter.draw(g)
    private def displayMissiles (missiles:MissilesInFlight, g:Graphics):Unit = missiles.draw(g)
    private def displayMissiles (invaderArmy:InvaderArmy, g:Graphics):Unit = invaderArmy.draw(g)
    private def displayTotalDeathCount(count:Int, g: Graphics): Unit = {
        count match {
            case i if(i <= 10)=> g.setColor(Color.GREEN)
            case i if(i <= 30)=> g.setColor(Color.ORANGE)
            case i if(i > 30)=>  g.setColor(Color.RED)
        }

        g.drawString(s"Kill Count: ${count}",3, this.getHeight - 10)
    }
}
