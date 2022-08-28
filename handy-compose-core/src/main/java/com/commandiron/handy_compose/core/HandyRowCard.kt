package com.commandiron.handy_compose.core

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
    @FloatRange(from = 0.0, to = 1.0) shapeSizeMultiplier: Float = 0.2f,
    @FloatRange(from = 0.0, to = 1.0) contentPaddingMultiplier: Float = 0.1f,
    color: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = contentColorFor(color),
    tonalElevation: Dp = 0.dp,
    shadowElevation: Dp = 0.dp,
    border: BorderStroke? = null,
    @FloatRange(from = 0.0) startContentWeight: Float = 2f,
    startContent: (@Composable BoxScope.() -> Unit)? = null,
    @FloatRange(from = 0.0) centerContentWeight: Float = 5f,
    centerContent: (@Composable BoxScope.() -> Unit)? = null,
    @FloatRange(from = 0.0) endContentWeight: Float = 1f,
    endContent: (@Composable BoxScope.() -> Unit)? = null
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
            if(startContentWeight != 0f){
                startContent?.let {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(startContentWeight),
                        contentAlignment = Alignment.Center
                    ) {
                        it()
                    }
                }
            }

            if(centerContentWeight != 0f){
                centerContent?.let {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(centerContentWeight),
                        contentAlignment = Alignment.Center
                    ) {
                        it()
                    }
                }
            }

            if(endContentWeight != 0f){
                endContent?.let {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(endContentWeight),
                        contentAlignment = Alignment.Center
                    ) {
                        it()
                    }
                }
            }
        }
    }
}











