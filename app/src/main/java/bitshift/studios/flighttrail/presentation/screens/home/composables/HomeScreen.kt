package bitshift.studios.flighttrail.presentation.screens.home.composables

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral400
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral900

@Composable
fun HomeScreen(
	modifier: Modifier = Modifier
) {
	val isDarkTheme = isSystemInDarkTheme()

	Column(
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center,
		modifier = modifier.fillMaxSize()
	) {
		Text(
			text = "Home screen",
			color = if (isDarkTheme) Neutral400 else Neutral900
		)
	}
}