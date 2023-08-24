package bitshift.studios.flighttrail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import bitshift.studios.flighttrail.application.navigation.NavGraph
import bitshift.studios.flighttrail.presentation.ui.theme.FlightTrailTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	lateinit var mainViewModel: MainViewModel

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

		installSplashScreen().setKeepOnScreenCondition {
			mainViewModel.isLoading.value
		}

		setContent {
			FlightTrailTheme {
				val navController = rememberNavController()
				NavGraph(
					navController = navController,
					startDestination = mainViewModel.startDestination.value
				)
			}
		}
	}
}