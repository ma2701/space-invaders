package com.ui.gameelement.invader

sealed trait MysteryInvaderMovementDirection

object MysteryInvaderDirection {
    case object RightToLeft extends MysteryInvaderMovementDirection
    case object LeftToRight extends MysteryInvaderMovementDirection
}

