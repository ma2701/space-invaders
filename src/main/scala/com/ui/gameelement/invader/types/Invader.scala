package com.ui.gameelement.invader.types

import java.awt.{Graphics, Point, Rectangle}

import com.ui.gameelement.Displayable
import com.ui.gameelement.element._
import com.ui.gameelement.invader.InvaderParts


object Invader {
  val INVADER_WIDTH: Int = 11 * SingleDisplayElement.DEFAULT_ELEMENT_WIDTH
  val INVADER_HEIGHT: Int = 8 * SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT
}

case class Invader(tl: Point,
                   var isHit: Boolean = false) extends Displayable(tl) with InvaderParts {

  import com.ui.gameelement.invader.types.Invader._

  override val parts: List[SingleDisplayElement] = parts(x, y)

  def moveTo(point: Point): Invader =
    if (isHit)
      new ExplodingInvader(topLeft)
    else
      new ExcitingInvader(point, this.isHit)

  def markHitByMissile = isHit = true

  def isHitByMissile = isHit == true

  override def boundingBox: Rectangle = new Rectangle(x, y, INVADER_WIDTH, INVADER_HEIGHT)

  def beenExplodingForTooLong(currentTime: Long): Boolean = false

  protected def drawBox(g: Graphics, rect: Rectangle): Unit = {
    g.fillRect(rect.getX.toInt, rect.getY.toInt, rect.getWidth.toInt, rect.getHeight.toInt)
  }
}
