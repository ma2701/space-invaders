package com.ui.util

import org.scalatest.FunSuite

class InvaderArmyMoveDelayTest extends FunSuite {

    test("given n seconds passed since last redraw then drawDelay should return false") {

        val lastYear = System.currentTimeMillis() - 31557600000L

        assert(InvaderArmyMoveDelay.isTimeToMoveArmy(lastYear))

        val notEnoughTimePassed = ( lastYear + InvaderArmyMoveDelay.drawDelayInMillis) - 1

        assert(!InvaderArmyMoveDelay.isTimeToMoveArmy(notEnoughTimePassed ))

        val enoughTimePasses = ( lastYear + InvaderArmyMoveDelay.drawDelayInMillis)

        assert(InvaderArmyMoveDelay.isTimeToMoveArmy(enoughTimePasses ))
    }

}

