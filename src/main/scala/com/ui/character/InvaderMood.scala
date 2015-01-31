package com.ui.character

sealed trait InvaderMood

object Mood {
   case object Excited extends InvaderMood
   case object Normal  extends InvaderMood
}
