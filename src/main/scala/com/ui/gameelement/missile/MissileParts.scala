package com.ui.gameelement.missile

import com.ui.gameelement.displayelement.SingleDisplayElement
import com.ui.gameelement.displayelement.SingleDisplayElement._
import java.awt.Color


case class Line(topX: Int, topY: Int) extends SingleDisplayElement(
    topX,topY, DEFAULT_ELEMENT_WIDTH, 3* DEFAULT_ELEMENT_HEIGHT){
    override val color: Color = Color.RED
}
