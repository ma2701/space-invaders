package com.ui.gameelement.displayelement

import java.awt.Color
import java.awt.Color._

abstract class RedDisplayElement(x: Int, y: Int, width: Int, height: Int)
    extends SingleDisplayElement(x,y, width, height){
    override val color:Color = RED
}
