package com


object GameConfiguration {
    private[this] var currConfig: ParameterConfiguration = Easy

    def currentConfig = currConfig

    def setGameDifficulty(pnts: Int) {
        pnts match {
            case n if (isEasy(n))     => currConfig = Easy
            case n if (isModerate(n)) => currConfig = Moderate
            case n if (isHard(n))     => currConfig = Hard
            case _                    => currConfig  = Nirvana
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

sealed trait ParameterConfiguration {
    val minRequiredPoints       : Int
    val bombVelocity            : Int // in pixels
    val invaderArmyXVelocity    : Int // in pixels
    val invaderArmyYVelocity    : Int // in pixels
    val mysteryInvaderVelocity  : Int // in pixels
    val missileVelocity         : Int // in pixels
    val playerVelocity          : Int // in pixels
}

object Easy extends ParameterConfiguration {
    override val minRequiredPoints: Int = 0

    override val bombVelocity          : Int = 2
    override val invaderArmyXVelocity  : Int = 15
    override val invaderArmyYVelocity  : Int = 20
    override val mysteryInvaderVelocity: Int = 1
    override val missileVelocity       : Int = bombVelocity
    override val playerVelocity        : Int = 20
}

object Moderate extends ParameterConfiguration {
    override val minRequiredPoints: Int = 5000

    override val bombVelocity          : Int = 4
    override val invaderArmyXVelocity  : Int = 20
    override val invaderArmyYVelocity  : Int = 25
    override val mysteryInvaderVelocity: Int = 2
    override val missileVelocity       : Int = bombVelocity
    override val playerVelocity        : Int = 20
}

object Hard extends ParameterConfiguration {
    override val minRequiredPoints: Int = 10000

    override val bombVelocity          : Int = 5
    override val invaderArmyXVelocity  : Int = 30
    override val invaderArmyYVelocity  : Int = 35
    override val mysteryInvaderVelocity: Int = 4
    override val missileVelocity       : Int = bombVelocity
    override val playerVelocity        : Int = 20
}

object Nirvana extends ParameterConfiguration {
    override val minRequiredPoints: Int = 20000

    override val bombVelocity          : Int = 10
    override val invaderArmyXVelocity  : Int = 45
    override val invaderArmyYVelocity  : Int = 50
    override val mysteryInvaderVelocity: Int = 6
    override val missileVelocity       : Int = bombVelocity
    override val playerVelocity        : Int = 20
}
