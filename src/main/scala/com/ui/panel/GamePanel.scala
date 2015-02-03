package com.ui.panel

import javax.swing.JPanel

import java.awt._

import com.ui.util.ThreadDelay._
import com.ui.SpaceInvaderGame

object GamePanel {
    private val DELAY_IN_MILLIS = 2

    private val PREFERRED_WIDTH : Int = 878
    private val PREFERRED_HEIGHT: Int = 600
}

class GamePanel extends JPanel with Runnable {
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
    }
}
