package com.ui.gameelement.invader.types

import java.awt.{Graphics, Point, Rectangle}

import com.ui.gameelement.invader.ExplodedInvader

/**
 * Created by mahmadzadeh on 3/4/15.
 */
class ExplodingInvader(tl:Point,
                       val explosionTime:Long= System.currentTimeMillis()) extends Invader(tl)  {

    override def draw(g:Graphics) :Unit = new ExplodedInvader(topLeft).draw(g)
    override def moveTo(point:Point): Invader = new ExplodingInvader(point, explosionTime)
    override def boundingBox: Rectangle = super.boundingBox

    /**
     * want to show an exploding invader only for one frame and then mark it dead. this is calculating
     * if the explosion has been displayed on screen long enough
     */
    override def beenExplodingForTooLong(currentTime:Long):Boolean = (currentTime - explosionTime) >= 333
}
