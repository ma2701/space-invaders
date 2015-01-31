package com.ui.character

import java.awt.{Rectangle, Point}
import com.ui.character._

import com.ui.character.GeneralArmyDirection._

object ArmyDirection {
    val movementInXDirection = 5
    val movementInYDirection = 7

    private[this] var startPosition:Point = _
    private[this] var currentPosition:Point = _
    private[this] var direction: MovementDirection = _
    private[this] var UpDownDirection: GeneralArmyDirection = _
    private[this] var displayBoundingBox:Rectangle = _

    def whereToNext(displayWindow:Rectangle , armyBoundingBox:Rectangle ):Point = {
        import com.ui.character.{UpDirection, DownDirection, LeftDirection, RightDirection }
        import GeneralArmyDirection._
        displayBoundingBox = new Rectangle(0,0, displayWindow.width, displayWindow.height)

        if(isCalledForFirstTime) {

            setInitialPosition(displayWindow, armyBoundingBox)

        } else {
            if(direction == LeftDirection) {
                if(hasReachedLeftWall) 
                    moveUpOrDown
                else 
                    moveInXAxis(-movementInXDirection)
            }
            else if (direction == Down){
                if(hasReachedBottomWall(armyBoundingBox, displayWindow) ) 
                    UpDownDirection = Upward
                moveLeftOrRight
            }
            else if(direction == Right) {
                if(hasReachedRightWall(armyBoundingBox, displayWindow)) 
                    moveUpOrDown
                 else 
                    moveInXAxis(movementInXDirection)                
            } else {
                if(hasReachedTopWall) 
                    UpDownDirection = Downward
                moveLeftOrRight

            }
        }
    }


    private def setInitialPosition(displayWindow: Rectangle, armyBoundingBox: Rectangle): Point = {
        import MovementDirection._

        val x: Int = (displayWindow.width - armyBoundingBox.width) / 2
        val y: Int = (displayWindow.height - armyBoundingBox.height) / 2

        startPosition = new Point(x, y)

        currentPosition = startPosition
        UpDownDirection = Downward
        direction = Left
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
        import MovementDirection._
        direction = Down
        moveInYAxis(movementInYDirection)
    }

    private def moveUp:  Point  = {
        import MovementDirection._
        direction = Up
        moveInYAxis(-movementInYDirection)
    }

    private def moveLeft: Point = {
        import MovementDirection._
        direction = Left
        moveInXAxis(-movementInXDirection)
    }

    private def moveRight: Point = {
        import MovementDirection._
        direction = Right
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
