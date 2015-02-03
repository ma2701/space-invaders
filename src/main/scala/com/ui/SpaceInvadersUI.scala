package com.ui

import org.jdesktop.layout._
import javax.swing.JFrame
import com.ui.panel.{ScorePanel, LivesPanel, GamePanel}

class SpaceInvadersUI(val scorePanel:ScorePanel,
                      val gamePanel:GamePanel,
                      val livesPanel:LivesPanel) extends javax.swing.JFrame {

    setResizable(false)

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)

    initAllComponents

    pack


    private def initAllComponents:Unit = {
        val layout: GroupLayout = new GroupLayout(getContentPane)


        getContentPane.setLayout(layout)


        layout.setHorizontalGroup(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createSequentialGroup.addContainerGap()
                                    .add(gamePanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE).addContainerGap)
                                    .add(livesPanel.mainPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE)
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createSequentialGroup.addContainerGap
                                    .add(scorePanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE).addContainerGap)))


        layout.setVerticalGroup(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createSequentialGroup.add(116, 116, 116)
                                    .add(gamePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 0, java.lang.Short.MAX_VALUE)
                                    .add(livesPanel.mainPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createSequentialGroup.add(22, 22, 22)
                                    .add(scorePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(0, java.lang.Short.MAX_VALUE))))


    }

}
