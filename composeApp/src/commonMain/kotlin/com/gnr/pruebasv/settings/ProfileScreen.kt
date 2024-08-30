package com.gnr.pruebasv.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.russhwolf.settings.Settings
import com.russhwolf.settings.set

class ProfileScreen : Screen {

    private val settings: Settings = Settings()

    companion object {
        const val KEY_NAME = "name"
        const val KEY_VIP = "vip"
    }

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        var name by remember { mutableStateOf("") }
        var isVip by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))
            OutlinedTextField(value = name, onValueChange = { name = it })
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = isVip, onCheckedChange = { isVip = it })
                Text("Eres VIP?")
            }
            Button(onClick = {
                settings[KEY_NAME] = name
                settings[KEY_VIP] = isVip
                navigator.push(ProfileResultScreen())
            }, enabled = name.isNotEmpty()) {
                Text("Guardar datos ")
            }
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}