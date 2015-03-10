package com.ui.gameelement.bomb

import java.awt.Graphics

class DroppingBombs(val bombs: Seq[Bomb] = Nil) {

    def removeOffScreenBombs(screenHeight: Int): DroppingBombs =
        if (!bombs.isEmpty && bombs.reverse.last.tip > screenHeight)
            new DroppingBombs(bombs.init) // take all but the oldest fire missile
        else this

    def updatePosition: DroppingBombs =
        new DroppingBombs(
            bombs.foldRight(Seq[Bomb]()) {
                (bomb, acc) =>
                    val loc = BombPositionDirector.nextPosition(bomb.topLeft)
                    bomb.moveTo(loc) +: acc
            }
        )

    def removeBomb(bomb: Bomb): DroppingBombs =
        new DroppingBombs(bombs.filterNot(_ == bomb))

    def removeBombs(bombToBeRemoved: Seq[Bomb]): DroppingBombs =
        new DroppingBombs(this.bombs.diff(bombToBeRemoved))

    def addToDroppingBombs(bomb: Option[Bomb]): DroppingBombs = bomb.map {
        b =>
            new DroppingBombs(b +: bombs)
    }.getOrElse(this)

    def addToDroppingBombs(bombs: Seq[Bomb]): DroppingBombs = new DroppingBombs(bombs ++ this.bombs)

    def getBombCount: Int = bombs.size

    def draw(g: Graphics): Unit = bombs.foreach(_.draw(g))

}
