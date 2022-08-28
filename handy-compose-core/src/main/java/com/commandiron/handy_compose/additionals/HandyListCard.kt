package com.commandiron.handy_compose.additionals

import androidx.annotation.FloatRange
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.commandiron.handy_compose.core.HandyCard
import com.commandiron.handy_compose.core.HandyColumnCard
import com.commandiron.handy_compose.core.HandyRowCard

@Composable
fun HandyListCard(
    modifier: Modifier = Modifier,
    @FloatRange(from = 0.0, to = 1.0) shapeSizeMultiplier: Float = 0.2f,
    @FloatRange(from = 0.0, to = 1.0) contentPaddingMultiplier: Float = 0.1f,
    color: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = MaterialTheme.colorScheme.onPrimary,
    tonalElevation: Dp = 0.dp,
    shadowElevation: Dp = 0.dp,
    border: BorderStroke? = null,
    @FloatRange(from = 0.0) imageWeight: Float = 2f,
    imageContent: (@Composable BoxScope.() -> Unit)? = null,
    @FloatRange(from = 0.0) textWeight: Float = 5f,
    title: String? = null,
    subTitle: String? = null,
    @FloatRange(from = 0.0) iconWeight: Float = 1f,
    icon: ImageVector? = null,
    onIconClick: () -> Unit = {},
) {
    HandyRowCard(
        modifier = modifier,
        shapeSizeMultiplier =  shapeSizeMultiplier,
        contentPaddingMultiplier = contentPaddingMultiplier,
        tonalElevation = tonalElevation,
        shadowElevation = shadowElevation,
        border = border,
        color = color,
        contentColor = contentColor,
        startContentWeight = imageWeight,
        startContent = imageContent?.let {
            {
                HandyCard(
                    modifier = Modifier.fillMaxSize(),
                    shapeSizeMultiplier = 0.2f
                ) {
                    it()
                }
            }
        },
        centerContentWeight = textWeight,
        centerContent = if (title != null || subTitle != null){
            {
                HandyColumnCard(
                    topContent = title?.let {
                        {
                            HandyCard(
                                modifier = Modifier.fillMaxSize(),
                                contentPaddingMultiplier = 0f,
                                contentAlignment = Alignment.BottomCenter
                            ) {
                                Text(
                                    text = it,
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        fontWeight = FontWeight.Bold
                                    ),
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    },
                    bottomContent = subTitle?.let {
                        {
                            HandyCard(
                                modifier = Modifier.fillMaxSize(),
                                contentPaddingMultiplier = 0f,
                                contentAlignment = Alignment.TopCenter
                            ) {
                                Text(
                                    text = it,
                                    style = MaterialTheme.typography.labelSmall,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                )
            }
        } else null,
        endContentWeight = iconWeight,
        endContent = icon?.let {
             {
                HandyCard(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Icon(
                        modifier = Modifier.clickable { onIconClick() },
                        imageVector = it,
                        contentDescription = null,
                        tint = contentColor
                    )
                }
            }
        }
    )
}