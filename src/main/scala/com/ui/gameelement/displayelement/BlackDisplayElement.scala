package com.ui.gameelement.displayelement

import java.awt.Color._
import java.awt.Color

abstract class BlackDisplayElement(x: Int, y: Int, width: Int, height: Int)
    extends SingleDisplayElement(x,y, width, height){
    override val color:Color = BLACK
}
