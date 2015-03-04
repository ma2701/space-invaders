package com.ui.gameelement.barricade

import java.awt.{Rectangle, Point}
import com.ui.gameelement.Displayable
import com.ui.gameelement.element.SingleDisplayElement


class Barricade(topLeft: Point) extends Displayable(topLeft){
    import com.ui.gameelement.barricade._

    val parts = List[SingleDisplayElement] (
        TopSection(x, y),
        TopSectionTwo(x, y),
        TopSectionThree(x, y),

        MidSectionOne(x, y),
        MidSectionTwo(x, y),
        MidSectionThree(x, y),
        MidSectionFour(x, y),

        LeftLegOne(x, y),
        LeftLegTwo(x, y),
        LeftLegThree(x, y),
        LeftLegFour(x, y),
        LeftLegFive(x, y),

        RightLegOne(x, y),
        RightLegTwo(x, y),
        RightLegThree(x, y),
        RightLegFour(x, y),
        RightLegFive(x, y)
    )

    override def boundingBox: Rectangle = {
        val longestBlock = parts.sortWith( _.getBoundingBox.width > _.getBoundingBox.width)(0)
        val width        = parts.take(12).map(_.getBoundingBox.height).sum

        new Rectangle(x, y, longestBlock.getBoundingBox.getWidth.toInt, width)
    }
}