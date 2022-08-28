package com.commandiron.handy_compose.additionals

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.commandiron.handy_compose.core.HandyCard
import com.commandiron.handy_compose.core.HandyColumnCard

@Composable
fun HandyGridCard(
    modifier: Modifier = Modifier,
    imageContent: @Composable BoxScope.() -> Unit,
    title: String? = null
) {
    HandyColumnCard(
        modifier = modifier,
        topContent= {
            HandyCard(
                modifier = Modifier.fillMaxSize(),
                shapeSizeMultiplier = 0.2f
            ) {
                imageContent()
            }
        },
        bottomContent = {
            title?.let {
                HandyCard(
                    modifier = Modifier.fillMaxSize(),
                    contentPaddingMultiplier = 0f
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