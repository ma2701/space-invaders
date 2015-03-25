package com.ui

object GameLogic {
    val REQUIRED_POINTS_FOR_EXTRA_LIFE: Int = 10000
}
case class GameLogic(val livesLeft:Int = 3, val currentScore:Int=0, val level:Int = 0 ) {
    import GameLogic._
    def playerShotOnce: GameLogic      = copy(livesLeft = livesLeft - 1)

    def isGameOver:Boolean             = livesLeft == 0

    def setScore(pts :Int ):GameLogic  = {
        val lvl = (pts + currentScore) / REQUIRED_POINTS_FOR_EXTRA_LIFE
        if(level < lvl )
            copy(livesLeft + 1, pts + currentScore, lvl)
        else
            copy(currentScore =  pts + currentScore)
    }

    override def toString:String  = s"Lives : ${livesLeft} current score: ${currentScore} level: ${level}"
}
