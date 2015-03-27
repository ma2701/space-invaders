package com

import com.ui.GameElements

case class GameState(
                        elements:GameElements,
                        score:Int,
                        isTimeToResetGame:Boolean)
