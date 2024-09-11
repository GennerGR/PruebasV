package com.gnr.pruebasv.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.gnr.pruebasv.settings.ProfileScreen.Companion.KEY_NAME
import com.gnr.pruebasv.settings.ProfileScreen.Companion.KEY_VIP
import com.russhwolf.settings.Settings

class ProfileResultScreen : Screen {


    private val settings: Settings = Settings()

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        val isVip: Boolean = settings.getBoolean(KEY_VIP, false)

        val backgroundColor: Color = if (isVip) {
            Color.Yellow
        } else {
            Color.White
        }

        Column(
            modifier = Modifier.fillMaxSize().background(backgroundColor),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val name: String = settings.getString(KEY_NAME, "")
            Spacer(modifier = Modifier.weight(1f))
            Text("Bienvenido $name", fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Button(onClick = {
                settings.clear()
                navigator.pop()
            }) { Text("volver y borrar datos") }
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}