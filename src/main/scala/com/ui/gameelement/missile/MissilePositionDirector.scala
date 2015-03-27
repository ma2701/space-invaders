package com.ui.gameelement.missile

import java.awt.Point
import com.GameConfiguration
import GameConfiguration.currentConfig

object MissilePositionDirector {

    def nextPosition(missile:Missile):Point =
        new Point(missile.head.getX.toInt , missile.head.getY.toInt - currentConfig.missileVelocity)
}
