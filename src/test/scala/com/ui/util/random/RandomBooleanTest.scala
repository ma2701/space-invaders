package com.ui.util.random

import org.scalatest.FunSuite

class RandomBooleanTest extends FunSuite {


    test("given a random boolean generator then can generate random boolean values") {
        val rand = new RandomBoolean

        val vals = 1.to(100).map { i =>
            rand.randomTrueOrFalse
        }

        assertResult(100){
            vals.filter(_ ==true).size+vals.filter( _ ==false).size
        }
    }

}
