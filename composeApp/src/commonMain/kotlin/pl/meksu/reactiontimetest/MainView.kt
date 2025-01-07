package pl.meksu.reactiontimetest

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.delay
import pl.meksu.reactiontimetest.screen.GreenScreen
import pl.meksu.reactiontimetest.screen.ResultScreen
import pl.meksu.reactiontimetest.screen.StartScreen
import pl.meksu.reactiontimetest.screen.TooSoonScreen
import pl.meksu.reactiontimetest.screen.WaitScreen
import kotlin.random.Random

@Composable
fun MainView(viewModel: MainViewModel) {
    val screenState by viewModel.screenState.collectAsState()
    val result by viewModel.result.collectAsState()
    val bestScore by viewModel.bestScore.collectAsState()

    val backgroundColor = when (screenState) {
        1 -> Color(0xFF3C5898)
        2 -> Color(0xFFDC143C)
        3 -> Color(0xFF04B962)
        4 -> Color(0xFF04B962)
        5 -> Color(0xFFDC143C)
        else -> Color(0xFF000000)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        when (screenState) {
            1 -> {
                StartScreen {
                    viewModel.onStartClicked()
                }
            }
            2 -> {
                WaitScreen {
                    viewModel.navigateToTooSoonScreen()
                }
                LaunchedEffect(Unit) {
                    delay(Random.nextLong(2000, 9000))
                    viewModel.onWaitScreenTimeout()
                }
            }
            3 -> {
                GreenScreen {
                    viewModel.navigateToResultScreen()
                }
            }
            4 -> {
                ResultScreen(
                    result = result.toString(),
                    bestScore = bestScore.toString(),
                    onClick = {
                        viewModel.navigateToWaitScreen()
                    }
                )
            }
            5 -> {
                TooSoonScreen {
                    viewModel.navigateToWaitScreen()
                }
            }
        }
    }
}