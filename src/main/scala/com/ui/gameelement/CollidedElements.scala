package com.ui.gameelement

import com.ui.gameelement.missile.Missile
import com.ui.gameelement.invader.types.Invader
import com.ui.gameelement.barricade.Barricade
import com.ui.gameelement.bomb.Bomb

case class CollidedElements(
                               shotInvaders: Seq[(Missile, Invader)],
                               hitBarricadesByMissiles: Seq[(Missile, Barricade)],
                               hitBarricadesByBombs: Seq[(Bomb, Barricade)],
                               isPlayerShot: Boolean
                            )
