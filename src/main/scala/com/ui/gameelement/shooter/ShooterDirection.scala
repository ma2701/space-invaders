package com.ui.gameelement.shooter

import java.awt.Point

// TODO: add tests for this....

object ShooterDirection {
    val SINGLE_HOP_IN_X = 15

    def newLocationToLeft(shooter:Shooter, screenWidth:Int):Option[Point] =
        if(!hasReachedLeftEdgeOfScreen(shooter)) {
            Some(getNewLocationForShooter(shooter, -SINGLE_HOP_IN_X))
        } else None


    def newLocationToRight(shooter:Shooter, screenWidth:Int):Option[Point]  =
        if(!hasReachedRightEdgeOfScreen(shooter, screenWidth)) {
            Some(getNewLocationForShooter(shooter, SINGLE_HOP_IN_X))
        } else None

    private def hasReachedRightEdgeOfScreen(shooter: Shooter, screenWidth: Int): Boolean =
        shooter.boundingBox.width + shooter.topLeft.x + SINGLE_HOP_IN_X > screenWidth

    private def hasReachedLeftEdgeOfScreen(shooter: Shooter): Boolean = shooter.topLeft.x - SINGLE_HOP_IN_X < 0

    private def getNewLocationForShooter(shooter:Shooter, dir:Int ):Point = new Point(shooter.topLeft.x + dir, shooter.topLeft.y)

}

