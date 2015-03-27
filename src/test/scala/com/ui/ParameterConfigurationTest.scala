package com.ui

import org.scalatest.FunSuite

class ParameterConfigurationTest extends FunSuite {

    test("level zero requires no points"){
        assert(0 === Easy.minRequiredPoints)
    }

    test("given level 0 then all game configuration can be obtained"){
        assert(3===Easy.bombDropRate)
        assert(15===Easy.invaderArmyXDelta)
        assert(20===Easy.invaderArmyYDelta)
    }
}
