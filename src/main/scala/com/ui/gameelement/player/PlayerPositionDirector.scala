package com.ui.gameelement.player

import java.awt.Point

object PlayerPositionDirector {
    val SINGLE_HOP_IN_X = 15
    
    def playerInitialPosition(screenWidth:Int, screenHeight:Int ):Point =
        new Point(screenWidth / 5, screenHeight - (screenHeight / 9))
    
    def newPositionToLeft(player:Player):Option[Point] =
        if(!hasReachedLeftEdgeOfScreen(player)) {
            Some(getNewLocationForShooter(player, -SINGLE_HOP_IN_X))
        } else None


    def newPositionToRight(player:Player, screenWidth:Int):Option[Point]  =
        if(!hasReachedRightEdgeOfScreen(player, screenWidth)) {
            Some(getNewLocationForShooter(player, SINGLE_HOP_IN_X))
        } else None

    private def hasReachedRightEdgeOfScreen(player: Player, screenWidth: Int): Boolean =
        player.boundingBox.width + player.topLeft.x + SINGLE_HOP_IN_X > screenWidth

    private def hasReachedLeftEdgeOfScreen(player: Player): Boolean = player.topLeft.x - SINGLE_HOP_IN_X < 0

    private def getNewLocationForShooter(player:Player, dir:Int ):Point = new Point(player.topLeft.x + dir, player.topLeft.y)

}

