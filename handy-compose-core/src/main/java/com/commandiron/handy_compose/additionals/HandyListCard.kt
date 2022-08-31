package com.commandiron.handy_compose.additionals

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
import androidx.compose.ui.unit.dp
import com.commandiron.handy_compose.core.HandyCard
import com.commandiron.handy_compose.core.HandyColumnCard
import com.commandiron.handy_compose.core.HandyRowCard

@Composable
fun HandyListCard(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary,
    imageContent: @Composable BoxScope.() -> Unit,
    title: String? = null,
    subTitle: String? = null,
    icon: ImageVector? = null,
    iconColor: Color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f),
    onIconClick: () -> Unit = {},
) {
    HandyRowCard(
        modifier = modifier,
        color = color,
        shadowElevation = 4.dp,
        startContent = {
            HandyCard(
                modifier = Modifier.fillMaxSize(),
                shapeSizeFraction = 0.2f
            ) {
                imageContent()
            }
        },
        centerContent = {
            HandyColumnCard(
                topContentWeight = title?.let { 1f } ?: 0f,
                topContent = title?.let {
                    {
                        HandyCard(
                            modifier = Modifier.fillMaxSize(),
                            paddingFraction = 0f,
                            contentAlignment = Alignment.Center
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
                bottomContentWeight = subTitle?.let { 1f } ?: 0f,
                bottomContent = subTitle?.let {
                    {
                        HandyCard(
                            modifier = Modifier.fillMaxSize(),
                            paddingFraction = 0f,
                            contentAlignment = Alignment.Center
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
        },
        endContent = icon?.let {
             {
                HandyCard(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Icon(
                        modifier = Modifier.clickable { onIconClick() },
                        imageVector = it,
                        contentDescription = null,
                        tint = iconColor
                    )
                }
            }
        }
    )
}