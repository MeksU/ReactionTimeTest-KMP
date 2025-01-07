package pl.meksu.reactiontimetest

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

fun main() {
    val dataStore = createDataStore {
        DATA_STORE_FILE_NAME
    }

    application {
        val state = rememberWindowState(
            width = 800.dp,
            height = 800.dp,
        )
        Window(
            onCloseRequest = ::exitApplication,
            title = "ReactionTimeTest",
            state = state
        ) {
            App(
                dataStore = dataStore
            )
        }
    }
}