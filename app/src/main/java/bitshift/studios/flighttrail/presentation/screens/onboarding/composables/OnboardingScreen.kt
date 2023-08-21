package bitshift.studios.flighttrail.presentation.screens.onboarding.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun OnboardingScreen(
	modifier: Modifier = Modifier
) {
	Column(
		modifier = modifier
			.fillMaxSize()
	) {
		Text("Onboarding Screen Base")
	}
}