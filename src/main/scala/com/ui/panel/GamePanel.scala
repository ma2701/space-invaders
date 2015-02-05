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

object GamePanel {
    private val DELAY_IN_MILLIS = 2

    private val PREFERRED_WIDTH : Int = 878
    private val PREFERRED_HEIGHT: Int = 600
}

class GamePanel extends JPanel with Runnable with ActionListener {
    import GamePanel._

    private var animator: Thread = null
    private val spaceInvaderGame = new SpaceInvaderGame

    setPanelAttributes

    override
    def paintComponent(g: Graphics): Unit = {

        super.paintComponent(g)

        spaceInvaderGame.updatedGameElements(this.getWidth, this.getHeight, g)
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
            Thread.sleep(calculateThreadSleepTime(beforeTime, DELAY_IN_MILLIS));
        } catch {
            case e: InterruptedException => println("Interrupted: " + e.getMessage());
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
        addKeyListener(new TAdapter())
    }

    override
    def actionPerformed(e: ActionEvent): Unit = {

    }

    private class TAdapter extends KeyAdapter {

       override
       def keyReleased(e: KeyEvent) {
            e.getKeyCode match {
                case KeyEvent.VK_SPACE => println("stop firring...")
                case _ => println("Done care what this is ...")
            }
        }

        override
        def keyPressed(e:KeyEvent) {
            e.getKeyCode match {
                case KeyEvent.VK_SPACE =>
                    spaceInvaderGame.getShooterPosition.map(spaceInvaderGame.shootSingleMissileFrom)
                case _ => println("Done care what this is ...")
            }
        }
    }
}
