package com.ui.util

object BombDropDelay {
    private[this] var lastTimeDroppedADuece: Long   = 0L
    private[this] val bombDropDelayMillis           = 3500

    def isTimeToDropABomb(now:Long):Boolean = {
        if( now - lastTimeDroppedADuece >= bombDropDelayMillis) {
            lastTimeDroppedADuece = now
            true
        }
        else false
    }
}
