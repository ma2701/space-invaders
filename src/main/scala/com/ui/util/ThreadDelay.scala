package com.ui.util


object ThreadDelay {

    def calculateThreadSleepTime(startTimeBeforePainOp:Long, delay:Long ):Long = {
        val timeDiff = System.currentTimeMillis() - startTimeBeforePainOp
        val sleep    = delay  - timeDiff

        if(sleep < 0) 1 else  sleep
    }

}
