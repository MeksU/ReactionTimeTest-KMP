package pl.meksu.reactiontimetest.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import reactiontimetest.composeapp.generated.resources.Res
import reactiontimetest.composeapp.generated.resources.baseline_access_time_filled_24
import reactiontimetest.composeapp.generated.resources.click_anywhere_to_start_again
import reactiontimetest.composeapp.generated.resources.trophy_icon
import reactiontimetest.composeapp.generated.resources.your_best_score
import reactiontimetest.composeapp.generated.resources.your_reaction_time

@Composable
fun ResultScreen(
    result: String,
    bestScore: String,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                onClick()
            }
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(Res.drawable.baseline_access_time_filled_24),
            contentDescription = "Time",
            tint = Color.White,
            modifier = Modifier.size(128.dp)
        )
        Spacer(Modifier.height(16.dp))
        Text(
            text = stringResource(Res.string.your_reaction_time),
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(12.dp))
        Text(
            text = "$result ms",
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 48.sp,
            lineHeight = 56.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(48.dp))
        Icon(
            painter = painterResource(Res.drawable.trophy_icon),
            contentDescription = "Trophy",
            tint = Color.White,
            modifier = Modifier.size(128.dp)
        )
        Spacer(Modifier.height(16.dp))
        Text(
            text = stringResource(Res.string.your_best_score),
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(12.dp))
        Text(
            text = "$bestScore ms",
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 48.sp,
            lineHeight = 56.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(64.dp))
        Text(
            text = stringResource(Res.string.click_anywhere_to_start_again),
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            lineHeight = 20.sp,
        )
    }
}