package com.ui.gameelement.invader.types

import java.awt.{Graphics, Point, Rectangle}

import com.ui.gameelement.invader.ExcitedInvaderDisplayItem

class ExcitedInvader(tl:Point, isHit:Boolean) extends Invader(tl, isHit) {

    override def moveTo(point:Point): Invader =
        if(isHit)
           new ExplodedInvader(topLeft)
        else
            new Invader(point, super.isHitByMissile )

    override def draw(g:Graphics) :Unit = new ExcitedInvaderDisplayItem(topLeft).draw(g)
}
