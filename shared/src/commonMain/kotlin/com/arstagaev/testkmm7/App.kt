package com.arstagaev.testkmm7

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow

@Composable
fun App() {
    MaterialTheme {
        Navigator(
            screen = BasicNavigationScreen(index = 0),
            onBackPressed = { currentScreen ->
                //Log.d("Navigator", "Pop screen #${(currentScreen as BasicNavigationScreen).index}")
                true
            }
        )
    }
}

data class BasicNavigationScreen(
    val index: Int,
    val wrapContent: Boolean = false
) : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Box(Modifier.fillMaxSize().background(Color.Magenta).clickable {
            navigator.push(DetailsScreen(index))
        })
    }

}

data class DetailsScreen(
    val index: Int,
    val wrapContent: Boolean = false
) : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Box(Modifier.fillMaxSize().background(Color.Yellow).clickable {
            navigator.push(BasicNavigationScreen(index))
        })
    }

}

//expect fun getPlatformName(): String