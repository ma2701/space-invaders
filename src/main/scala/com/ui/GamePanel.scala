package com.ui

import javax.swing.{JLabel, JPanel}
import java.awt.{Graphics, Font}
import com.ui.util.{ThreadDelay, Random2DPoint}


object GamePanel{
    private val DELAY_IN_MILLIS = 500

    private val PREFERRED_WIDTH: Int  = 291
    private val PREFERRED_HEIGHT: Int = 600
}

class GamePanel extends JPanel with Runnable {
    import GamePanel._

    private var animator: Thread = null
    private val random2DPointGenerator = new Random2DPoint(0 to PREFERRED_WIDTH, 0 to PREFERRED_HEIGHT )

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

        val randomPlaceOnScreen = random2DPointGenerator.nextPoint

        val middleOfScreenX = (randomPlaceOnScreen.x )
        val middleOfScreenY = (randomPlaceOnScreen.y )


        val invader = new Invader(middleOfScreenX, middleOfScreenY)

        invader.draw(g)
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
            Thread.sleep(ThreadDelay.calculateThreadSleepTime(beforeTime, DELAY_IN_MILLIS));
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
