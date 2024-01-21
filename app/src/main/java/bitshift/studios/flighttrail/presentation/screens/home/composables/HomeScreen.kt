package bitshift.studios.flighttrail.presentation.screens.home.composables

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.zIndex
import bitshift.studios.flighttrail.presentation.screens.home.composables.components.AppBar
import bitshift.studios.flighttrail.presentation.screens.home.composables.components.HelpModal
import bitshift.studios.flighttrail.presentation.screens.home.composables.display.AirportMatchesDisplay
import bitshift.studios.flighttrail.presentation.screens.home.viewmodels.HomeViewModel
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral100
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral700
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private data class HomeScreenColors(
	val container: Color
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
	viewModel: HomeViewModel
) {
	val isDarkTheme = isSystemInDarkTheme()
	val uiState = viewModel.homeUIState.collectAsState().value
	val focusManager = LocalFocusManager.current
	val showInfoModal = uiState.showInfoModal

	val width = remember { Animatable(200f) }

	val homeScreenColors = when (isDarkTheme) {
		true -> HomeScreenColors(
			container = Neutral700
		)

		false -> HomeScreenColors(
			container = Neutral100
		)
	}

	if (showInfoModal) {
		HelpModal(
			isDarkTheme = isDarkTheme,
			onOverlayClicked = { viewModel.updateInfoModalVisibility(false) },
			modifier = Modifier.zIndex(9999f)
		)
	}

	Scaffold(
		containerColor = homeScreenColors.container,
		topBar = {
			AppBar(
				width = width.value,
				searchValue = uiState.search,
				onSearchValueChange = {
					viewModel.updateSearch(it)
					viewModel.getAirportsByQuery()
				},
				onSearchBarClicked = {
					CoroutineScope(Dispatchers.IO).launch {
						maximizeSearchBar(width)
					}
				},
				onInfoClicked = {
					focusManager.clearFocus()
					viewModel.updateInfoModalVisibility(true)
				},
				onDoneClicked = {
					focusManager.clearFocus()
					viewModel.getAirportsByQuery()

					CoroutineScope(Dispatchers.IO).launch {
						minimizeSearchBar(width)
					}
				},
				onCloseClicked = {
					if (!showInfoModal) {
						viewModel.clearSearch()
						focusManager.clearFocus()

						CoroutineScope(Dispatchers.IO).launch {
							minimizeSearchBar(width)
						}
					}
				},
				isDarkTheme = isDarkTheme
			)
		}
	) { padding ->
		AnimatedContent(
			targetState = uiState.search.isNotEmpty(),
			label = "airport_matches",
			transitionSpec = {
				(fadeIn() +
					slideInHorizontally(
						animationSpec = tween(300),
						initialOffsetX =  { fullWidth -> fullWidth })).togetherWith(
					fadeOut(
						animationSpec = tween(
							300
						)
					)
				)
			}
		) { airportMatchesVisible ->
			if (airportMatchesVisible) {
				AirportMatchesDisplay(
					isDarkTheme = isDarkTheme,
					padding = padding,
					searchQuery = uiState.search,
					airportResults = uiState.airportResults
				)
			}
		}
	}
}

private suspend fun maximizeSearchBar(width: Animatable<Float, AnimationVector1D>) {
	width.animateTo(
		targetValue = 280f,
		animationSpec = tween(340)
	)
}

private suspend fun minimizeSearchBar(width: Animatable<Float, AnimationVector1D>) {
	width.animateTo(
		targetValue = 200f,
		animationSpec = tween(340)
	)
}