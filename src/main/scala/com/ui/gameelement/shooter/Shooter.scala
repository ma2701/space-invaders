package com.ui.gameelement.shooter

import java.awt.{Color, Graphics, Rectangle, Point}
import com.ui.gameelement.Displayable
import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import java.io.IOException


class Shooter(topLeft: Point) extends Displayable(topLeft){

    override val color = Color.GREEN

    val parts = List[Rectangle] (
        TopSection(x, y).getBoundingBox,
        TopSupport(x, y).getBoundingBox,
        MidSection(x, y).getBoundingBox,
        Bottom(x, y).getBoundingBox
    )

    def tipPosition:Point = {
        val tip: Rectangle = parts(0)

        new Point(tip.getX.toInt,tip.getY.toInt)
    }

    def moveTo(loc:Point) : Shooter = new Shooter(loc)

    override def draw(g:Graphics):Unit = {
        g.setColor(color)

        var img:BufferedImage = null

        try {
            img = ImageIO.read(new java.io.File("src/main/resources/shooter.jpg"));
        } catch {
            case e:IOException => println(s"WHAAAA ${e.getMessage}")
        }

        g.drawImage(img,topLeft.x, topLeft.y, Color.BLACK, null )
    }
}