package com.ui

object Driver extends App {

    override
    def main(args: Array[String]) :Unit =  {
        val si = new SpaceInvadersUI( new ScorePanel, new GamePanel, new LivesPanel )

        java.awt.EventQueue.invokeLater(new Runnable {
            def run {
                si.setVisible(true)
            }
        })
    }
}