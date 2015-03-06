package com.ui.gameelement.bomb

import java.awt.Graphics
import com.ui.gameelement.barricade.Barricades

class DroppingBombs(val bombs: Seq[Bomb] = Nil) {

    // as bombs are dropped they are added to the head hence .reverse to look at the
    // oldest missiles fired
    def removeOffScreenBombs(screenHeight:Int ): DroppingBombs =
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

    def removeMissile(bomb: Bomb): DroppingBombs =
        new DroppingBombs(bombs.filterNot(_ == bomb))

    def removeMissiles(bombToBeRemoved: Seq[Bomb]): DroppingBombs=
        new DroppingBombs(this.bombs.diff(bombToBeRemoved))

    def addToDroppingBombs(bomb: Bomb): DroppingBombs= new DroppingBombs(bomb +: bombs)

    def addToDroppingBombs(bomb: Seq[Bomb]): DroppingBombs= new DroppingBombs(bombs ++ this.bombs)

    def getBombCount: Int = bombs.size

    def draw(g: Graphics): Unit = bombs.foreach(_.draw(g))

}
