package com.ui

import org.scalatest.FunSuite

class GameLogicTest extends FunSuite {
    
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
}
