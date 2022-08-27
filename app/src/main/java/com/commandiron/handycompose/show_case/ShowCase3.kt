package com.commandiron.handycompose.show_case

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.commandiron.handy_compose.list_card.HandyListCard
import com.commandiron.handycompose.Strings

@Composable
fun ShowCase3() {
    LazyColumn(
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        items(12){
            HandyListCard(
                modifier = Modifier.fillMaxWidth().height(60.dp),
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
        }
    }
}