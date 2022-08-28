package com.commandiron.handy_compose

import androidx.annotation.FloatRange
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun HandyRowCard(
    modifier: Modifier = Modifier,
    @FloatRange(from = 0.0, to = 1.0) shapeSizeMultiplier: Float = 0.1f,
    @FloatRange(from = 0.0, to = 1.0) contentPaddingMultiplier: Float = 0.1f,
    color: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = contentColorFor(color),
    tonalElevation: Dp = 0.dp,
    shadowElevation: Dp = 0.dp,
    border: BorderStroke? = null,
    startContent: @Composable BoxScope.() -> Unit = {},
    @FloatRange(from = 0.0) startContentWeight: Float = 1f,
    centerContent: @Composable BoxScope.() -> Unit = {},
    @FloatRange(from = 0.0) centerContentWeight: Float = 2f,
    endContent: @Composable BoxScope.() -> Unit = {},
    @FloatRange(from = 0.0) endContentWeight: Float = 1f,
) {
    HandyCard(
        modifier = modifier,
        shapeSizeMultiplier = shapeSizeMultiplier,
        contentPaddingMultiplier = contentPaddingMultiplier,
        color = color,
        contentColor = contentColor,
        tonalElevation = tonalElevation,
        shadowElevation = shadowElevation,
        border = border,
        contentAlignment = Alignment.Center,
    ) {
        Row {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(startContentWeight),
                contentAlignment = Alignment.Center
            ) {
                startContent()
            }
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(centerContentWeight),
                contentAlignment = Alignment.Center
            ) {
                centerContent()
            }
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(endContentWeight),
                contentAlignment = Alignment.Center
            ) {
                endContent()
            }
        }
    }
}











