package com.commandiron.handy_compose

import androidx.annotation.FloatRange
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
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
    @FloatRange(from = 0.0, to = 1.0) shapeSizeMultiplier: Float = 0.1f,
    @FloatRange(from = 0.0, to = 1.0) contentPaddingMultiplier: Float = 0.1f,
    color: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = contentColorFor(color),
    tonalElevation: Dp = 0.dp,
    shadowElevation: Dp = 0.dp,
    border: BorderStroke? = null,
    topContent: @Composable BoxScope.() -> Unit = {},
    @FloatRange(from = 0.0) topContentWeight: Float = 2f,
    centerContent: @Composable BoxScope.() -> Unit = {},
    @FloatRange(from = 0.0) centerContentWeight: Float = 0f,
    bottomContent: @Composable BoxScope.() -> Unit = {},
    @FloatRange(from = 0.0) bottomContentWeight: Float = 1f,
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
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(topContentWeight),
                    contentAlignment = Alignment.Center
                ) {
                    topContent()
                }
            }

            if(centerContentWeight != 0f){
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(centerContentWeight),
                    contentAlignment = Alignment.Center
                ) {
                    centerContent()
                }
            }

            if(bottomContentWeight != 0f){
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(bottomContentWeight),
                    contentAlignment = Alignment.Center
                ) {
                    bottomContent()
                }
            }
        }
    }
}











