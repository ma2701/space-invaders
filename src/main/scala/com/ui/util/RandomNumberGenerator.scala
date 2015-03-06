package com.ui.util

import java.util.Random
import scala.collection.immutable.Range.Inclusive

class RandomNumberGenerator(val random: Random = new Random()) {

    def next(range: Range): Int = {
        random.nextInt(range.max - range.min + 1) + range.min
    }

    def randomTrueOrFalse: Boolean = {
        val range: Inclusive = 0 to 10
        next(range) > (range.min + range.max) / 2
    }

}

