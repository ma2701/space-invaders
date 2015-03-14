package com.ui.gameelement.invader

import java.awt.Point

import com.ui.gameelement.invader.types.{OctopusInvader, CrabInvader, Invader}

object ArmyCommander {
    def BUFFER_BETWEEN_SOLDIERS = 10 // pixels

    def ROW_CNT = 5
    def COL_CNT = 11

    def CRAB_INVADER_CNT = 22

    def formAnArmy(startingPosition:Point):Seq[Invader] =
        allInvaderPositionsFromStartingPoint(startingPosition)
        .zipWithIndex
        .map {
            positionIndexTuple => positionIndexTuple._2 match {
                case currentInvaderCnt if(!hasCreatedEnoughCrabInvader(currentInvaderCnt)) =>
                    CrabInvader(positionIndexTuple._1)
                case currentInvaderCnt if(hasCreatedEnoughCrabInvader(currentInvaderCnt)) =>
                    OctopusInvader(positionIndexTuple._1)
            }
        }


    private def hasCreatedEnoughCrabInvader(currentInvaderCnt: Int):Boolean = currentInvaderCnt >= CRAB_INVADER_CNT

    def calculateInvaderPos(row:Int, col:Int, startingPoint:Point):Point = {
        new Point( startingPoint.x + (col * Invader.INVADER_WIDTH) + (col*BUFFER_BETWEEN_SOLDIERS) ,
        startingPoint.y + (row * Invader.INVADER_HEIGHT) + (row*BUFFER_BETWEEN_SOLDIERS))
    }

    def allInvaderPositionsFromStartingPoint(startingPos: Point): Seq[Point] = {
        (0 until ROW_CNT) flatMap { rowId =>
            (0 until COL_CNT) map { colId =>
                calculateInvaderPos(rowId, colId, startingPos)
            }
        }
    }

    def moveArmy(invaders: Seq[Invader], points: Seq[Point]):Seq[Invader] =
        invaders
        .zip(points)
        .map {
            invaderPositionTuple =>
                invaderPositionTuple._1.moveTo(invaderPositionTuple._2)
        }
    
    def totalHorizontalBufferSize:Int = BUFFER_BETWEEN_SOLDIERS * COL_CNT
    def totalVerticalBufferSize:Int   = BUFFER_BETWEEN_SOLDIERS * ROW_CNT

    def armyWidth(singleSoldierWidth:Int)   = singleSoldierWidth  *COL_CNT + totalHorizontalBufferSize
    def armyHeight(singleSoldierHeight:Int) = singleSoldierHeight *ROW_CNT + totalVerticalBufferSize
}
