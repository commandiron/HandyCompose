package com.commandiron.handy_compose.list_card

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.commandiron.handy_compose.HandyText

@Composable
fun HandyListCard(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    cornerSize: Dp? = null,
    startContent: @Composable BoxScope.() -> Unit = {},
    text: String = "",
    textStyle: TextStyle = MaterialTheme.typography.headlineLarge,
    textColor: Color = Color.Unspecified,
    endContentDecoBackgroundColor: Color = Color.Transparent,
    endContentDecoBackgroundShape: Shape = CircleShape,
    endContentDecoIconImageVector: ImageVector? = Icons.Default.AddCircle,
    endContentDecoIconTint: Color = Color.White.copy(alpha = 0.9f),
    endContentDecoIconClick: () -> Unit = {}
) {
    HandyListCardLayout(
        modifier = modifier,
        backgroundColor = backgroundColor,
        cornerSize = cornerSize,
        startContent = startContent,
        centerContent = {
            Box(
                modifier = Modifier
                    .fillMaxSize(0.8f),
                contentAlignment = Alignment.Center
            ) {
                HandyText(
                    color = textColor,
                    text = text,
                    style = textStyle
                )
            }
        },
        endContent = {
            Surface(
                modifier = Modifier
                    .fillMaxSize(0.5f),
                color = endContentDecoBackgroundColor,
                shape = endContentDecoBackgroundShape
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable { endContentDecoIconClick() },
                    contentAlignment = Alignment.Center
                ) {
                    endContentDecoIconImageVector?.let {
                        Icon(
                            modifier = Modifier
                                .fillMaxSize(0.6f),
                            imageVector = it,
                            contentDescription = null,
                            tint = endContentDecoIconTint
                        )
                    }
                }
            }
        }
    )
}

