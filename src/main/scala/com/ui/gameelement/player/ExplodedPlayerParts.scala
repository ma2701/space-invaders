package com.ui.gameelement.player

import com.ui.gameelement.displayelement.SingleDisplayElement
import java.awt.Color
import java.awt.Color._
import com.ui.gameelement.displayelement.SingleDisplayElement._


trait ExplodedPlayerParts {
    def parts(x:Int, y:Int): List[SingleDisplayElement] = List[SingleDisplayElement](
        ExplodedPlayerBottom(x,y),
        ExplodedPlayerMidBottom(x,y),
        ExplodedPlayerMidTop(x,y),
            ExplodedPlayerTop(x,y),
        ExplodedPlayerLeftPieceOne(x,y),
        ExplodedPlayerLeftPieceTwo(x,y),
        ExplodedPlayerLeftPieceThree(x,y),
            ExplodedPlayerMidPieceOne(x,y),
            ExplodedPlayerMidPieceTwo(x,y),
            ExplodedPlayerMidPieceThree(x,y),
        ExplodedPlayerRightPieceOne(x,y) ,
        ExplodedPlayerRightPieceTwo(x,y)
    )
}

abstract class GreenDisplayElement(x: Int, y: Int, xOffsetFromCentre: Int, yOffsetFromCentre: Int)
    extends SingleDisplayElement(x, y,xOffsetFromCentre,  yOffsetFromCentre){
    override val color:Color = GREEN
}

object ExplodedPlayerBottom {
    val xOffset = 0;
    val yOffset = 6
}

case class ExplodedPlayerBottom (topLeftX: Int, topLeftY: Int) extends GreenDisplayElement(
    xOffset(topLeftX, ExplodedPlayerBottom .xOffset),
    yOffset(topLeftY, ExplodedPlayerBottom.yOffset),
    (17 * DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object ExplodedPlayerMidBottom {
    val xOffset = 2;
    val yOffset = 5
}

case class ExplodedPlayerMidBottom (topLeftX: Int, topLeftY: Int) extends GreenDisplayElement(
    xOffset(topLeftX, ExplodedPlayerMidBottom .xOffset),
    yOffset(topLeftY, ExplodedPlayerMidBottom.yOffset),
    (13 * DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object ExplodedPlayerMidTop {
    val xOffset = 3;
    val yOffset = 4
}

case class ExplodedPlayerMidTop (topLeftX: Int, topLeftY: Int) extends GreenDisplayElement(
    xOffset(topLeftX, ExplodedPlayerMidTop .xOffset),
    yOffset(topLeftY, ExplodedPlayerMidTop.yOffset),
    (11 * DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object ExplodedPlayerTop {
    val xOffset = 5;
    val yOffset = 3
}

case class ExplodedPlayerTop (topLeftX: Int, topLeftY: Int) extends GreenDisplayElement(
    xOffset(topLeftX, ExplodedPlayerTop .xOffset),
    yOffset(topLeftY, ExplodedPlayerTop.yOffset),
    (6 * DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object ExplodedPlayerLeftPieceOne {
    val xOffset = 0;
    val yOffset = 4
}

case class ExplodedPlayerLeftPieceOne (topLeftX: Int, topLeftY: Int) extends GreenDisplayElement(
    xOffset(topLeftX, ExplodedPlayerLeftPieceOne .xOffset),
    yOffset(topLeftY, ExplodedPlayerLeftPieceOne.yOffset),
    (DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object ExplodedPlayerLeftPieceTwo {
    val xOffset = 2;
    val yOffset = 3
}

case class ExplodedPlayerLeftPieceTwo (topLeftX: Int, topLeftY: Int) extends GreenDisplayElement(
    xOffset(topLeftX, ExplodedPlayerLeftPieceTwo .xOffset),
    yOffset(topLeftY, ExplodedPlayerLeftPieceTwo.yOffset),
    (DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object ExplodedPlayerLeftPieceThree {
    val xOffset = 5;
    val yOffset = 2
}

case class ExplodedPlayerLeftPieceThree (topLeftX: Int, topLeftY: Int) extends GreenDisplayElement(
    xOffset(topLeftX, ExplodedPlayerLeftPieceThree .xOffset),
    yOffset(topLeftY, ExplodedPlayerLeftPieceThree.yOffset),
    (DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object ExplodedPlayerMidPieceOne {
    val xOffset = 7;
    val yOffset = 1
}

case class ExplodedPlayerMidPieceOne (topLeftX: Int, topLeftY: Int) extends GreenDisplayElement(
    xOffset(topLeftX, ExplodedPlayerMidPieceOne .xOffset),
    yOffset(topLeftY, ExplodedPlayerMidPieceOne.yOffset),
    (DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object ExplodedPlayerMidPieceTwo {
    val xOffset = 9;
    val yOffset = 2
}
case class ExplodedPlayerMidPieceTwo (topLeftX: Int, topLeftY: Int) extends GreenDisplayElement(
    xOffset(topLeftX, ExplodedPlayerMidPieceTwo .xOffset),
    yOffset(topLeftY, ExplodedPlayerMidPieceTwo.yOffset),
    (DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object ExplodedPlayerMidPieceThree {
    val xOffset = 9;
    val yOffset = 0
}
case class ExplodedPlayerMidPieceThree (topLeftX: Int, topLeftY: Int) extends GreenDisplayElement(
    xOffset(topLeftX, ExplodedPlayerMidPieceThree .xOffset),
    yOffset(topLeftY, ExplodedPlayerMidPieceThree.yOffset),
    (DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object ExplodedPlayerRightPieceOne {
    val xOffset = 11;
    val yOffset = 1
}
case class ExplodedPlayerRightPieceOne (topLeftX: Int, topLeftY: Int) extends GreenDisplayElement(
    xOffset(topLeftX, ExplodedPlayerRightPieceOne .xOffset),
    yOffset(topLeftY, ExplodedPlayerRightPieceOne.yOffset),
    (2*DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object ExplodedPlayerRightPieceTwo {
    val xOffset = 14;
    val yOffset = 2
}
case class ExplodedPlayerRightPieceTwo (topLeftX: Int, topLeftY: Int) extends GreenDisplayElement(
    xOffset(topLeftX, ExplodedPlayerRightPieceTwo .xOffset),
    yOffset(topLeftY, ExplodedPlayerRightPieceTwo.yOffset),
    (DEFAULT_ELEMENT_WIDTH), 2*DEFAULT_ELEMENT_HEIGHT)