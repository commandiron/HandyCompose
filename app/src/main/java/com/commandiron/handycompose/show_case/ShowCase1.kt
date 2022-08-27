package com.commandiron.handycompose.show_case

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
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
fun ShowCase1() {
    Column() {
        repeat(4){
            LazyHorizontalGrid(
                rows = GridCells.Fixed(1),
                modifier = Modifier.height(100.dp + (50.dp * it)),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ){
                items(12){
                    HandyGridCard(
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
    }
}