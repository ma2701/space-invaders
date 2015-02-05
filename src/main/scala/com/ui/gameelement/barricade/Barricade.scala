package com.ui.gameelement.barricade

import java.awt.{Color, Graphics, Rectangle, Point}
import com.ui.gameelement.Displayable


class Barricade(topLeft: Point) extends Displayable(topLeft){

    import com.ui.gameelement.barricade._

    val parts = List[Rectangle] (
        TopSection(x, y).getBoundingBox,
        TopSectionTwo(x, y).getBoundingBox,
        TopSectionThree(x, y).getBoundingBox,

        MidSectionOne(x, y).getBoundingBox,
        MidSectionTwo(x, y).getBoundingBox,
        MidSectionThree(x, y).getBoundingBox,
        MidSectionFour(x, y).getBoundingBox,

        LeftLegOne(x, y).getBoundingBox,
        LeftLegTwo(x, y).getBoundingBox,
        LeftLegThree(x, y).getBoundingBox,
        LeftLegFour(x, y).getBoundingBox,
        LeftLegFive(x, y).getBoundingBox,

        RightLegOne(x, y).getBoundingBox,
        RightLegTwo(x, y).getBoundingBox,
        RightLegThree(x, y).getBoundingBox,
        RightLegFour(x, y).getBoundingBox,
        RightLegFive(x, y).getBoundingBox
    )

    override def draw(g:Graphics):Unit = {
        g.setColor(Color.GREEN)
        super.draw(g)
    }
}