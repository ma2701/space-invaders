package com.ui.gameelement.invader

sealed trait MovementDirection

object Direction {

    case object Up extends MovementDirection

    case object Left extends MovementDirection

    case object Right extends MovementDirection

    case object Down extends MovementDirection

}
