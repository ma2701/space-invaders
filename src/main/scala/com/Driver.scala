package com

import com.ui.SpaceInvadersUI

object Driver extends App {

    override
    def main(args: Array[String]) :Unit =  {
        val si = new SpaceInvadersUI

        java.awt.EventQueue.invokeLater(new Runnable {
            def run {
                si.setVisible(true)
            }
        })
    }
}