package bitshift.studios.flighttrail.application.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import bitshift.studios.flighttrail.application.navigation.routes.AppNavRoutes
import bitshift.studios.flighttrail.presentation.screens.onboarding.composables.OnboardingScreen

const val startDestination = AppNavRoutes.onboarding

@Composable
fun NavGraph(navController: NavHostController) {
	NavHost(navController = navController, startDestination = startDestination) {
		composable(
			route = AppNavRoutes.onboarding,
			enterTransition = {
				slideIntoContainer(
					AnimatedContentTransitionScope.SlideDirection.Up,
					animationSpec = tween(700)
				)
			},
			exitTransition = {
				slideOutOfContainer(
					AnimatedContentTransitionScope.SlideDirection.Down,
					animationSpec = tween(700)
				)
			}
		) {
			OnboardingScreen()
		}
	}
}