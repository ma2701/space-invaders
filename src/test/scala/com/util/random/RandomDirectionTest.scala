package com.util.random

import org.scalatest.FunSuite
import com.ui.gameelement.invader.MysteryInvaderDirection.{LeftToRight, RightToLeft}

class RandomDirectionTest extends FunSuite {

    test("given a random direction generator then randomLeftOrRight returns a random left or right") {
        val rand = new RandomDirection

        val vals = 1.to(100).map { i =>
            rand.randomRightWithOneInNChance(2)
        }

        assertResult(100){
            vals.filter(_ ==RightToLeft).size+vals.filter( _ ==LeftToRight).size
        }
    }
}
