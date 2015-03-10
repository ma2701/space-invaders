package com.ui

import com.ui.gameelement.invader.types.Invader

object ScoreCalculation {

    def calculatePoints(invaders: Seq[Invader]): Int =
        invaders.foldLeft(0){ (acc, invader) => acc + invader.pointsWorth}
}
