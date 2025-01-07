package pl.meksu.reactiontimetest.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import reactiontimetest.composeapp.generated.resources.Res
import reactiontimetest.composeapp.generated.resources.baseline_front_hand_24
import reactiontimetest.composeapp.generated.resources.wait_for_green

@Composable
fun WaitScreen(
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
            painter = painterResource(Res.drawable.baseline_front_hand_24),
            contentDescription = "Wait hand",
            tint = Color.White,
            modifier = Modifier.size(128.dp)
        )
        Spacer(Modifier.height(32.dp))
        Text(
            text = stringResource(Res.string.wait_for_green),
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 40.sp,
            lineHeight = 48.sp,
            fontWeight = FontWeight.Bold
        )
    }
}