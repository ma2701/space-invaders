package com.ui.gameelement.displayelement

import java.awt.Color
import java.awt.Color._

abstract class WhiteDisplayElement(x: Int, y: Int, xOffsetFromCentre: Int, yOffsetFromCentre: Int)
    extends SingleDisplayElement(x, y, xOffsetFromCentre, yOffsetFromCentre){
    override val color:Color = WHITE
}
