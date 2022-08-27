package com.commandiron.handycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.commandiron.handycompose.show_case.ShowCase1
import com.commandiron.handycompose.ui.theme.HandyComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HandyComposeTheme {
                ShowCase1()
//                ShowCase2()
//                ShowCase3()
//                ShowCase4()
            }
        }
    }
}