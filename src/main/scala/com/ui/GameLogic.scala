package com.ui

class GameLogic(val livesLeft:Int = 1, val currentScore:Int=0) {

    def playerShotOnce: GameLogic      = new GameLogic(livesLeft - 1 , currentScore)

    def isGameOver:Boolean             = livesLeft == 0

    def setScore(pts :Int ):GameLogic  = new  GameLogic(livesLeft, pts + currentScore)
}
