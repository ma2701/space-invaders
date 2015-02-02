package com.ui.panel

import javax.swing.JPanel

import java.awt._
import com.ui.invader.{ArmyCommander, InvaderArmy}
import com.ui.invader.InvaderArmyDirection._

import com.ui.util.ThreadDelay._
import com.ui.util.InvaderArmyMoveDelay._
import com.ui.{Player, Barricades}

object GamePanel {
    private val DELAY_IN_MILLIS = 2

    private val PREFERRED_WIDTH : Int = 878
    private val PREFERRED_HEIGHT: Int = 600
}

class GamePanel extends JPanel with Runnable {

    import GamePanel._

    private var animator: Thread = null
    private var invaderArmy      = new InvaderArmy(ArmyCommander.formAnArmy(new Point(0, 0)))
    private var barricades :Barricades= _
    private var player :Player= _

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


    override
    def paintComponent(g: Graphics): Unit = {
        super.paintComponent(g)

        val displayWindowBoundingBox = new Rectangle(0, 0, this.getWidth, this.getHeight / 2)

        displayBarricades(g, new Point(this.getWidth/5, this.getHeight - (this.getHeight/5)))
        displayPlayer(g,     new Point(this.getWidth/5, this.getHeight - (this.getHeight/9)))

        if (isTimeToMoveArmy(System.currentTimeMillis())) {
            val point = whereToNext(displayWindowBoundingBox, invaderArmy.getBoundingBox)

            invaderArmy = invaderArmy.moveTo(point)
            invaderArmy.drawArmy(g)

        } else {

            invaderArmy.drawArmy(g)
        }
    }

    def displayBarricades(g:Graphics, location:Point) {
        if(barricades==null)
            barricades = new Barricades(location)
        barricades.draw(g)
    }

    def displayPlayer(g:Graphics, location:Point) {
        if(player==null)
            player= new Player(location)
        player.draw(g)
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

    override def addNotify: Unit = {
        super.addNotify();

        animator = new Thread(this);
        animator.start();
    }

}
