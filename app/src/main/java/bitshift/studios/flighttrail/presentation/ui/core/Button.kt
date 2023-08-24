package bitshift.studios.flighttrail.presentation.ui.core

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral400
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral900

data class Colors (
	val base: Color,
	val text: Color
)

@Composable
fun FilledButton(
	modifier: Modifier = Modifier,
	text: String,
	onButtonClicked: () -> Unit,
	isDarkTheme: Boolean
) {
	val typography = MaterialTheme.typography
	val colors = Colors(
		base = if (isDarkTheme) Neutral400 else Neutral900,
		text = if (isDarkTheme) Neutral900 else Neutral400
	)

	Button(
		onClick = onButtonClicked,
		contentPadding = PaddingValues(vertical = 16.dp),
		shape = RoundedCornerShape(16.dp),
		colors = ButtonDefaults.buttonColors(
			containerColor = colors.base,
			contentColor = colors.text
		),
		modifier = modifier
			.sizeIn(minWidth = 398.dp)
			.fillMaxWidth()
	) {
		Text(
			text = text,
			style = typography.titleMedium,
			color = colors.text
		)
	}
}