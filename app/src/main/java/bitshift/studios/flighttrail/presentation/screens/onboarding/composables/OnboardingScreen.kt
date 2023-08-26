package bitshift.studios.flighttrail.presentation.screens.onboarding.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import bitshift.studios.flighttrail.R
import bitshift.studios.flighttrail.presentation.ui.core.FilledButton
import bitshift.studios.flighttrail.presentation.ui.theme.Main080
import bitshift.studios.flighttrail.presentation.ui.theme.Main100
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral100
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral700

private data class OnBoardingScreenColors(
	val displayMedium: Color,
	val displayLarge: Color
)

@Composable
fun OnboardingScreen(
	modifier: Modifier = Modifier,
	onButtonClicked: () -> Unit
) {
	val isDarkTheme = isSystemInDarkTheme()
	val typography = MaterialTheme.typography
	val appIconResID = if (isDarkTheme) R.drawable.app_icon_light else R.drawable.app_icon_dark

	val onBoardingScreenColors = when (isDarkTheme) {
		true -> OnBoardingScreenColors(
			displayMedium = Neutral100,
			displayLarge = Main080
		)

		false -> OnBoardingScreenColors(
			displayMedium = Neutral700,
			displayLarge = Main100
		)
	}

	val headlineText = buildAnnotatedString {
		val text = stringResource(id = R.string.effortlessly)

		withStyle(style = SpanStyle(color = Main100)) {
			append(text)
		}

		withStyle(style = SpanStyle(color = onBoardingScreenColors.displayMedium)) {
			append(".")
		}
	}

	Column(
		verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.Bottom),
		modifier = modifier
			.fillMaxSize()
			.padding(
				start = 16.dp,
				end = 16.dp,
				bottom = 16.dp
			)
	) {
		Image(
			painter = painterResource(appIconResID),
			contentDescription = null,
			modifier = Modifier.size(48.dp)
		)
		
		Column(
			verticalArrangement = Arrangement.spacedBy(4.dp),
			modifier = Modifier.padding(bottom = 4.dp)
		) {
			Text(
				text = stringResource(id = R.string.track_and_book_flights),
				style = typography.displayMedium,
				color = onBoardingScreenColors.displayMedium
			)

			Text(
				text = headlineText,
				style = typography.displayLarge,
				color = onBoardingScreenColors.displayLarge
			)
		}

		FilledButton(
			text = stringResource(id = R.string.get_started),
			onButtonClicked = onButtonClicked,
			isDarkTheme = isDarkTheme
		)
	}
}