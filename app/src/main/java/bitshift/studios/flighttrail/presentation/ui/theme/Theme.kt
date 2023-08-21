package bitshift.studios.flighttrail.presentation.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val darkColorScheme = darkColorScheme(
	primary = Main090,
	background = Neutral900,
	onBackground = Neutral500,
	surface = Neutral800,
	onSurface = Neutral400
)

private val lightColorScheme = lightColorScheme(
	primary = Main100,
	background = Neutral400,
	onBackground = Neutral800,
	surface = Neutral500,
	onSurface = Neutral900
)

@Composable
fun FlightTrailTheme(
	darkTheme: Boolean = isSystemInDarkTheme(),
	dynamicColor: Boolean = true,  // Dynamic color is available on Android 12+
	content: @Composable () -> Unit
) {
	val isAndroid12Plus = dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
	val statusBarColor = if (darkTheme) Neutral900 else Neutral400

	val colorScheme = when {
		 isAndroid12Plus -> {
			val context = LocalContext.current
			if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
		}

		darkTheme -> darkColorScheme
		else -> lightColorScheme
	}
	val view = LocalView.current
	if (!view.isInEditMode) {
		SideEffect {
			val window = (view.context as Activity).window
			window.statusBarColor = statusBarColor.toArgb()
			WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
		}
	}

	MaterialTheme(
		colorScheme = colorScheme,
		typography = Typography,
		content = content
	)
}