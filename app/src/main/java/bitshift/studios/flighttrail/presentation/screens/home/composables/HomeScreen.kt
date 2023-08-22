package bitshift.studios.flighttrail.presentation.screens.home.composables

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral400
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral900

data class Colors(
	val container: Color
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
	modifier: Modifier = Modifier
) {
	val isDarkTheme = isSystemInDarkTheme()

	val colors = Colors(
		container = if (isDarkTheme) Neutral900 else Neutral400
	)

	Scaffold(
		containerColor = colors.container
	) { padding ->
		Column(
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.Center,
			modifier = modifier
				.fillMaxSize()
				.padding(padding)
				.padding(horizontal = 16.dp)
		) {
			Text(
				text = "Home screen",
				color = if (isDarkTheme) Neutral400 else Neutral900
			)
		}
	}
}