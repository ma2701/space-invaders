package com.ui.util.random

import com.ui.gameelement.invader.MysteryInvaderMovementDirection
import com.ui.gameelement.invader.MysteryInvaderDirection.{RightToLeft, LeftToRight}

class RandomDirection(rng: RandomNumberGenerator = new RandomNumberGenerator) {

    def randomRightWithOneInNChance(n:Int): MysteryInvaderMovementDirection= {
        if(rng.next(1 to n) ==1)
            LeftToRight
        else
            RightToLeft
    }
}
