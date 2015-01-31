package com.ui.character

import java.awt.{Rectangle, Point}

import com.ui.character.GeneralArmyDirection._
import com.ui.character.Directions.{RightDirection, LeftDirection, UpDirection, DownDirection}

object ArmyDirection {
    val movementInXDirection = 5
    val movementInYDirection = 7

    private[this] var startPosition:Point = _
    private[this] var currentPosition:Point = _
    private[this] var direction: MovementDirection = _
    private[this] var UpDownDirection: GeneralArmyDirection = _
    private[this] var displayBoundingBox:Rectangle = _

    def whereToNext(displayWindow:Rectangle , armyBoundingBox:Rectangle ):Point = {
        import GeneralArmyDirection._
        displayBoundingBox = new Rectangle(0,0, displayWindow.width, displayWindow.height)

        if(isCalledForFirstTime)
            setInitialPosition(displayWindow, armyBoundingBox)
        else
            direction match {
                case LeftDirection =>
                    if(hasReachedLeftWall)
                        moveUpOrDown
                    else
                        moveInXAxis(-movementInXDirection)
                 case DownDirection =>
                    if(hasReachedBottomWall(armyBoundingBox, displayWindow) )
                        UpDownDirection = Upward
                    moveLeftOrRight
                case RightDirection =>
                    if(hasReachedRightWall(armyBoundingBox, displayWindow))
                        moveUpOrDown
                    else
                        moveInXAxis(movementInXDirection)
                case UpDirection =>
                    if(hasReachedTopWall)
                        UpDownDirection = Downward
                    moveLeftOrRight

            }
    }


    private def setInitialPosition(displayWindow: Rectangle, armyBoundingBox: Rectangle): Point = {

        val x: Int = (displayWindow.width - armyBoundingBox.width) / 2
        val y: Int = (displayWindow.height - armyBoundingBox.height) / 2

        startPosition = new Point(x, y)

        currentPosition = startPosition
        UpDownDirection = Downward
        direction = LeftDirection
        currentPosition
    }

    private def hasReachedRightWall(armyBoundingBox: Rectangle, displayWindow: Rectangle): Boolean =
        currentPosition.x + armyBoundingBox.x > displayWindow.width

    private def moveUpOrDown: Point = {
        import GeneralArmyDirection._
        if (UpDownDirection == Downward) {
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

    private def isCalledForFirstTime: Boolean = startPosition == null

    private def moveDown:  Point  = {
        direction = DownDirection
        moveInYAxis(movementInYDirection)
    }

    private def moveUp:  Point  = {
        direction = UpDirection
        moveInYAxis(-movementInYDirection)
    }

    private def moveLeft: Point = {
        direction = LeftDirection
        moveInXAxis(-movementInXDirection)
    }

    private def moveRight: Point = {
        direction = RightDirection
        moveInXAxis(movementInXDirection)
    }

    private def hasReachedTopWall: Boolean = currentPosition.y < 0

    private def hasReachedBottomWall(armyBoundingBox: Rectangle, displayWindow: Rectangle): Boolean =
        currentPosition.y + armyBoundingBox.height > displayWindow.height

    private def hasReachedLeftWall: Boolean = currentPosition.x <= 0

    private def moveInYAxis(numPixels:Int ): Point = {
        currentPosition = new Point(currentPosition.x, currentPosition.y + numPixels)
        currentPosition

    }
    private def moveInXAxis(numPixels:Int ): Point = {
        currentPosition = new Point(currentPosition.x+numPixels, currentPosition.y)
        currentPosition
    }
}

