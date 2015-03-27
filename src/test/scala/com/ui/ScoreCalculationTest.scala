package com.ui

import org.scalatest.FunSuite
import com.ui.gameelement.invader.types.CrabInvader
import java.awt.Point
import com.ScoreCalculation

class ScoreCalculationTest extends FunSuite {

    test("given no invader by player missiles then calculateScore returns 0") {
        assertResult(0) {
            ScoreCalculation.calculatePointsWon(Nil)
        }
    }

    test("given 1 invader hit that is worth 30 pts then calculateScore returns 30") {
        val invaderHitByMissile = new CrabInvader(new Point(0,0))

        assertResult(30) {
            ScoreCalculation.calculatePointsWon(Seq(invaderHitByMissile))
        }
    }
}
