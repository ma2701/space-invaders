package com.ui.character

import java.awt.{Rectangle, Point}

import com.ui.character.GeneralArmyDirection._
import com.ui.character.Direction.{Right, Left, Up, Down}

object ArmyDirection {
    val oneHopInXDirection = 5
    val oneHopInYDirection = 7

    private[this] var startPosition:Point = _
    private[this] var currentPosition:Point = _
    private[this] var direction: MovementDirection = _
    private[this] var generalDirection: GeneralArmyDirection = _
    private[this] var displayBoundingBox:Rectangle = _

    def whereToNext(displayWindow:Rectangle , armyBoundingBox:Rectangle ):Point = {
        import GeneralArmyDirection._
        displayBoundingBox = new Rectangle(0,0, displayWindow.width, displayWindow.height)

        if(isCalledForFirstTime)
            setInitialPosition(displayWindow, armyBoundingBox)
        else
            direction match {
                case Left =>
                    if(hasReachedLeftWall)
                        moveUpOrDown
                    else
                        moveInXAxis(-oneHopInXDirection)
                case Right =>
                    if(hasReachedRightWall(armyBoundingBox, displayWindow))
                        moveUpOrDown
                    else
                        moveInXAxis(oneHopInXDirection)
                case Up =>
                    if(hasReachedTopWall)
                        generalDirection = Downward
                    moveLeftOrRight
                case Down =>
                    if(hasReachedBottomWall(armyBoundingBox, displayWindow) )
                    generalDirection = Upward
                    moveLeftOrRight
            }
    }


    private def setInitialPosition(displayWindow: Rectangle, armyBoundingBox: Rectangle): Point = {

        val x: Int = (displayWindow.width - armyBoundingBox.width) / 2
        val y: Int = (displayWindow.height - armyBoundingBox.height) / 2

        startPosition = new Point(x, y)

        currentPosition = startPosition
        generalDirection = Downward
        direction = Left
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

    private def isCalledForFirstTime: Boolean = startPosition == null

    private def moveDown:  Point  = {
        direction = Down
        moveInYAxis(oneHopInYDirection)
    }

    private def moveUp:  Point  = {
        direction = Up
        moveInYAxis(-oneHopInYDirection)
    }

    private def moveLeft: Point = {
        direction = Left
        moveInXAxis(-oneHopInXDirection)
    }

    private def moveRight: Point = {
        direction = Right
        moveInXAxis(oneHopInXDirection)
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

