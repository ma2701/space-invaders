package com.ui.gameelement.bomb

import java.awt.Point
import com.GameConfiguration
import GameConfiguration.currentConfig

object BombPositionDirector {

    def nextPosition(point: Point): Point = new Point(point.x, point.y + currentConfig.bombVelocity)

}

