package com.gnr.pruebasv.api

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

class LoadScreen:Screen{

    @Composable
    override fun Content() {

        var navigator = LocalNavigator.currentOrThrow
        Column {
             Row {
                 OutlinedTextField(value = , onValueChange = { = it})
                 Button(onClick = {

                 }){
                     Text("Load")
                 }
             }

            LazyColumn {

            }

            Button(onClick = {
                navigator.pop()
            }){
                Text("Back")
            }
        }
    }
}