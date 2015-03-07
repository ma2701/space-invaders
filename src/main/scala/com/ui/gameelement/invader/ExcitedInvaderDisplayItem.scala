package com.ui.gameelement.invader

import java.awt.Point

import com.ui.gameelement.Displayable
import com.ui.gameelement.displayelement.SingleDisplayElement

case class ExcitedInvaderDisplayItem (tpLft: Point) extends Displayable(tpLft) with ExcitedInvaderParts {
    override val parts:List[SingleDisplayElement] = parts(x,y)
}
