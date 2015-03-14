package com.ui

import com.ui.gameelement.invader.InvaderArmy
import com.ui.gameelement.missile.MissilesInFlight
import com.ui.gameelement.barricade.Barricades
import com.ui.gameelement.bomb.DroppingBombs
import com.ui.gameelement.player.types.Player


case class GameElements(
                         invaderArmy: InvaderArmy,
                         missilesInFlight: MissilesInFlight,
                         barricades: Barricades,
                         player: Player,
                         droppingBombs:DroppingBombs
                       )
