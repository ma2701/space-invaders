package com.ui.gameelement.missile

import com.ui.gameelement.element.SingleDisplayElement
import com.ui.gameelement.element.SingleDisplayElement._


case class Line(topX: Int, topY: Int) extends SingleDisplayElement(
    topX,topY, DEFAULT_ELEMENT_WIDTH, 3* DEFAULT_ELEMENT_HEIGHT)