package com.ui.panel

import javax.swing.{JLabel, JPanel}
import java.awt.Font


class LivesPanel extends JPanel {

    val mainPanel = new JPanel()

    mainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Lives"))
    mainPanel.setToolTipText("")
    mainPanel.setFont(new Font("Waree", 1, 15))
    mainPanel.setName("mainPanel")


    val livesCountLabel = new JLabel
    livesCountLabel.setText("------------------")
    livesCountLabel.getAccessibleContext.setAccessibleName("livesCountLabel")

    val livesLeftLabel = new JLabel
    livesLeftLabel.setText("      Lives left: ")
    livesLeftLabel.setName("livesLeftLabel")

    val mainPanelLayout = new org.jdesktop.layout.GroupLayout(mainPanel)
    mainPanel.setLayout(mainPanelLayout)

    mainPanelLayout
    .setHorizontalGroup(
            mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(mainPanelLayout.createSequentialGroup.add(455, 455, 455)
                 .add(livesLeftLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                 .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                 .add(livesCountLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                 .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE)))

    mainPanelLayout
    .setVerticalGroup(mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                      .add(mainPanelLayout.createSequentialGroup.addContainerGap
                           .add(mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(livesLeftLabel).add(livesCountLabel)).addContainerGap(69, java.lang.Short.MAX_VALUE)))


}
