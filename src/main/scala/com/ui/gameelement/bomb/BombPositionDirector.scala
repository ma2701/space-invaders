package com.ui.gameelement.bomb

import java.awt.Point
import com.ui.GameConfiguration.currentConfig

object BombPositionDirector {

    def nextPosition(point: Point): Point = new Point(point.x, point.y + currentConfig.bombDropRate)

}

