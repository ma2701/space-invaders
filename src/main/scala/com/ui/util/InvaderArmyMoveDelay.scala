package com.ui.util

object InvaderArmyMoveDelay {
    private[this] var lastRedraw:Long   = 0L

    val drawDelayInMillis = 333

    def isTimeToMoveArmy(now:Long):Boolean = {
        if( now - lastRedraw >= drawDelayInMillis) {
            lastRedraw = now
            true
        }
        else false
    }
}
