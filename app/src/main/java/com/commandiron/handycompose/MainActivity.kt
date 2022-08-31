package com.commandiron.handycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.commandiron.handy_compose.additionals.HandyGridCard
import com.commandiron.handy_compose.core.HandyColumnCard
import com.commandiron.handy_compose.additionals.HandyListCard
import com.commandiron.handy_compose.core.HandyRowCard
import com.commandiron.handycompose.ui.theme.HandyComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HandyComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){}
                when (0) {
                    //CORE
                    0 -> {
                        Column {
                            repeat(5){
                                LazyHorizontalGrid(
                                    rows = GridCells.Fixed(1),
                                    modifier = Modifier.height(64.dp + (32.dp * it)),
                                    contentPadding = PaddingValues(8.dp),
                                    verticalArrangement = Arrangement.spacedBy(8.dp),
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ){
                                    items(12){
                                        HandyColumnCard(
                                            modifier = Modifier.aspectRatio(1f).clickable {  }
                                        )
                                    }
                                }
                            }
                        }
                    }
                    1 -> {
                        LazyColumn(contentPadding = PaddingValues(8.dp)) {
                            items(5) { index ->
                                HandyRowCard(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(
                                            64.dp + (32.dp * index)
                                        ).clickable {  }
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                            }
                        }
                    }
                    //ADDITIONALS
                    2 -> {
                        Column(modifier = Modifier.padding(8.dp)) {
                            repeat(5){
                                HandyListCard(
                                    modifier = Modifier.height(64.dp + (32.dp * it)),
                                    imageContent = {
                                        AsyncImage(
                                            model = ImageRequest.Builder(LocalContext.current)
                                                .data(Strings.imageUrl)
                                                .crossfade(true)
                                                .build(),
                                            contentDescription = null,
                                            contentScale = ContentScale.Crop
                                        )
                                    },
                                    title = Strings.someTextSmall,
                                    subTitle = Strings.someTextSmall,
                                    icon = Icons.Default.AddCircle
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                            }

                        }
                    }
                    3 -> {
                        LazyColumn(contentPadding = PaddingValues(8.dp)){
                            items(12){
                                HandyListCard(
                                    modifier = Modifier.height(64.dp),
                                    imageContent = {
                                        AsyncImage(
                                            model = ImageRequest.Builder(LocalContext.current)
                                                .data(Strings.imageUrl)
                                                .crossfade(true)
                                                .build(),
                                            contentDescription = null,
                                            contentScale = ContentScale.Crop
                                        )
                                    },
                                    title = Strings.someTextSmall,
                                    subTitle = Strings.someTextSmall,
                                    icon = Icons.Default.AddCircle
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                            }
                        }
                    }
                    4 -> {
                        Column {
                            repeat(5){
                                LazyHorizontalGrid(
                                    rows = GridCells.Fixed(1),
                                    modifier = Modifier.height(64.dp + (32.dp * it)),
                                    contentPadding = PaddingValues(8.dp),
                                    verticalArrangement = Arrangement.spacedBy(8.dp),
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ){
                                    items(12){
                                        HandyGridCard(
                                            modifier = Modifier.aspectRatio(1f),
                                            imageContent = {
                                                AsyncImage(
                                                    model = ImageRequest.Builder(LocalContext.current)
                                                        .data(Strings.imageUrl)
                                                        .crossfade(true)
                                                        .build(),
                                                    contentDescription = null,
                                                    contentScale = ContentScale.Crop
                                                )
                                            },
                                            title = Strings.someTextSmall,
                                            topEndIcon = Icons.Default.AddCircle
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}