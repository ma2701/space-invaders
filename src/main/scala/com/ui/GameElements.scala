package com.ui

import com.ui.gameelement.invader.InvaderArmy
import com.ui.gameelement.missile.MissilesInFlight
import com.ui.gameelement.barricade.Barricades
import com.ui.gameelement.shooter.Shooter


case class GameElements(
                                invaderArmy:InvaderArmy,
                                missiles:MissilesInFlight,
                                barricades:Barricades,
                                shooter:Shooter,
                                totalKilledInvaders:Int)
