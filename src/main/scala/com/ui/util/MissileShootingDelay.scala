package com.ui.util

object MissileShootingDelay {
    private[this] var lastTimMissileFired:Long   = 0L

    val missileFireDelayMillis     = 100

    def isTimeToShootOneMissile(now:Long):Boolean = {
        if( now - lastTimMissileFired >= missileFireDelayMillis) {
            lastTimMissileFired = now
            true
        }
        else false
    }
}
