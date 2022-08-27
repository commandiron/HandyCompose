package com.commandiron.handycompose.show_case

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.commandiron.handy_compose.grid_card.HandyGridCard
import com.commandiron.handycompose.Strings

@Composable
fun ShowCase2() {
    Row() {
        repeat(5){
            HandyGridCard(
                modifier = Modifier.size(250.dp - (50.dp * it)),
                mainContent = {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(Strings.imageUrl)
                            .crossfade(true)
                            .build(),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds
                    )
                },
                text = Strings.someTextSmall
            )
        }
    }
}