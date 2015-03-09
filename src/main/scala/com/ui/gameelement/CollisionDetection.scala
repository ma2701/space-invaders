package com.ui.gameelement

import com.ui.gameelement.missile.Missile
import com.ui.gameelement.invader.types.Invader
import com.ui.gameelement.barricade.{Barricades, Barricade}
import com.ui.GameElements
import com.ui.gameelement.bomb.Bomb
import com.ui.gameelement.player.Player


object CollisionDetection {

    def detectCollisions(gameElements: GameElements): CollidedElements =
        CollidedElements(
            findShotInvaders(gameElements.missilesInFlight.missiles, gameElements.invaderArmy.army),
            findBarricadesHitWithMissiles(gameElements.missilesInFlight.missiles, gameElements.barricades),
            findBarricadesHitWithBombs(gameElements.droppingBombs.bombs, gameElements.barricades),
            isPlayerHit(gameElements.player, gameElements.droppingBombs.bombs)
        )

    private def findShotInvaders(missiles: Seq[Missile], army: Seq[Invader]): Seq[(Missile, Invader)] =
        findCollidedItems(missiles, army)

    private def findBarricadesHitWithMissiles(missiles: Seq[Missile], barricades: Barricades): Seq[(Missile, Barricade)] =
        findCollidedItems(missiles, barricades.covers)


    private def findBarricadesHitWithBombs(bombs: Seq[Bomb], barricades: Barricades): Seq[(Bomb, Barricade)] =
        findCollidedItems(bombs, barricades.covers)

    private def isPlayerHit(player:Player, bombs:Seq[Bomb]):Boolean =
        (!bombs.isEmpty) && hasCollided(bombs.reverse.head, player)


    private def findCollidedItems[T <: Displayable, A <: Displayable](items: Seq[T], otherItems: Seq[A]): Seq[(T, A)] = {

        def findAHit(item: T, listOfOtherItems: Seq[A]): Option[A] = {
            if (listOfOtherItems == Nil) None
            else if (hasCollided(item, listOfOtherItems.head)) {
                Some(listOfOtherItems.head)
            }
            else findAHit(item, listOfOtherItems.tail)
        }

        items.foldLeft(List[(T, A)]()) {
            (acc: List[(T, A)], item: T) =>
                findAHit(item, otherItems) match {
                    case Some(otherItem) => (item, otherItem) :: acc
                    case None => acc
                }
        }
    }

    def hasCollided[T <: Displayable, A <: Displayable](item: T, anotherItem: A): Boolean =
        item.boundingBox.intersects(anotherItem.boundingBox)
}


