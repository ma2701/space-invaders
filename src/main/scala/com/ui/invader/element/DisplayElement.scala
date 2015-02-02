package com.ui.invader.element

import java.awt.Rectangle

object DisplayElement {
    val DEFAULT_ELEMENT_WIDTH = 3
    // PIXELS
    val DEFAULT_ELEMENT_HEIGHT = 3

    def xOffset(x: Int, xOffset: Double): Int = x + (xOffset * DisplayElement.DEFAULT_ELEMENT_WIDTH).toInt

    def yOffset(y: Int, yOffset: Double): Int = y + (yOffset * DisplayElement.DEFAULT_ELEMENT_HEIGHT).toInt
}

abstract class DisplayElement(posX: Int,
                              posY: Int,
                              width: Int = DisplayElement.DEFAULT_ELEMENT_WIDTH,
                              height: Int = DisplayElement.DEFAULT_ELEMENT_HEIGHT) {

    def getBoundingBox: Rectangle = {
        new Rectangle(posX, posY, width, height)
    }
}






