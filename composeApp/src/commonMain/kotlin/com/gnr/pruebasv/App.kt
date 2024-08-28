package com.gnr.pruebasv

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextForegroundStyle.Unspecified.color
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.transitions.SlideTransition
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import pruebasv.composeapp.generated.resources.Res
import pruebasv.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {
        Navigator(screen = MainScreen()) {navigator: Navigator ->  
            SlideTransition(navigator)
        }
    }
}

class MainScreen:Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Column (modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
            Button( onClick = {
                navigator.push(SecondScreen()) // Crear Segunda Pantalla
            }) {
                Text("Navegación Básica", fontSize = 22.sp, color = Color.White)
            }
            Button( onClick = {
                navigator.push(BottomBar()) // Crear pantalla BottomBar
            }) {
                Text("BottomBar", fontSize = 22.sp, color = Color.White)
            }
        }
    }
}



