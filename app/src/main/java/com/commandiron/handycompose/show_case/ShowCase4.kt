package com.commandiron.handycompose.show_case

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.commandiron.handy_compose.list_card.HandyListCard
import com.commandiron.handycompose.Strings

@Composable
fun ShowCase4() {
    Column(modifier = Modifier.padding(8.dp)) {
        repeat(4){
            HandyListCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp + (50.dp * it))
                ,
                startContent = {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(Strings.imageUrl)
                            .crossfade(true)
                            .build(),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds
                    )
                },
                text = Strings.someTextLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}