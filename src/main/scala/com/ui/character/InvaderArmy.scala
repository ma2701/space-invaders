package com.ui.character

import java.awt.{Point, Graphics}
import com.ui.Invader


class InvaderArmy(army:Seq[Invader]) {

    def drawArmy(g: Graphics ) :Unit  = {
        army.foreach { invaderSoldier =>
            invaderSoldier.draw(g)
        }
    }
}
