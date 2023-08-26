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
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral100
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral600

private data class ButtonColors (
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
	val buttonColors = ButtonColors(
		base = if (isDarkTheme) Neutral100 else Neutral600,
		text = if (isDarkTheme) Neutral600 else Neutral100
	)

	Button(
		onClick = onButtonClicked,
		contentPadding = PaddingValues(vertical = 16.dp),
		shape = RoundedCornerShape(16.dp),
		colors = ButtonDefaults.buttonColors(
			containerColor = buttonColors.base,
			contentColor = buttonColors.text
		),
		modifier = modifier
			.sizeIn(minWidth = 398.dp)
			.fillMaxWidth()
	) {
		Text(
			text = text,
			style = typography.titleMedium,
			color = buttonColors.text
		)
	}
}