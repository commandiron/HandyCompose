package com.commandiron.handy_compose.core

import androidx.annotation.FloatRange
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun HandyCard(
    modifier: Modifier = Modifier,
    @FloatRange(from = 0.0, to = 1.0) shapeSizeFraction: Float = 0.1f,
    @FloatRange(from = 0.0, to = 1.0) paddingFraction: Float = 0f,
    border: BorderStroke? = null,
    color: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = contentColorFor(color),
    shadowElevation: Dp = 0.dp,
    contentAlignment: Alignment = Alignment.Center,
    content: @Composable BoxScope.() -> Unit
) {
    val layoutMaxHeight = remember { mutableStateOf(0) }

    val shapeSize = with(LocalDensity.current) {
        (layoutMaxHeight.value * shapeSizeFraction).toDp()
    }

    val contentPadding = with(LocalDensity.current) {
        (layoutMaxHeight.value * paddingFraction).toDp()
    }
    Surface(
        modifier = Modifier
            .clip(RoundedCornerShape(shapeSize))
            .then(modifier),
        shape = RoundedCornerShape(shapeSize),
        color = color,
        contentColor = contentColor,
        shadowElevation = shadowElevation,
        border = border
    ){
        BoxWithConstraints(
            contentAlignment = contentAlignment
        ){
            layoutMaxHeight.value = constraints.maxHeight
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(shapeSize))
                    .padding(contentPadding),
                contentAlignment = contentAlignment
            ) {
                content()
            }
        }
    }
}











