package com.ui.gameelement.invader

import java.awt.Point
import com.ui.gameelement.Displayable
import com.ui.gameelement.element.SingleDisplayElement

class ExplodedInvader (topLeft: Point) extends Displayable(topLeft) with InvaderExplodedParts {
    override val parts:List[SingleDisplayElement] = parts(x,y)
}
