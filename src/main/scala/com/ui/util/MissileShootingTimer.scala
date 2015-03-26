package com.ui.util

object MissileShootingTimer extends Timer {

    private[this] var lastTimMissileFired:Long   = 0L

    override def setLastInvocationTime(t: Long): Unit = lastTimMissileFired = t

    override val timerDelay: Long = 100

    override def lastInvocationTime: Long = lastTimMissileFired

    def isTimeToShootOneMissile(now:Long):Boolean = isTime(now)
}
