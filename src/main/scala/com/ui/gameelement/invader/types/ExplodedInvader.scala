package com.ui.gameelement.invader.types

import java.awt.{Graphics, Point, Rectangle}

import com.ui.gameelement.invader.ExplodedInvaderDisplayItem
import com.ui.util.RandomNumberGenerator

class ExplodedInvader(tl:Point,
                       val explosionTime:Long= System.currentTimeMillis()) extends Invader(tl)  {

    override def draw(g:Graphics) :Unit       = new ExplodedInvaderDisplayItem(topLeft).draw(g)
    override def moveTo(point:Point): Invader = new ExplodedInvader(point, explosionTime)
    override def boundingBox: Rectangle       = new ExplodedInvaderDisplayItem(topLeft).boundingBox

    /**
     * want to show an exploding invader only for one frame and then mark it dead. this is calculating
     * if the explosion has been displayed on screen long enough
     */
    override def beenExplodingForTooLong(currentTime:Long):Boolean = (currentTime - explosionTime) >= 333

    override def feelLikeDroppingABomb: Boolean = false
}
