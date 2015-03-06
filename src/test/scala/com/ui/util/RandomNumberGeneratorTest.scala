package com.ui.util

import org.scalatest.FunSuite


class RandomNumberGeneratorTest extends FunSuite {

    test("getting a random number in a range") {
        val range = 0 to 10
        val rand = new RandomNumberGenerator

        assert(rand.next(range).isInstanceOf[Int])
    }

    test("given a random number generator then can generate random boolean values") {
        val rand = new RandomNumberGenerator

        val vals = 1.to(100).map { i =>
            rand.randomTrueOrFalse
        }

        assertResult(100){
            vals.filter(_ ==true).size+vals.filter( _ ==false).size
        }
    }

}
