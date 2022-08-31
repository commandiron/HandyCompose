package com.commandiron.handy_compose.additionals

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.commandiron.handy_compose.core.HandyCard
import com.commandiron.handy_compose.core.HandyColumnCard

@Composable
fun HandyGridCard(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary,
    imageContent: @Composable BoxScope.() -> Unit,
    title: String? = null,
    topStartIcon: ImageVector? = null,
    topEndIcon: ImageVector? = null,
    iconColor: Color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f),
    onIconClick: () -> Unit = {},
) {
    HandyColumnCard(
        modifier = modifier,
        color = color,
        paddingFraction = 0f,
        topContent= {
            HandyCard(
                modifier = Modifier.fillMaxSize(),
                shapeSizeFraction = 0f,
            ) {
                imageContent()
            }
        },
        bottomContent = {
            title?.let {
                HandyCard(
                    shapeSizeFraction = 0f,
                    paddingFraction = 0.1f,
                ) {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.labelSmall,
                        textAlign = TextAlign.Center
                    )
                }
            }
        },
        topStartContent = topStartIcon?.let {
            {
                HandyCard(
                    modifier = Modifier.fillMaxSize(0.5f),
                    color = LocalContentColor.current.copy(alpha = 0f),
                    paddingFraction = 0.2f,
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier = Modifier.clickable { onIconClick() },
                        imageVector = it,
                        contentDescription = null,
                        tint = iconColor
                    )
                }
            }
        },
        topEndContent = topEndIcon?.let {
            {
                HandyCard(
                    modifier = Modifier.fillMaxSize(0.5f),
                    color = LocalContentColor.current.copy(alpha = 0f),
                    paddingFraction = 0.2f,
                    contentAlignment = Alignment.Center
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