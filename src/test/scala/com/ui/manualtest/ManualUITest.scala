package com.ui.manualtest

object ManualUITest extends App {
    override
    def main(args: Array[String]) :Unit =  {
        val si = new TestUIFrame

        java.awt.EventQueue.invokeLater(new Runnable {
            def run {
                si.setVisible(true)
            }
        })
    }
}
