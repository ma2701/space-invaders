package com.ui.gameelement.barricade

import java.awt.{Rectangle, Graphics, Point}
import BarricadePositionDirector._

class Barricades (val topLeft:Point) {

    private[this] val leftMostCover = new Barricade(getLeftmostBarricadePosition(topLeft))
    private[this] val secondCover   = new Barricade(getSecondBarricadePosition(leftMostCover))
    private[this] val thirdCover    = new Barricade(getThirdBarricadePosition(secondCover))
    private[this] val forthCover    = new Barricade(getFourthBarricadePosition(thirdCover))

    val covers = List(
        leftMostCover,
        secondCover,
        thirdCover,
        forthCover
    )

    def moveTo(position:Point):Barricades = if(position!=this.topLeft) new Barricades(position) else this

    def draw(g:Graphics) :Unit = {
        covers.foreach(_.draw(g))
    }

    def boundingBox:Rectangle= new Rectangle(
        leftMostCover.topLeft.x,
        leftMostCover.topLeft.y,
        forthCover.topLeft.x + forthCover.boundingBox.width,
        leftMostCover.boundingBox.height)


}
