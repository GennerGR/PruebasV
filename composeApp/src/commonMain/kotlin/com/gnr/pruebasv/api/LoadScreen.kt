package com.gnr.pruebasv.api

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.gnr.pruebasv.network.NetworkUtils.httpClient
import com.gnr.pruebasv.network.model.ApiResponse
import com.gnr.pruebasv.network.model.Hero
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch

class LoadScreen : Screen {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        var superheroName by remember { mutableStateOf("") }
        var superheroList by remember { mutableStateOf<List<Hero>>(emptyList()) }

        Column(
            modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                OutlinedTextField(value = superheroName, onValueChange = { superheroName = it })
                Spacer(modifier = Modifier.width(10.dp))
                Button(onClick = { getSuperheroList(superheroName) { superheroList = it } }) {
                    Text("Load")
                }
            }
            //List
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn {
                items(superheroList) { hero ->
                    Box(modifier = Modifier.background(color = Color.Black).padding(5.dp))
                    { Text(hero.name, color = Color.White) }
                    Spacer(modifier = Modifier.height(5.dp))
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                navigator.pop()
            }) {
                Text("Back")
            }
            Spacer(modifier = Modifier.weight(0.1f))
        }
    }

    private fun getSuperheroList(superheroName: String, onSuccessResponse: (List<Hero>) -> Unit) {
        if (superheroName.isBlank()) return
        val url =
            "https://www.superheroapi.com/api.php/41070f7e0f8585ede295035dc984230c/search/$superheroName"
        CoroutineScope(Dispatchers.IO).launch {
            val response = httpClient.get(url).body<ApiResponse>()
            onSuccessResponse(response.results)
        }
    }
}






