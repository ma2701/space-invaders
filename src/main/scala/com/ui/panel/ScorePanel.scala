package com.ui.panel

import javax.swing.{JLabel, JPanel}
import java.awt.{Color, Graphics, Font}

object ScorePanel extends JPanel {

     setBorder(javax.swing.BorderFactory.createTitledBorder("S C O R E"))
     setToolTipText("")
     setFont(new Font("Waree", 1, 15))
     setName("mainPanel")
 
 
     val score = new JLabel
     score.setForeground(Color.RED)
     score.setText("")
     score.getAccessibleContext.setAccessibleName("score")

     val mainPanelLayout= new org.jdesktop.layout.GroupLayout(this)
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
                                 .add(score)).addContainerGap(30, java.lang.Short.MAX_VALUE)))


    override def paintComponent(g:Graphics ):Unit = {
        super.paintComponent(g)
    }

    def updateScore(currScore:Int ):Unit = {
        score.setText(s"${currScore}")
        repaint()
    }
 }
