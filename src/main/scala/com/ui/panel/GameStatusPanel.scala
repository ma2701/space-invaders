package com.ui.panel

import javax.swing.{JLabel, JPanel}
import java.awt.{Color, Point, Graphics, Font}
import com.ui.gameelement.Displayable
import com.ui.gameelement.player.{PlayerPositionDirector, Player}


object GameStatusPanel extends JPanel {

    setBorder(javax.swing.BorderFactory.createTitledBorder("S T A T S"))
    setToolTipText("")
    setFont(new Font("Waree", 1, 15))
    setName("mainPanel")

    private val textFont        = new Font("Verdana", Font.BOLD, 14)
    private[this] var livesLeft = 3
    private val score           = new JLabel
    score.setText("")
    score.getAccessibleContext.setAccessibleName("livesCountLabel")

    val mainPanelLayout = new org.jdesktop.layout.GroupLayout(this)
    setLayout(mainPanelLayout)

    mainPanelLayout
    .setHorizontalGroup(
            mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(mainPanelLayout.createSequentialGroup.add(22, 22, 22)
                 .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                 .add(score, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                 .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE)))

    mainPanelLayout
    .setVerticalGroup(mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                      .add(mainPanelLayout.createSequentialGroup.addContainerGap
                           .add(mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(score)).addContainerGap(40, java.lang.Short.MAX_VALUE)))


    override def paintComponent(g: Graphics): Unit = {
        super.paintComponent(g)
        displayLives(g)
    }

    def updateStats(lives: Int, pnts:Int): Unit = {
        livesLeft = lives
        score.setForeground(Color.RED)
        score.setFont(textFont)
        score.setText(s"SC0RE: ${pnts}")
        repaint()
    }

    private def displayLives(g:Graphics):Unit = {
        val startingPoint = new Point(this.getWidth/2,25)
        PlayerPositionDirector.calculatePlayerPositionsOnLivesPanel(startingPoint, livesLeft)
        .foreach { point=>
            val player = new Player(point)
            player.draw(g)
        }
    }
}
