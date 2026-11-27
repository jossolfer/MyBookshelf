package com.example.mybookshelf.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.mybookshelf.navigation.Routes.*
import com.example.mybookshelf.screens.HomeScreen
import com.example.mybookshelf.screens.login.LoginScreen

@Composable
fun NavigationWrapper() {
    val backStack = rememberNavBackStack(Login)
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Login> {
                LoginScreen() {userName ->
                    backStack.add(Home(userName))
                }
            }
            entry<Home> {key ->
                HomeScreen(key.name) {
                    backStack.removeLastOrNull() ?: Login
                }
            }
        }
    )
}