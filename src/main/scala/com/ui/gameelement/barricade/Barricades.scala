package com.ui.gameelement.barricade

import java.awt.{Graphics, Point}


class Barricades (val topLeft:Point) {
    val barricadeSpacing: Int = 110

    private[this] val leftMostCover = new Barricade(topLeft)
    private[this] val secondCover   = new Barricade(new Point(leftMostCover.topLeft.x + leftMostCover.boundingBox.width + barricadeSpacing, leftMostCover.topLeft.y))
    private[this] val thirdCover    = new Barricade(new Point(secondCover.topLeft.x + secondCover.boundingBox.width + barricadeSpacing, secondCover.topLeft.y))
    private[this] val forthCover    = new Barricade(new Point(thirdCover.topLeft.x + thirdCover.boundingBox.width + barricadeSpacing, thirdCover.topLeft.y))

    val covers = List(
        leftMostCover,
        secondCover,
        thirdCover,
        forthCover
    )

    def draw(g:Graphics) :Unit = {
        covers.foreach(_.draw(g))
    }
}
