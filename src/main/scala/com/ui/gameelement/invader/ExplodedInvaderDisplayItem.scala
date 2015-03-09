package com.ui.gameelement.invader

import java.awt.{Rectangle, Point}
import com.ui.gameelement.Displayable
import com.ui.gameelement.displayelement.SingleDisplayElement

class ExplodedInvaderDisplayItem (topLeft: Point) extends Displayable(topLeft) with ExplodedInvaderParts {
    override val parts:List[SingleDisplayElement] = parts(x,y)
}
