package bitshift.studios.flighttrail.application.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import bitshift.studios.flighttrail.application.navigation.routes.AppNavRoutes
import bitshift.studios.flighttrail.presentation.screens.home.composables.HomeScreen
import bitshift.studios.flighttrail.presentation.screens.onboarding.composables.OnboardingScreen
import kotlinx.coroutines.delay

const val startDestination = AppNavRoutes.onboarding

@Composable
fun NavGraph(navController: NavHostController) {
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
					animationSpec = tween(500)
				)
			},
			exitTransition = {
				slideOutOfContainer(
					AnimatedContentTransitionScope.SlideDirection.Down,
					animationSpec = tween(500)
				)
			}
		) {
			OnboardingScreen(
				onButtonClicked = {
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
					animationSpec = tween(500)
				)
			},
			exitTransition = {
				slideOutOfContainer(
					AnimatedContentTransitionScope.SlideDirection.Right,
					animationSpec = tween(500)
				)
			}
		) {
			HomeScreen()
		}
	}
}