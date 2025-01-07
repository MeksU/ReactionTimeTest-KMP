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
import reactiontimetest.composeapp.generated.resources.click_anywhere_to_start
import reactiontimetest.composeapp.generated.resources.lightning_icon
import reactiontimetest.composeapp.generated.resources.reaction_time_test
import reactiontimetest.composeapp.generated.resources.when_the_red_background_turns_green

@Composable
fun StartScreen(
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
            painter = painterResource(Res.drawable.lightning_icon),
            contentDescription = "Lightning",
            tint = Color.White,
            modifier = Modifier.size(128.dp)
        )
        Spacer(Modifier.height(16.dp))
        Text(
            text = stringResource(Res.string.reaction_time_test),
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 32.sp,
            lineHeight = 40.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(64.dp))
        Text(
            text = stringResource(Res.string.when_the_red_background_turns_green),
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            lineHeight = 32.sp
        )
        Spacer(Modifier.height(64.dp))
        Text(
            text = stringResource(Res.string.click_anywhere_to_start),
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            lineHeight = 24.sp
        )
    }
}