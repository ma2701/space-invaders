package com.ui.panel

import javax.swing.{JLabel, JPanel}
import java.awt.{Point, Graphics, Font}
import com.ui.gameelement.Displayable
import com.ui.gameelement.player.{PlayerPositionDirector, Player}


object LivesPanel extends JPanel {

    setBorder(javax.swing.BorderFactory.createTitledBorder("L I V E S"))
    setToolTipText("")
    setFont(new Font("Waree", 1, 15))
    setName("mainPanel")

    private[this] var livesLeft = 3


    val livesCount = new JLabel
    livesCount.setText("")
    livesCount.getAccessibleContext.setAccessibleName("livesCountLabel")

    val mainPanelLayout = new org.jdesktop.layout.GroupLayout(this)
    setLayout(mainPanelLayout)

    mainPanelLayout
    .setHorizontalGroup(
            mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(mainPanelLayout.createSequentialGroup.add(22, 22, 22)
                 .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                 .add(livesCount, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                 .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE)))

    mainPanelLayout
    .setVerticalGroup(mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                      .add(mainPanelLayout.createSequentialGroup.addContainerGap
                           .add(mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(livesCount)).addContainerGap(40, java.lang.Short.MAX_VALUE)))


    override def paintComponent(g: Graphics): Unit = {
        super.paintComponent(g)
        displayLives(g)
    }

    def updateLives(livesLeft: Int): Unit = {
        this.livesLeft = livesLeft
        repaint()
    }

    private def displayLives(g:Graphics):Unit = {
        val startingPoint = new Point(this.getWidth/16,30)
        PlayerPositionDirector.calculatePlayerPositionsOnLivesPanel(startingPoint, livesLeft)
        .foreach { point=>
            val player = new Player(point)
            player.draw(g)
        }
    }
}
