package bitshift.studios.flighttrail.presentation.screens.home.composables

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.animateDpAsState
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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import bitshift.studios.flighttrail.presentation.screens.home.composables.components.AppBar
import bitshift.studios.flighttrail.presentation.screens.home.composables.components.HelpModal
import bitshift.studios.flighttrail.presentation.screens.home.composables.display.AirportMatchesDisplay
import bitshift.studios.flighttrail.presentation.screens.home.viewmodels.HomeViewModel
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral100
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral600

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
	val showIconButton = uiState.showIconButton
	val showInfoModal = uiState.showInfoModal

	val width by animateDpAsState(
		targetValue = if (showIconButton) 64.dp else 280.dp,
		animationSpec = tween(200),
		label = "width anim"
	)

	val homeScreenColors = when (isDarkTheme) {
		true -> HomeScreenColors(
			container = Neutral600
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
				width = width,
				searchValue = uiState.search,
				onSearchValueChange = {
					viewModel.updateSearch(it)
				},
				onButtonClicked = {
					if (!showInfoModal) {
						viewModel.updateIconButtonVisibility(false)
					}
				},
				onHelpButtonClicked = { viewModel.updateInfoModalVisibility(true) },
				onCloseClicked = {
					if (!showInfoModal) {
						viewModel.updateIconButtonVisibility(true)
					}
				},
				showIconButton = showIconButton,
				showSearchBar = !showIconButton,
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
					padding = padding
				)
			}
		}
	}
}