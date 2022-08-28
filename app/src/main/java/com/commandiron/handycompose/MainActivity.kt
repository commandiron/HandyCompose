package com.commandiron.handycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.commandiron.handy_compose.HandyColumnCard
import com.commandiron.handy_compose.HandyRowCard
import com.commandiron.handycompose.ui.theme.HandyComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HandyComposeTheme {
                val showCase = 0
                if(showCase == 0){
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
                                    HandyColumnCard(
                                        modifier = Modifier.aspectRatio(1f)
                                    )
                                }
                            }
                        }
                    }
                }else if(showCase == 1){
                    LazyColumn(contentPadding = PaddingValues(8.dp)){
                        items(12){
                            HandyRowCard(
                                modifier = Modifier.height(60.dp)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }
                }
            }
        }
    }
}