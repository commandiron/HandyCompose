package com.commandiron.handy_compose.grid_card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import com.commandiron.handy_compose.common.calculateShapeSize
import kotlin.math.pow

@Composable
internal fun HandyGridCardLayout(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    cornerSize: Dp? = null,

    mainContent: @Composable BoxScope.() -> Unit = {},
    mainContentBackgroundColor: Color = Color.Transparent,

    subContent: @Composable BoxScope.(Constraints) -> Unit = {},
    subContentBackgroundColor: Color = Color.Transparent,

    topStartDecoration: @Composable BoxScope.() -> Unit = {},
    topEndDecoration: @Composable BoxScope.() -> Unit = {},
    bottomStartDecoration: @Composable BoxScope.() -> Unit = {},
    bottomEndDecoration: @Composable BoxScope.() -> Unit = {},
) {
    val layoutMaxHeight = remember { mutableStateOf(0)}

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
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape)
            ) {
                BoxWithConstraints(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(2f)
                        .clip(
                            RoundedCornerShape(
                                topStart = size,
                                topEnd = size
                            )
                        )
                        .background(
                            color = mainContentBackgroundColor
                        ),
                    contentAlignment = Alignment.Center
                ){
                    mainContent()
                }
                BoxWithConstraints(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .clip(
                            RoundedCornerShape(
                                bottomStart = size,
                                bottomEnd = size
                            )
                        )
                        .background(
                            color = subContentBackgroundColor
                        ),
                    contentAlignment = Alignment.Center
                ){
                    subContent(constraints)
                }
            }
            Box(Modifier.fillMaxSize()) {
                BoxWithConstraints(
                    modifier = Modifier
                        .fillMaxSize(0.5f)
                        .align(Alignment.TopStart),
                    contentAlignment = Alignment.TopStart
                ) {
                    topStartDecoration()
                }
                BoxWithConstraints(
                    modifier = Modifier
                        .fillMaxSize(0.5f)
                        .align(Alignment.TopEnd),
                    contentAlignment = Alignment.TopEnd
                ) {
                    topEndDecoration()
                }
                BoxWithConstraints(
                    modifier = Modifier
                        .fillMaxSize(0.5f)
                        .align(Alignment.BottomStart),
                    contentAlignment = Alignment.BottomStart
                ) {
                    bottomStartDecoration()
                }
                BoxWithConstraints(
                    modifier = Modifier
                        .fillMaxSize(0.5f)
                        .align(Alignment.BottomEnd),
                    contentAlignment = Alignment.BottomEnd
                ) {
                    bottomEndDecoration()
                }
            }
        }
    }
}
















