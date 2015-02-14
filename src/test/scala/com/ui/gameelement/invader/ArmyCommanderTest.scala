package com.ui.gameelement.invader

import java.awt.Point
import org.scalatest.FunSuite
import org.scalatest.mock.MockitoSugar
import ArmyCommander.BUFFER_BETWEEN_SOLDIERS

class ArmyCommanderTest extends FunSuite with MockitoSugar {

    val startingPoint = new Point(10, 10)

    test("can form an army of size n") {
        ArmyCommander
    }

    test("given a starting Point(10,10) and first col of first row then return bounding box for an invader soldier") {
        val row = 0
        val col = 0

        assertResult(startingPoint) {
            ArmyCommander.calculateInvaderPos(row, col, startingPoint)
        }
    }

    test("given a starting Point(10,10) and 1st col of 0th row then return bounding box for an invader soldier") {
        val row = 0
        val col = 1

        val expectedXPos: Int = 10 + (1 * Invader.INVADER_WIDTH) + BUFFER_BETWEEN_SOLDIERS

        assertResult(new Point(expectedXPos, 10)) {
            ArmyCommander.calculateInvaderPos(row, col, startingPoint)
        }
    }

    test("given a starting Point(10,10) and last col of 0th row then return bounding box for an invader soldier") {
        val row = 0
        val col = 10

        val expectedXPos: Int = 10 + (10 * Invader.INVADER_WIDTH) + (10 * BUFFER_BETWEEN_SOLDIERS)

        assertResult(new Point(expectedXPos, 10)) {
            ArmyCommander.calculateInvaderPos(row, col, startingPoint)
        }

    }

    test("given a starting Point(10,10) and 0th col of 1th row then return bounding box for an invader soldier") {
        val row = 1
        val col = 0

        val expectedXPos: Int = 10
        val expectedYPos: Int = 10 + (row * Invader.INVADER_HEIGHT) + (row * BUFFER_BETWEEN_SOLDIERS)

        assertResult(new Point(expectedXPos, expectedYPos)) {
            ArmyCommander.calculateInvaderPos(row, col, startingPoint)
        }

    }

    test("given a starting point(10,10) and 10th col of 4th row then return bounding box for an invader soldier") {
        val col = 10
        val row = 4

        val expectedXPos: Int = 10 + (col * Invader.INVADER_WIDTH) + (col * BUFFER_BETWEEN_SOLDIERS)
        val expectedYPos: Int = 10 + (row * Invader.INVADER_HEIGHT) + (row * BUFFER_BETWEEN_SOLDIERS)

        assertResult(new Point(expectedXPos, expectedYPos)) {
            ArmyCommander.calculateInvaderPos(row, col, startingPoint)
        }
    }

    test("given a starting point(10,10) form an army of invader invaders") {
        ArmyCommander.formAnArmy(startingPoint).foreach {
            invader =>
                assert(invader.topLeft.x != 0)
                assert(invader.topLeft.y != 0)
        }
    }

}


