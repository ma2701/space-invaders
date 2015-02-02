package com.ui

import javax.swing.JFrame
import com.ui.panel.ScorePanel

trait UIBasedTest {

    protected def show(frameToDisplay:JFrame):Unit = {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable {
            def run {
                frameToDisplay.setVisible(true)
            }
        })
    }
    
}
