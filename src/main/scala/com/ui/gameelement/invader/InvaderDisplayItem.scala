package com.ui.gameelement.invader

import java.awt.Point

import com.ui.gameelement.Displayable
import com.ui.gameelement.displayelement.SingleDisplayElement

class InvaderDisplayItem (topLeft: Point) extends Displayable(topLeft) with InvaderParts {
    override val parts:List[SingleDisplayElement] = parts(x,y)
}
