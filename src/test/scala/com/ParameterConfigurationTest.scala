package com

import org.scalatest.FunSuite

class ParameterConfigurationTest extends FunSuite {

    test("level zero requires no points"){
        assert(0 === Easy.minRequiredPoints)
    }

    test("given level 0 then all game configuration can be obtained"){
        assert(2===Easy.bombVelocity)
        assert(15===Easy.invaderArmyXVelocity)
        assert(20===Easy.invaderArmyYVelocity)
    }
}
