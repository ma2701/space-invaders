package com.ui.gameelement

import org.scalatest.FunSuite
import com.ui.gameelement.invader.{ArmyCommander, InvaderArmy}
import java.awt.Point
import com.ui.gameelement.barricade.Barricades
import com.ui.gameelement.missile.{Missile, MissilesInFlight}
import com.ui.gameelement.bomb.{Bomb, DroppingBombs}
import com.ui.gameelement.player.Player
import com.ui.GameElements

class CollisionDetectionTest extends FunSuite {

    val screenWidth = 100
    val screenHeight = 100
    val startingPosition: Point = new Point(0, 0)

    test("can create an instance"){
        new CollisionDetection()
    }

    test("given a collision detector when there is no collision then no collision is detected"){
        val invaderArmy = new InvaderArmy(ArmyCommander.formAnArmy(startingPosition))
        val barricades  = new Barricades(startingPosition)
        val missiles    = new MissilesInFlight(List(new Missile(startingPosition)))
        val bombs       = new DroppingBombs(List(new Bomb(startingPosition)))
        val player      = new Player(startingPosition)

        val positionManager = new GameElementPositionDirector(screenWidth, screenHeight)
        val gameElementsWithUpdatedPositions = positionManager.updatePositionOfGameElements(GameElements(invaderArmy, missiles, barricades,player, bombs))

        val collidedElements = new CollisionDetection().detectAllCollidedElements(gameElementsWithUpdatedPositions)

        assert(0 == collidedElements.shotInvaders.size)
        assert(0 == collidedElements.hitBarricadesByBombs.size)
        assert(!collidedElements.isPlayerShot)

    }

    test("given a collision detector when there is no collision then no collision is detected"){
        val invaderArmy = new InvaderArmy(ArmyCommander.formAnArmy(startingPosition))
        val barricades  = new Barricades(startingPosition)
        val missiles    = new MissilesInFlight(List(new Missile(startingPosition)))
        val bombs       = new DroppingBombs(List(new Bomb(startingPosition)))
        val player      = new Player(startingPosition)

        val positionManager = new GameElementPositionDirector(screenWidth, screenHeight)
        val gameElementsWithUpdatedPositions = positionManager.updatePositionOfGameElements(GameElements(invaderArmy, missiles, barricades,player, bombs))

        val collidedElements = new CollisionDetection().detectAllCollidedElements(gameElementsWithUpdatedPositions)

        assert(0 == collidedElements.shotInvaders.size)
        assert(0 == collidedElements.hitBarricadesByBombs.size)
        assert(!collidedElements.isPlayerShot)

    }


}
