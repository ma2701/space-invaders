package com.ui.gameelement

import java.awt.{Point, Rectangle}
import com.ui.gameelement.barricade.Barricades
import com.ui.gameelement.player.PlayerPositionDirector._
import com.ui.gameelement.missile.MissilesInFlight
import com.ui.gameelement.bomb.DroppingBombs
import com.ui.gameelement.invader. InvaderArmy
import com.ui.gameelement.invader.MysteryInvaderPositionDirector.{nextPosition => nxtPosition}
import com.ui.util.InvaderArmyMoveDelay._
import com.ui.gameelement.invader.InvaderArmyPositionDirector._
import com.ui.GameElements
import com.ui.gameelement.player.types.Player
import com.ui.gameelement.invader.types.{ExplodedInvader, Invader, MysteryInvader}

/**
 *
 * @param screenWidth  : game area display width
 * @param screenHeight : height 
 *
 * this class is responsible for moving game elements on the screen. It updates their positions
 * based on their current position.
 * All game elements are positioned relative to the screen width and height.
 * Originally all game elements are positioned at (0,0) on the screen a call to
 * updatePositionsOfGameElements() repositions everything
 *
 * Each game element has a its own (game_element)PositionDirector. This class simply
 * asks the relevant director for an updated position and then moves the game element to that position...
 */

class GameElementPositionManager(screenWidth: Int, screenHeight: Int) {
    private val displayWindowBoundingBox = new Rectangle(0, 0, screenWidth, (3 * screenHeight) / 4)

    def updatePositionOfGameElements(elements: GameElements): GameElements = {

        val invaderArmy      = updateInvaderArmyPosition(elements.invaderArmy)
        val missilesInFlight = updateMissilesPosition(elements.missilesInFlight)
        val barricades       = updatedBarricadePosition(elements.barricades)
        val player           = updatePlayerPositionIfRequired(elements.player)
        val bombs            = updateBombsPosition(elements.droppingBombs)
        val mysteryInvader   = updateMysteryInvaderPosition(elements.mysteryInvader)

        new GameElements(invaderArmy, missilesInFlight, barricades, player, bombs, mysteryInvader)
    }

    private def updatedBarricadePosition(barricades: Barricades): Barricades = {
        val barricadeLocation: Point = new Point(screenWidth / 5, screenHeight - (screenHeight / 4))
        barricades.moveTo(barricadeLocation)
    }

    private def updatePlayerPositionIfRequired(player: Player): Player =
        player.topLeft match {
            case p: Point if (p.x == 0 && p.y == 0) => player.moveTo(playerInitialPosition(screenWidth, screenHeight))
            case _ => player

        }

    private def updateMissilesPosition(missilesInFlight: MissilesInFlight): MissilesInFlight =
        missilesInFlight.updatePosition.removeOffScreenMissile

    private def updateBombsPosition(droppingBombs: DroppingBombs): DroppingBombs =
        droppingBombs.updatePosition.removeOffScreenBombs(screenHeight)


    private def updateInvaderArmyPosition(invaderArmy: InvaderArmy): InvaderArmy = {
        if (isTimeToMoveArmy(now))
            invaderArmy.moveTo(nextPosition(displayWindowBoundingBox, invaderArmy.getBoundingBox))
        else invaderArmy
    }

    private def updateMysteryInvaderPosition(possibleInvader: Option[Invader]): Option[Invader] =
        possibleInvader match {
            case Some(invader ) if(invader.isInstanceOf[MysteryInvader])  =>
                val invaderInNewPos: Invader = invader.moveTo(nxtPosition(invader.asInstanceOf[MysteryInvader]))
                if(invaderInNewPos.isInstanceOf[ExplodedInvader]) {
                    Some(invaderInNewPos)
                } else {
                    invaderInNewPos.asInstanceOf[MysteryInvader].removeIfOffScreen(screenWidth)
                }
            case Some(invader ) if(invader.isInstanceOf[ExplodedInvader]) =>
                if(invader.beenExplodingForTooLong(now))
                    None
                else Some(invader)
            case None =>
               MysteryInvader.maybeCreateAnInstance(screenWidth)
        }

    private def now: Long = System.currentTimeMillis()

}
