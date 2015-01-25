package com.ui.character

import java.awt.Point
import com.ui.Invader
import com.ui.character.invader.DisplayElement

object ArmyCommander {
    def ROW_CNT = 5
    def COL_CNT = 11

    def BUFFER_BETWEEN_SOLDIERS = 10 // pixels

    def formAnArmy(startingPosition:Point):Seq[Invader] = {
        val soldiers = new scala.collection.mutable.ListBuffer[Invader]()

        for( row <- 0 until  ROW_CNT) {
            for(col <- 0 until  COL_CNT){
                val soldier = new Invader(new Point(0,0))

                val position = calculateInvaderPos(row,col, startingPosition)

                soldiers += (soldier.moveTo(position))
            }
        }

        soldiers.toSeq // to immutable Seq
    }

    def moveAllArmyInXDirection(x:Int , army:Seq[Invader]):Seq[Invader] = {
        army.map { invader =>
            invader.moveTo(new Point(invader.topRight.x + x, invader.topRight.y))
        }
    }

    def moveAllArmyInYDirection(y:Int , army:Seq[Invader]):Seq[Invader] = {
        army.map { invader =>
            invader.moveTo(new Point(invader.topRight.x , invader.topRight.y + y))
        }
    }

    def calculateInvaderPos(row:Int, col:Int, startingPoint:Point):Point = {
        new Point( startingPoint.x + (col * Invader.INVADER_WIDTH) + (col*BUFFER_BETWEEN_SOLDIERS) ,
                   startingPoint.y + (row * Invader.INVADER_HEIGHT) + (row*BUFFER_BETWEEN_SOLDIERS))
    }

}
