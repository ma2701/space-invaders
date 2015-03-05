package com.ui.gameelement.displayelement

import java.awt.{Color, Rectangle}

object SingleDisplayElement {
    val DEFAULT_ELEMENT_WIDTH  = 4
    // PIXELS
    val DEFAULT_ELEMENT_HEIGHT = 3

    def xOffset(x: Int, xOffset: Double): Int = x + (xOffset * SingleDisplayElement.DEFAULT_ELEMENT_WIDTH).toInt

    def yOffset(y: Int, yOffset: Double): Int = y + (yOffset * SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT).toInt
}

abstract class SingleDisplayElement(
                                       posX: Int,
                                       posY: Int,
                                       width: Int = SingleDisplayElement.DEFAULT_ELEMENT_WIDTH,
                                       height: Int = SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT) {

    val color:Color
    def getBoundingBox: Rectangle = {
        new Rectangle(posX, posY, width, height)
    }
}






