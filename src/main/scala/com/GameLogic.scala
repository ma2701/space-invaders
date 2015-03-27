package com

object GameLogic {
    val REQUIRED_POINTS_FOR_EXTRA_LIFE: Int = 10000
    val INITIAL_NUM_LIVES                     = 3
    val INITIAL_SCORE                       = 0
    val INITIAL_GAME_LEVEL                  = 0
    
}
case class GameLogic(val livesLeft:Int   = GameLogic.INITIAL_NUM_LIVES,
                     val currentScore:Int= GameLogic.INITIAL_SCORE, 
                     val level:Int       = GameLogic.INITIAL_GAME_LEVEL) {
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
