package com.ui

import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter

class GameConfigurationTest extends FunSuite with BeforeAndAfter {

    before {
        GameConfiguration.reset
    }

    test("given initial state then the game starts with Easy config") {
        assert(Easy  ==  GameConfiguration.currentConfig)
    }

    test("given player has earned some point when points not enough to move to Moderate then currentConfig returns Easy") {
        GameConfiguration.setGameDifficulty(10)
        assert(Easy  ==  GameConfiguration.currentConfig)
    }

    test("given player has earned some point when points enough to move to Moderate then currentConfig returns Moderate") {
        GameConfiguration.setGameDifficulty(Moderate.minRequiredPoints)
        assert(Moderate ==  GameConfiguration.currentConfig)
    }

    test("given player has earned some point when points enough to move to Nirvana then currentConfig returns Nirvana") {
        GameConfiguration.setGameDifficulty(Nirvana.minRequiredPoints)
        assert(Nirvana  ==  GameConfiguration.currentConfig)
    }

}
