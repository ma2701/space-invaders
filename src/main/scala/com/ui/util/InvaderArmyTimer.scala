package com.ui.util

object InvaderArmyTimer extends Timer {

    private[this] var lastRedraw:Long = 0L

    override def setLastInvocationTime(t: Long): Unit = lastRedraw = t

    override val timerDelay: Long = 333

    override def lastInvocationTime= lastRedraw

    def isTimeToMoveArmy(now:Long):Boolean = isTime(now)
}
