package pl.meksu.reactiontimetest

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(
    dataStore: DataStore <Preferences>
) {
    MaterialTheme {
        val viewModel = MainViewModel(dataStore)
        MainView(viewModel)
    }
}