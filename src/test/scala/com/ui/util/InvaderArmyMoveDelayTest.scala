package com.ui.util

import org.scalatest.FunSuite

class InvaderArmyMoveDelayTest extends FunSuite {

    test("given n seconds passed since last redraw then drawDelay should return false") {
        val now = System.currentTimeMillis();

        assert(InvaderArmyMoveDelay.isTimeToMoveArmy(now))

        val notEnoughTimePassed = ( now + InvaderArmyMoveDelay.drawDelayInMillis) - 1

        assert(!InvaderArmyMoveDelay.isTimeToMoveArmy(notEnoughTimePassed ))

        val enoughTimePasses = ( now + InvaderArmyMoveDelay.drawDelayInMillis)

        assert(InvaderArmyMoveDelay.isTimeToMoveArmy(enoughTimePasses ))
    }

}

