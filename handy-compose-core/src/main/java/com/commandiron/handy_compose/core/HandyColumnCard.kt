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
fun HandyColumnCard(
    modifier: Modifier = Modifier,
    @FloatRange(from = 0.0, to = 1.0) shapeSizeMultiplier: Float = 0.2f,
    @FloatRange(from = 0.0, to = 1.0) contentPaddingMultiplier: Float = 0.1f,
    color: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = contentColorFor(color),
    tonalElevation: Dp = 0.dp,
    shadowElevation: Dp = 0.dp,
    border: BorderStroke? = null,
    @FloatRange(from = 0.0) topContentWeight: Float = 1f,
    topContent: (@Composable BoxScope.() -> Unit)? = null,
    @FloatRange(from = 0.0) centerContentWeight: Float = 0f,
    centerContent: (@Composable BoxScope.() -> Unit)? = null,
    @FloatRange(from = 0.0) bottomContentWeight: Float = 1f,
    bottomContent: (@Composable BoxScope.() -> Unit)? = null
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
        Column {
            if(topContentWeight != 0f){
                topContent?.let {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(topContentWeight),
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
                            .fillMaxWidth()
                            .weight(centerContentWeight),
                        contentAlignment = Alignment.Center
                    ) {
                        it()
                    }
                }
            }

            if(bottomContentWeight != 0f){
                bottomContent?.let {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(bottomContentWeight),
                        contentAlignment = Alignment.Center
                    ) {
                        it()
                    }
                }
            }
        }
    }
}










