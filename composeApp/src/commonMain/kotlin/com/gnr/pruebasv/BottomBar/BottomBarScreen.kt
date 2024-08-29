package com.gnr.pruebasv.BottomBar

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.TabDisposable
import cafe.adriel.voyager.navigator.tab.TabNavigator

class BottomBarScreen : Screen {

    @Composable
    override fun Content() {
        TabNavigator(
            HomeTab,
            tabDisposable = {
                TabDisposable(
                    it,
                    listOf(HomeTab)
                )
            }
        ) {
            Scaffold(
                topBar = {
                    TopAppBar(title = { Text(it.current.options.title) })
                },
                bottomBar = {
                    BottomNavigation {
                        val tabNavigator = LocalTabNavigator.current

                        BottomNavigationItem(
                            selected = tabNavigator.current.key == HomeTab.key,
                            label = { Text(it.current.options.title) },
                            icon = {
                                Icon(
                                    painter = HomeTab.options.icon!!,
                                    contentDescription = null
                                )
                            },
                            onClick ={tabNavigator.current = HomeTab}
                        )

                        BottomNavigationItem(
                            selected = tabNavigator.current.key == FavTab.key,
                            label = { Text(it.current.options.title) },
                            icon = {
                                Icon(
                                    painter = FavTab.options.icon!!,
                                    contentDescription = null
                                )
                            },
                            onClick = {tabNavigator.current = FavTab}
                        )

                        BottomNavigationItem(
                            selected = tabNavigator.current.key == ProfileTab.key,
                            label = {Text(it.current.options.title)},
                            icon = {
                                Icon(
                                    painter = ProfileTab.options.icon!!,
                                    contentDescription = null
                                )
                            },
                            onClick = {tabNavigator.current = ProfileTab}
                        )
                    }
                } , content = {

                }
            )
        }
    }
}




