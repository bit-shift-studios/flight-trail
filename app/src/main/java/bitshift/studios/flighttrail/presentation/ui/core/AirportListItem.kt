package bitshift.studios.flighttrail.presentation.ui.core

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import bitshift.studios.flighttrail.data.db.airport.entities.AirportEntity
import bitshift.studios.flighttrail.presentation.ui.theme.Main080
import bitshift.studios.flighttrail.presentation.ui.theme.Main100
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral100
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral400
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral500
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral600

private data class CodeTagColors(
	val container: Color,
	val text: Color
)

@Composable
fun AirportListItem(
	modifier: Modifier = Modifier,
	airport: AirportEntity,
	isDarkTheme: Boolean
) {
	val textColor = if (isDarkTheme) Neutral400 else Neutral600

	Row(modifier = modifier.fillMaxWidth()) {
		Row(
			horizontalArrangement = Arrangement.spacedBy(16.dp),
			modifier = Modifier
				.fillMaxWidth()
				.padding(16.dp)
		) {
			CodeTag(code = airport.iataCode, isDarkTheme = isDarkTheme)
			Text(
				text = airport.name,
				style = MaterialTheme.typography.bodyMedium,
				color = textColor,
				overflow = TextOverflow.Ellipsis
			)
		}
	}
}

@Composable
private fun CodeTag(
	modifier: Modifier = Modifier,
	code: String,
	isDarkTheme: Boolean
) {
	val colors = when (isDarkTheme) {
		true -> CodeTagColors(
			container = Neutral500,
			text = Neutral100
		)

		false -> CodeTagColors(
			container = Main080,
			text = Main100
		)
	}

	Text(
		text = code,
		style = MaterialTheme.typography.labelMedium,
		color = colors.text,
		modifier = modifier
			.padding(8.dp)
			.background(color = colors.container)
	)
}