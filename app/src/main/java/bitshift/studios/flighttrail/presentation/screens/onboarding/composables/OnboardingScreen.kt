package bitshift.studios.flighttrail.presentation.screens.onboarding.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral400

@Composable
fun OnboardingScreen(
	modifier: Modifier = Modifier
) {
	Column(
		modifier = modifier
			.fillMaxSize()
	) {
		Text(
			text = "Onboarding Screen Base",
			color = Neutral400
		)
	}
}