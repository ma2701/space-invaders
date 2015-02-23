package com.ui.gameelement.invader

import java.awt.{Rectangle, Point}

import com.ui.gameelement.invader.Direction.{Right, Left, Up, Down}
import com.ui.gameelement.invader.GeneralArmyDirection.GeneralArmyDirection


object InvaderArmyPositionDirector {
    val ONE_HOP_IN_X_DIRECTION = 5
    val ONE_HOP_IN_Y_DIRECTION = 7

    private[this] var initialPosition   : Point                = new Point(0,0)
    private[this] var currentPosition   : Point                = _
    private[this] var direction         : MovementDirection    = _
    private[this] var generalDirection  : GeneralArmyDirection = _
    private[this] var displayBoundingBox: Rectangle            = _

    def nextPosition(displayWindow: Rectangle, armyBoundingBox: Rectangle): Point = {
        import GeneralArmyDirection._
        displayBoundingBox = new Rectangle(0, 0, displayWindow.width, displayWindow.height)

        if (isInInitialState)
            setInitialPosition(displayWindow, armyBoundingBox)
        else
            direction match {
                case Left =>
                    if (hasReachedLeftWall)
                        moveUpOrDown
                    else
                        moveInXAxis(-ONE_HOP_IN_X_DIRECTION)
                case Right =>
                    if (hasReachedRightWall(armyBoundingBox, displayWindow))
                        moveUpOrDown
                    else
                        moveInXAxis(ONE_HOP_IN_X_DIRECTION)
                case Up =>
                    if (hasReachedTopWall)
                        generalDirection = Downward
                    moveLeftOrRight
                case Down =>
                    if (hasReachedBottomWall(armyBoundingBox, displayWindow))
                        generalDirection = Upward
                    moveLeftOrRight
            }
    }

    private def setInitialPosition(displayWindow: Rectangle, armyBoundingBox: Rectangle): Point = {
        val x: Int = (displayWindow.width  - armyBoundingBox.width) / 2
        val y: Int = (displayWindow.height - armyBoundingBox.height) / 2

        initialPosition = new Point(x, y)
        generalDirection = GeneralArmyDirection.Downward
        direction = Left

        currentPosition = initialPosition
        currentPosition
    }

    private def hasReachedRightWall(armyBoundingBox: Rectangle, displayWindow: Rectangle): Boolean =
        currentPosition.x + armyBoundingBox.x > displayWindow.width

    private def moveUpOrDown: Point = {
        import GeneralArmyDirection._
        if (generalDirection == Downward) {
            moveDown
        } else {
            moveUp
        }
    }

    private def moveLeftOrRight: Point = {
        if (hasReachedLeftWall) {
            moveRight
        } else {
            moveLeft
        }
    }

    private def isInInitialState: Boolean =
        initialPosition == new Point(0,0)

    private def moveDown: Point = {
        direction = Down
        moveInYAxis(ONE_HOP_IN_Y_DIRECTION)
    }

    private def moveUp: Point = {
        direction = Up
        moveInYAxis(-ONE_HOP_IN_Y_DIRECTION)
    }

    private def moveLeft: Point = {
        direction = Left
        moveInXAxis(-ONE_HOP_IN_X_DIRECTION)
    }

    private def moveRight: Point = {
        direction = Right
        moveInXAxis(ONE_HOP_IN_X_DIRECTION)
    }

    private def hasReachedTopWall: Boolean = currentPosition.y < 0

    private def hasReachedBottomWall(armyBoundingBox: Rectangle, displayWindow: Rectangle): Boolean =
        currentPosition.y + armyBoundingBox.height > displayWindow.height

    private def hasReachedLeftWall: Boolean = currentPosition.x <= 0

    private def moveInYAxis(numPixels: Int): Point = {
        currentPosition = new Point(currentPosition.x, currentPosition.y + numPixels)
        currentPosition

    }

    private def moveInXAxis(numPixels: Int): Point = {
        currentPosition = new Point(currentPosition.x + numPixels, currentPosition.y)
        currentPosition
    }
}

object GeneralArmyDirection extends Enumeration {
    type GeneralArmyDirection = Value
    val Upward, Downward = Value
}

