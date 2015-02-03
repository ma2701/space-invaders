package com.ui.gameelement.invader

sealed trait InvaderArmyMood

object Mood {

    case object Excited extends InvaderArmyMood

    case object Normal extends InvaderArmyMood

}
