package com.ui.util.random

import scala.collection.immutable.Range.Inclusive

class RandomBoolean(randomNumberGenerator:RandomNumberGenerator = new RandomNumberGenerator) {
    def randomTrueOrFalse: Boolean = {
        val range: Inclusive = 0 to 10
        randomNumberGenerator.next(range) > (range.min + range.max) / 2
    }
}
