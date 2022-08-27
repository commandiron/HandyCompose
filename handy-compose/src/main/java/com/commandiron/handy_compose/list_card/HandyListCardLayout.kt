package com.commandiron.handy_compose.list_card

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.commandiron.handy_compose.common.calculateShapeSize

@Composable
internal fun HandyListCardLayout(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    cornerSize: Dp? = null,

    startContent: @Composable BoxScope.() -> Unit = {},

    centerContent: @Composable BoxScope.() -> Unit = {},

    endContent: @Composable BoxScope.() -> Unit = {},
) {
    val layoutMaxHeight = remember { mutableStateOf(0) }

    val calculatedCornerSize = calculateShapeSize(layoutMaxHeight.value)

    val size = cornerSize ?: calculatedCornerSize
    val shape = RoundedCornerShape(size)

    Surface(
        modifier = modifier,
        color = backgroundColor,
        shape = shape
    ) {
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .clip(shape)
        ){
            layoutMaxHeight.value = constraints.maxHeight
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape)
            ) {
                BoxWithConstraints(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .clip(
                            RoundedCornerShape(
                                topStart = size,
                                bottomStart = size
                            )
                        ),
                    contentAlignment = Alignment.Center
                ){
                    startContent()
                }
                BoxWithConstraints(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(2f),
                    contentAlignment = Alignment.Center
                ){
                    centerContent()
                }
                BoxWithConstraints(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .clip(
                            RoundedCornerShape(
                                topEnd = size,
                                bottomEnd = size
                            )
                        ),
                    contentAlignment = Alignment.Center
                ){
                    endContent()
                }
            }
        }
    }
}














