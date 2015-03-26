package com.ui.util

import org.scalatest.FunSuite

class InvaderArmyTimerTest extends FunSuite {

    test("given n seconds passed since last redraw then drawDelay should return false") {
        InvaderArmyTimer.reset

        val lastYear = System.currentTimeMillis() - 31557600000L

        assert(InvaderArmyTimer.isTimeToMoveArmy(lastYear))

        val notEnoughTimePassed = ( lastYear + InvaderArmyTimer.timerDelay) - 1

        assert(!InvaderArmyTimer.isTimeToMoveArmy(notEnoughTimePassed ))

        val enoughTimePasses = ( lastYear + InvaderArmyTimer.timerDelay)

        assert(InvaderArmyTimer.isTimeToMoveArmy(enoughTimePasses ))
    }

}

