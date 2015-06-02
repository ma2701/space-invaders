package com.ui.gameelement.bomb

import java.awt.Graphics

class FallingBombs(val bombs: Seq[Bomb] = Nil) {

    def removeOffScreenBombs(screenHeight: Int): FallingBombs =
        if (!bombs.isEmpty && bombs.reverse.last.tip > screenHeight)
            new FallingBombs(bombs.init) // take all but the oldest fire missile
        else this

    def updatePosition: FallingBombs =
        new FallingBombs(
            bombs.foldRight(Seq[Bomb]()) {
                (bomb, acc) =>
                    val loc = BombPositionDirector.nextPosition(bomb.topLeft)
                    bomb.moveTo(loc) +: acc
            }
        )

    def removeBomb(bomb: Bomb): FallingBombs =
        new FallingBombs(bombs.filterNot(_ == bomb))

    def removeBombs(bombToBeRemoved: Seq[Bomb]): FallingBombs =
        new FallingBombs(this.bombs.diff(bombToBeRemoved))

    def addToDroppingBombs(bomb: Option[Bomb]): FallingBombs = bomb.map {
        b =>
            new FallingBombs(b +: bombs)
    }.getOrElse(this)

    def addToDroppingBombs(bombs: Seq[Bomb]): FallingBombs = new FallingBombs(bombs ++ this.bombs)

    def getBombCount: Int = bombs.size

    def draw(g: Graphics): Unit = bombs.foreach(_.draw(g))

}
