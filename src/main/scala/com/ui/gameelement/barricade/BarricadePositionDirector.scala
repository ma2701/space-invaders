package com.ui.gameelement.barricade

import java.awt.Point

object BarricadePositionDirector {
    val BARRICADE_SPACING = 110

    def getLeftmostBarricadePosition(initialPoint:Point): Point = initialPoint

    def getSecondBarricadePosition(firstBarricade:Barricade): Point = getBarricadePositionRelativeTo(firstBarricade)

    def getThirdBarricadePosition(second:Barricade): Point = getBarricadePositionRelativeTo(second)

    def getFourthBarricadePosition(third:Barricade): Point = getBarricadePositionRelativeTo(third)


    private def getBarricadePositionRelativeTo(neighboringBarricade:Barricade): Point =
        new Point(neighboringBarricade.topLeft.x + neighboringBarricade.boundingBox.width + BARRICADE_SPACING, neighboringBarricade.topLeft.y)

}

