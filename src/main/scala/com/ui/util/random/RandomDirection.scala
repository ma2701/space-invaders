package com.ui.util.random

import scala.collection.immutable.Range.Inclusive
import com.ui.gameelement.invader.MysteryInvaderMovementDirection
import com.ui.gameelement.invader.MysteryInvaderDirection.{RightToLeft, LeftToRight}

class RandomDirection(rng: RandomNumberGenerator = new RandomNumberGenerator) {

    def randomLeftOrRightDirection: MysteryInvaderMovementDirection= {
        val range: Inclusive = 0 to 10

        if(rng.next(range) > (range.min + range.max) / 2)
            LeftToRight
        else
            RightToLeft
    }
}
