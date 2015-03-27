package com.util

object BombDropTimer extends Timer {
    private[this] var lastTimeDroppedADuece: Long   = 0L

    override def setLastInvocationTime(t: Long): Unit = lastTimeDroppedADuece = t

    override val timerDelay: Long = 3500

    override def lastInvocationTime: Long = lastTimeDroppedADuece

    def isTimeToDropABomb(now:Long):Boolean = isTime(now)
}
