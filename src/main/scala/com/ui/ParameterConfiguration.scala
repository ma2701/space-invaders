package com.ui

sealed trait ParameterConfiguration {
    val minRequiredPoints   : Int
    val bombDropRate        : Int // in pixels
    val invaderArmyXDelta   : Int // in pixels
    val invaderArmyYDelta   : Int // in pixels
    val mysteryInvaderXDelta: Int // in pixels
    val missileYDelta       : Int // in pixels
    val playerXDelta        : Int // in pixels 
}

object Easy extends ParameterConfiguration {
    override val minRequiredPoints: Int = 0

    override val bombDropRate        : Int = 3
    override val invaderArmyXDelta   : Int = 15
    override val invaderArmyYDelta   : Int = 20
    override val mysteryInvaderXDelta: Int = 1
    override val missileYDelta       : Int = 3
    override val playerXDelta        : Int = 20
}

object Moderate extends ParameterConfiguration {
    override val minRequiredPoints: Int = 5000

    override val bombDropRate        : Int = 4
    override val invaderArmyXDelta   : Int = 20
    override val invaderArmyYDelta   : Int = 25
    override val mysteryInvaderXDelta: Int = 2
    override val missileYDelta       : Int = 3
    override val playerXDelta        : Int = 20
}

object Hard extends ParameterConfiguration {
    override val minRequiredPoints: Int = 10000

    override val bombDropRate        : Int = 5
    override val invaderArmyXDelta   : Int = 30
    override val invaderArmyYDelta   : Int = 35
    override val mysteryInvaderXDelta: Int = 4
    override val missileYDelta       : Int = 3
    override val playerXDelta        : Int = 20
}

object Nirvana extends ParameterConfiguration {
    override val minRequiredPoints: Int = 20000

    override val bombDropRate        : Int = 10
    override val invaderArmyXDelta   : Int = 45
    override val invaderArmyYDelta   : Int = 50
    override val mysteryInvaderXDelta: Int = 6
    override val missileYDelta       : Int = 3
    override val playerXDelta        : Int = 20
}

object GameConfiguration {
    private[this] var currConfig: ParameterConfiguration = Easy

    def currentConfig = currConfig

    def setGameDifficulty(pnts: Int) {
        pnts match {
            case n if (isEasy(n)) => currConfig = Easy
            case n if (isModerate(n)) => currConfig = Moderate
            case n if (isHard(n)) => currConfig = Hard
            case _ => currConfig = Nirvana
        }
    }

    def reset  = currConfig = Easy

    private def isHard(n: Int): Boolean =
        n >= Hard.minRequiredPoints && n <= Nirvana.minRequiredPoints - 1


    private def isModerate(n: Int): Boolean =
        n >= Moderate.minRequiredPoints && n <= Hard.minRequiredPoints - 1


    private def isEasy(n: Int): Boolean =
        n >= Easy.minRequiredPoints && n <= Moderate.minRequiredPoints - 1

}