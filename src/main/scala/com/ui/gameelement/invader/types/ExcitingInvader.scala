package com.ui.gameelement.invader.types

import java.awt.{Graphics, Point, Rectangle}

import com.ui.gameelement.invader.ExcitedInvader

class ExcitingInvader(tl:Point, isHit:Boolean) extends Invader(tl, isHit) {
    override def boundingBox: Rectangle = new Rectangle(0 ,0, 0, 0)
    override def moveTo(point:Point): Invader =
        if(isHit)
            new ExplodingInvader(topLeft)
        else
            new Invader(point, this.isHit )

    override def draw(g:Graphics) :Unit = new ExcitedInvader(topLeft).draw(g)
}
