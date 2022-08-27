package com.commandiron.handy_compose.common

import androidx.compose.ui.unit.Dp
import kotlin.math.pow

internal fun calculateShapeSize(height: Int): Dp {
    return Dp(height.toFloat().pow(1/2.toFloat()))
}