package com.ui

import org.scalatest.FunSuite
import GameLogic.REQUIRED_POINTS_FOR_EXTRA_LIFE

class GameLogicTest extends FunSuite {

    val oneLessThanRequiredPoints: Int = REQUIRED_POINTS_FOR_EXTRA_LIFE - 1
    val oneMoreThanRequiredPoints: Int = REQUIRED_POINTS_FOR_EXTRA_LIFE + 1
    val doubleTheRequiredPoints: Int   = REQUIRED_POINTS_FOR_EXTRA_LIFE * 2

    test("Given space invader game a user gets three lives") {
        val gameLogic = new GameLogic
        
        assertResult(3){
            gameLogic.livesLeft
        }
    }

    test("Given that the player is shot once then livesLeft returns 2 lives remaining") {
        val gameLogic = new GameLogic

        assertResult(2){
            gameLogic.playerShotOnce.livesLeft
        }
    }

    test("Given that the player is shot twice then livesLeft returns 1 life remaining") {
        val gameLogic = new GameLogic

        assertResult(1){
            gameLogic
            .playerShotOnce
            .playerShotOnce.livesLeft
        }
    }

    test("Given that the player is shot three times then livesLeft no life left") {
        val gameLogic = new GameLogic

        assertResult(0){
            gameLogic
            .playerShotOnce
            .playerShotOnce
            .playerShotOnce
            .livesLeft
        }
    }

    test("Given that the player is shot three times then isGameOver returns true") {
        val gameLogic = new GameLogic

        assert(gameLogic
               .playerShotOnce
               .playerShotOnce
               .playerShotOnce
               .isGameOver)
    }

    test("Given player when player shoots no invaders then currentScore returns 0") {
        val gameLogic = new GameLogic

        assertResult(0){
            gameLogic.currentScore
        }
    }

    test("Given player when player shoots one invader worth 20 pts then currentScore returns 20") {
        val gameLogic = new GameLogic

        assertResult(20){
            gameLogic.setScore(20).currentScore
        }
    }

    test("Given player when player shoots two invaders worth 20 pts then currentScore returns 40") {
        val gameLogic = new GameLogic

        assertResult(40){
            gameLogic
            .setScore(20)
            .setScore(20)
            .currentScore
        }
    }

    test("Given player when player score is reaches POINTS_FOR_EXTRA_LIFE then extra life is given to player") {
        val gameLogic = new GameLogic(0, oneLessThanRequiredPoints).setScore(10)

        assertResult(1){
            gameLogic
            .livesLeft
        }
    }

    test("Given player when player score is reaches POINTS_FOR_EXTRA_LIFE then game is moved next level") {
        val gameLogic = new GameLogic(0, oneLessThanRequiredPoints)

        assert(0===gameLogic.level)

        assertResult(1){
            gameLogic.setScore(1)
            .level
        }

        assertResult(2) {
            gameLogic.setScore(oneMoreThanRequiredPoints).level
        }

        assertResult(3) {
            gameLogic.setScore(doubleTheRequiredPoints+1).level
        }
    }

    test("Given player when player score is reaches POINTS_FOR_EXTRA_LIFE and player is shot then no change number of lives") {
        val gameLogic = new GameLogic(3, oneLessThanRequiredPoints).playerShotOnce.setScore(1)

        assert(1 === gameLogic.level )

        assert(3 === gameLogic.livesLeft)

    }

}
