package com.ui.gameelement

import com.ui.gameelement.missile.Missile
import com.ui.gameelement.invader.types.Invader
import com.ui.gameelement.barricade.{Barricades, Barricade}
import com.ui.GameElements
import com.ui.gameelement.bomb.Bomb


class CollisionDetection {
    
    def detectAllCollidedElements(gameElements: GameElements): CollidedElements = {
        CollidedElements(
            findShotInvaders(gameElements.missilesInFlight.missiles, gameElements.invaderArmy.army),
            findBarricadesHitWithMissiles(gameElements.missilesInFlight.missiles, gameElements.barricades),
            findBarricadesHitWithBombs(gameElements.droppingBombs.bombs, gameElements.barricades),
            false)
    }
    
    private def findShotInvaders(missiles: Seq[Missile], army:Seq[Invader]):Seq[(Missile, Invader)] = {
        def findAHit(missile: Missile, soldiers: Seq[Invader]): Option[Invader] = {
            if (soldiers == Nil) None
            else if (hasCollided(missile, soldiers.head)) Some(soldiers.head)
            else findAHit(missile, soldiers.tail)
        }

        missiles.foldLeft(List[(Missile, Invader)]()) {
            (acc, missile) =>
                findAHit(missile, army) match {
                    case Some(soldier) => (missile, soldier) :: acc
                    case None => acc
                }
        }
    }

    private def findBarricadesHitWithMissiles(missiles: Seq[Missile], barricades: Barricades): Seq[(Missile, Barricade)] = {
        def findAHit(missile: Missile, barricades: Seq[Barricade]): Option[Barricade] = {
            if (barricades == Nil) None
            else if (hasCollided(missile, barricades.head)) {
                Some(barricades.head)
            }
            else findAHit(missile, barricades.tail)
        }

        missiles.foldLeft(List[(Missile, Barricade)]()) {
            (acc, missile) =>
                findAHit(missile, barricades.covers) match {
                    case Some(barricade) => (missile, barricade) :: acc
                    case None => acc
                }
        }
    }
    
    private def findBarricadesHitWithBombs(bombs: Seq[Bomb], barricades: Barricades): Seq[(Bomb, Barricade)] = {
        def findAHit(bomb: Bomb, barricades: Seq[Barricade]): Option[Barricade] = {
            if (barricades == Nil) None
            else if (hasCollided(bomb, barricades.head)) {
                Some(barricades.head)
            }
            else findAHit(bomb, barricades.tail)
        }

        bombs.foldLeft(List[(Bomb, Barricade)]()) {
            (acc, missile) =>
                findAHit(missile, barricades.covers) match {
                    case Some(barricade) => (missile, barricade) :: acc
                    case None => acc
                }
        }
    }
    
    private def hasCollided(missile: Missile, soldier: Invader): Boolean = soldier.boundingBox.intersects(missile.boundingBox)

    private def hasCollided(missile: Missile, barricade: Barricade): Boolean = barricade.boundingBox.intersects(missile.boundingBox)

    private def hasCollided(bomb: Bomb, barricade: Barricade): Boolean = barricade.boundingBox.intersects(bomb.boundingBox)
}


