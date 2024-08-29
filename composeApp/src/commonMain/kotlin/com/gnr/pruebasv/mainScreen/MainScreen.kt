package com.gnr.pruebasv.mainScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.gnr.pruebasv.BottomBar.BottomBarScreen
import com.gnr.pruebasv.secondScreen.SecondScreen


class MainScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {
                navigator.push(SecondScreen()) // agg SecondScreen
            }) {
                Text("SecondScreen", fontSize = 22.sp, color = Color.White)
            }
            Spacer(Modifier.height(16.dp))
            Button(onClick = {
                navigator.push(BottomBarScreen())// agg BottomBarScreen
            }) {
                Text("BottomBarScreen", fontSize = 22.sp, color = Color.White)
            }
        }
    }
}
