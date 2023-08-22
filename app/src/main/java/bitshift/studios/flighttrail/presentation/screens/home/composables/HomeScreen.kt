package bitshift.studios.flighttrail.presentation.screens.home.composables

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import bitshift.studios.flighttrail.presentation.screens.home.composables.components.AppBar
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral400
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral900
import kotlinx.coroutines.launch

data class Colors(
	val container: Color
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
	modifier: Modifier = Modifier
) {
	val isDarkTheme = isSystemInDarkTheme()
	val coroutineScope = rememberCoroutineScope()
	val width = remember { Animatable(0f) }
	var showIconButton by remember { mutableStateOf(true) }

	val colors = Colors(
		container = if (isDarkTheme) Neutral900 else Neutral400
	)

	Scaffold(
		containerColor = colors.container,
		topBar = {
			AppBar(
				width = width,
				searchValue = "",
				onSearchValueChange = {},
				onButtonClicked = {
					coroutineScope.launch {
						showIconButton = false
						width.animateTo(240f, tween(200))
					}
				},
				onHelpButtonClicked = { /*TODO*/ },
				onCloseClicked = {
					coroutineScope.launch {
						width.animateTo(0f, tween(250))
						showIconButton = true
					}
				},
				showIconButton = showIconButton,
				isDarkTheme = isDarkTheme
			)
		}
	) { padding ->
		Column(
			modifier = modifier
				.fillMaxSize()
				.padding(padding)
				.padding(horizontal = 16.dp)
		) {}
	}
}