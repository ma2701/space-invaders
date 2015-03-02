package com.ui.util


object MainThreadDelayUtil {

    def calculateThreadSleepTime(startTimeBeforePaintOp:Long, delay:Long ):Long = {
        val timeDiff = System.currentTimeMillis() - startTimeBeforePaintOp
        val sleep    = delay  - timeDiff

        if(sleep < 0) 1 else  sleep
    }

}
