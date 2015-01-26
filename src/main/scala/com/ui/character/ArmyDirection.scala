package com.ui.character

import java.awt.{Rectangle, Point}
import com.ui.character.MovementDirection.ArmyMovement
import com.ui.character.GeneralArmyDirection.GeneralArmyDirection

object ArmyDirection {
    val movementInXDirection = 10
    val movementInYDirection = 10

    private[this] var startPosition:Point = _
    private[this] var currentPosition:Point = _
    private[this] var currentMovementDirection: ArmyMovement = _
    private[this] var currentGeneralArmyDirection: GeneralArmyDirection = _
    private[this] var displayBoundingBox:Rectangle = _

    def whereToNext(displayWidth:Int , displayHeight:Int ):Point = {
        import MovementDirection._
        import GeneralArmyDirection._
        displayBoundingBox = new Rectangle(0,0, displayWidth, displayHeight)

        if(startPosition ==null) {
            startPosition = new Point((displayWidth / 5) * 2 ,(displayHeight / 8) * 1 )
            currentPosition = startPosition
            currentGeneralArmyDirection = Downward
            currentMovementDirection= Left
            currentPosition
        } else {
            println(s"current pos ${currentPosition}")
            if(currentMovementDirection == Left) {
                if(currentPosition.x > 0 ) {
                    currentPosition = new Point(currentPosition.x - movementInXDirection, currentPosition.y)
                    currentPosition
                } else {
                    if(currentGeneralArmyDirection == Downward){
                        currentMovementDirection = Down
                        currentPosition  = new Point(currentPosition.x, currentPosition.y + movementInYDirection )
                        currentPosition
                    } else {
                        currentMovementDirection = Up
                        currentPosition  = new Point(currentPosition.x , currentPosition.y - movementInYDirection)
                        currentPosition
                    }
                }
            }
            else if (currentMovementDirection == Down){
                if(currentPosition.y < displayHeight ) {
                    // have not reached the bottom yet..
                    if(currentPosition.x >= 0 ) {

                        currentMovementDirection = Right
                        // at the left edge of the screen
                        currentPosition = new Point(currentPosition.x + movementInXDirection , currentPosition.y)
                        currentPosition
                    } else {
                        // at the right edge of the screen
                        currentMovementDirection = Left
                        currentPosition = new Point(currentPosition.x - movementInXDirection , currentPosition.y)
                        currentPosition
                    }
                } else {
                    currentGeneralArmyDirection = Upward
                    // we are at the bottom of the screen
                    if(currentPosition.x == 0 ) {
                        // at the left edge of the screen
                        currentMovementDirection = Right
                        currentPosition = new Point(currentPosition.x + movementInXDirection , currentPosition.y)
                        currentPosition
                    } else {
                        // at the right edge of the screen
                        currentMovementDirection = Left
                        currentPosition = new Point(currentPosition.x - movementInXDirection , currentPosition.y)
                        currentPosition
                    }
                }
            }
            else if(currentMovementDirection == Right) {
                if(currentPosition.x < displayWidth) {
                    currentPosition  = new Point(currentPosition.x +movementInXDirection , currentPosition.y)
                    currentPosition
                } else {
                    if(currentGeneralArmyDirection == Downward) {
                        // moving down and reached the right edge
                        currentMovementDirection = Down
                        currentPosition = new Point(currentPosition.x, currentPosition.y + movementInYDirection)
                        currentPosition
                    } else {
                        // moving upward and reached the right edge
                        currentMovementDirection = Up
                        currentPosition = new Point(currentPosition.x, currentPosition.y - movementInYDirection)
                        currentPosition
                    }
                }
            } else {
                if(currentPosition.y <  displayHeight) {
                    //not reached the top edge yet
                    if(currentPosition.x == 0 ) {
                        // left edge
                        currentMovementDirection = Right
                        currentPosition  = new Point(currentPosition.x + movementInXDirection , currentPosition.y)
                        currentPosition
                    } else {
                        // right edge
                        currentMovementDirection = Left
                        currentPosition  = new Point(currentPosition.x - movementInXDirection , currentPosition.y)
                        currentPosition
                    }

                } else {
                    // we have reached the top edge
                    currentGeneralArmyDirection = Downward
                    // we are at the bottom of the screen
                    if(currentPosition.x == 0 ) {
                        // at the left edge of the screen
                        currentMovementDirection = Right
                        currentPosition = new Point(currentPosition.x + movementInXDirection , currentPosition.y)
                        currentPosition
                    } else {
                        // at the right edge of the screen
                        currentMovementDirection = Left
                        currentPosition = new Point(currentPosition.x - movementInXDirection , currentPosition.y)
                        currentPosition
                    }
                }
            }
        }
    }
}
