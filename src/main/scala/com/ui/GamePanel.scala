package com.ui

import javax.swing.{JLabel, JPanel}

import java.awt.{Point, Graphics, Font}
import com.ui.util.{Random2DPoint}
import com.ui.character.{ArmyDirection, ArmyCommander, InvaderArmy}

import com.ui.util.ThreadDelay._

object GamePanel {
    private val DELAY_IN_MILLIS = 10

    private val PREFERRED_WIDTH: Int  = 291
    private val PREFERRED_HEIGHT: Int = 600
}

class GamePanel extends JPanel with Runnable {
    import GamePanel._

    private var animator: Thread = null
    private val random2DPointGenerator = new Random2DPoint(0 to PREFERRED_WIDTH, 0 to PREFERRED_HEIGHT )

    private val invaderArmy  = new InvaderArmy(ArmyCommander.formAnArmy(new Point(0,0)))

    setBorder(javax.swing.BorderFactory.createTitledBorder("SI"))
    setToolTipText("")
    setFont(new Font("Waree", 1, 15))
    setName("mainPanel")
    setDoubleBuffered(true)


    setBorder(javax.swing.BorderFactory.createTitledBorder(" SI "))

    val mainCanvasLayout = new org.jdesktop.layout.GroupLayout(this)
    setLayout(mainCanvasLayout)

    mainCanvasLayout
    .setHorizontalGroup(mainCanvasLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                         .add(0, PREFERRED_WIDTH, java.lang.Short.MAX_VALUE))


    mainCanvasLayout
    .setVerticalGroup(mainCanvasLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                         .add(0, PREFERRED_HEIGHT, java.lang.Short.MAX_VALUE))


    override def paintComponent(g: Graphics): Unit = {
        super.paintComponent(g)

        val width: Int = this.getWidth
        val height: Int = this.getHeight

        val point = ArmyDirection.whereToNext(width, height)

        invaderArmy.moveTo(point).drawArmy(g)
    }

    override def run(): Unit = {

        var beforeTime = System.currentTimeMillis()

        do {

            repaint()

            sleep(beforeTime)

            beforeTime = System.currentTimeMillis()

        } while(true)
    }

    private def sleep(beforeTime: Long) {
        try {
            Thread.sleep(calculateThreadSleepTime(beforeTime, DELAY_IN_MILLIS));
        } catch {
            case e: InterruptedException => println("Interrupted: " + e.getMessage());
        }
    }

    override def addNotify: Unit = {
        super.addNotify();

        animator = new Thread(this);
        animator.start();
    }

}
