package com.ui.gameelement.invader

import java.awt.Point

import com.ui.gameelement.Displayable
import com.ui.gameelement.element.SingleDisplayElement

class ExcitedInvader (topLeft: Point) extends Displayable(topLeft) with ExcitedInvaderParts {
    override val parts:List[SingleDisplayElement] = parts(x,y)
}
