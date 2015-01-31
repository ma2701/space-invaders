package com.ui.character

sealed trait MovementDirection
object Directions{
    case object UpDirection extends MovementDirection
    case object LeftDirection extends MovementDirection
    case object RightDirection extends MovementDirection
    case object DownDirection extends MovementDirection
}
