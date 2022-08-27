package com.commandiron.handy_compose.grid_card

import androidx.annotation.FloatRange
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.commandiron.handy_compose.HandyText

@Composable
fun HandyGridCard(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    cornerSize: Dp? = null,
    @FloatRange(from = 1.0, to = Double.MAX_VALUE) aspectRatio: Float = 1f,
    mainContent: @Composable BoxScope.() -> Unit = {},
    text: String = "",
    textStyle: TextStyle = MaterialTheme.typography.headlineLarge,
    textColor: Color = Color.Unspecified,
    topStartDecoBackgroundColor: Color = Color.Transparent,
    topStartDecoBackgroundShape: Shape = CircleShape,
    topStartDecoIconImageVector: ImageVector? = Icons.Default.Delete,
    topStartDecoIconTint: Color = Color.Red.copy(alpha = 0.9f),
    onTopStartDecoIconClick: () -> Unit = {},
    topEndDecoBackgroundColor: Color = Color.Transparent,
    topEndDecoBackgroundShape: Shape = CircleShape,
    topEndDecoIconImageVector: ImageVector? = Icons.Default.AddCircle,
    topEndDecoIconTint: Color = Color.White.copy(alpha = 0.9f),
    onTopEndDecoIconClick: () -> Unit = {}
) {
    HandyGridCardLayout(
        modifier = modifier.aspectRatio(aspectRatio),
        backgroundColor = backgroundColor,
        cornerSize = cornerSize,
        mainContent = mainContent,
        subContent = {
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
        topStartDecoration = {
            Surface(
                modifier = Modifier
                    .fillMaxSize(0.5f),
                color = topStartDecoBackgroundColor,
                shape = topStartDecoBackgroundShape
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable { onTopStartDecoIconClick() },
                    contentAlignment = Alignment.Center
                ) {
                    topStartDecoIconImageVector?.let {
                        Icon(
                            modifier = Modifier
                                .fillMaxSize(0.6f),
                            imageVector = it,
                            contentDescription = null,
                            tint = topStartDecoIconTint
                        )
                    }
                }
            }
        },
        topEndDecoration = {
            Surface(
                modifier = Modifier
                    .fillMaxSize(0.5f),
                color = topEndDecoBackgroundColor,
                shape = topEndDecoBackgroundShape
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable { onTopEndDecoIconClick() },
                    contentAlignment = Alignment.Center
                ) {
                    topEndDecoIconImageVector?.let {
                        Icon(
                            modifier = Modifier
                                .fillMaxSize(0.6f),
                            imageVector = it,
                            contentDescription = null,
                            tint = topEndDecoIconTint
                        )
                    }
                }
            }
        }
    )
}

