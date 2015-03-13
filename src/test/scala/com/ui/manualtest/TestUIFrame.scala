package com.ui.manualtest

import javax.swing.JFrame
import javax.swing.JPanel
import java.awt._
import com.ui.gameelement.Displayable
import org.jdesktop.layout.GroupLayout
import com.ui.gameelement.invader.types.ExcitedOctopusInvader

class TestUIFrame extends JFrame {
    setResizable(false)

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)

    initAllComponents
    pack()

    private def initAllComponents: Unit = {
        val panel = new TestUIPanel(new ExcitedOctopusInvader(new Point(10,10)))

        val layout: GroupLayout = new GroupLayout(getContentPane)


        getContentPane.setLayout(layout)


        layout.setHorizontalGroup(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                  .add(layout.createSequentialGroup.addContainerGap()
                                       .add(panel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE).addContainerGap))

        layout.setVerticalGroup(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(layout.createSequentialGroup.add(0, 0, 0)
                                     .add(panel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                     .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 0, java.lang.Short.MAX_VALUE)))


    }
}

class TestUIPanel(item:Displayable) extends JPanel {
    private val PREFERRED_WIDTH : Int = 300
    private val PREFERRED_HEIGHT: Int = 200

    setPanelAttributes

    repaint()

    override def paintComponent(g: Graphics): Unit = {
        super.paintComponent(g)
        item.draw(g)
    }

    private def setPanelAttributes {
        setDoubleBuffered(true)
        setBackground(Color.BLACK)

        val mainCanvasLayout = new org.jdesktop.layout.GroupLayout(this)
        setLayout(mainCanvasLayout)

        mainCanvasLayout
        .setHorizontalGroup(mainCanvasLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(0, PREFERRED_WIDTH, java.lang.Short.MAX_VALUE))


        mainCanvasLayout
        .setVerticalGroup(mainCanvasLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                          .add(0, PREFERRED_HEIGHT, java.lang.Short.MAX_VALUE))

        setFocusable(true)
    }
}

