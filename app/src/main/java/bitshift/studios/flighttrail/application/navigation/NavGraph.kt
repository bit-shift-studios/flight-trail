package bitshift.studios.flighttrail.application.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import bitshift.studios.flighttrail.application.navigation.routes.AppNavRoutes
import bitshift.studios.flighttrail.presentation.screens.home.composables.HomeScreen
import bitshift.studios.flighttrail.presentation.screens.onboarding.composables.OnboardingScreen
import bitshift.studios.flighttrail.presentation.screens.onboarding.viewmodels.OnboardingViewModel
import kotlinx.coroutines.delay

@Composable
fun NavGraph(navController: NavHostController, startDestination: String) {

	NavHost(navController = navController, startDestination = AppNavRoutes.loading) {
		composable(
			route = AppNavRoutes.loading
		) {
			Box(modifier = Modifier.fillMaxSize())
			LaunchedEffect(Unit) {
				delay(80)
				navController.popBackStack()
				navController.navigate(startDestination)
			}
		}

		composable(
			route = AppNavRoutes.onboarding,
			enterTransition = {
				slideIntoContainer(
					AnimatedContentTransitionScope.SlideDirection.Up,
					animationSpec = tween(250)
				)
			},
			exitTransition = {
				slideOutOfContainer(
					AnimatedContentTransitionScope.SlideDirection.Down,
					animationSpec = tween(250)
				)
			}
		) {
			val viewModel: OnboardingViewModel = hiltViewModel()

			OnboardingScreen(
				onButtonClicked = {
					viewModel.saveOnBoardingState(true)
					navController.popBackStack()
					navController.navigate(AppNavRoutes.home)
				}
			)
		}

		composable(
			route = AppNavRoutes.home,
			enterTransition = {
				slideIntoContainer(
					AnimatedContentTransitionScope.SlideDirection.Left,
					animationSpec = tween(250)
				)
			},
			exitTransition = {
				slideOutOfContainer(
					AnimatedContentTransitionScope.SlideDirection.Right,
					animationSpec = tween(250)
				)
			}
		) {
			HomeScreen()
		}
	}
}