package bitshift.studios.flighttrail.presentation.ui.core

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import bitshift.studios.flighttrail.data.db.airport.entities.AirportEntity
import bitshift.studios.flighttrail.presentation.ui.theme.Main070
import bitshift.studios.flighttrail.presentation.ui.theme.Main100
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral100
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral300
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
	searchQuery: String,
	isDarkTheme: Boolean
) {
	val textColor = if (isDarkTheme) Neutral300 else Neutral500
	val highlightColor = if (isDarkTheme) Neutral100 else Neutral400

	Row(modifier = modifier.fillMaxWidth()) {
		Row(
			horizontalArrangement = Arrangement.spacedBy(16.dp),
			verticalAlignment = Alignment.CenterVertically,
			modifier = Modifier
				.fillMaxWidth()
		) {
			val fullName = airport.name.lowercase()
			val query = searchQuery.lowercase()

			val airportName = buildAnnotatedString {
				val startIndex = fullName.indexOf(query)
				val endIndex = startIndex + query.length

				append(airport.name)

				if (startIndex != -1) {
					addStyle(
						style = SpanStyle(color = highlightColor),
						start = startIndex,
						end = endIndex
					)
				}
			}

			CodeTag(code = airport.iataCode, isDarkTheme = isDarkTheme)
			Text(
				text = airportName,
				style = MaterialTheme.typography.bodyMedium,
				color = textColor,
				overflow = TextOverflow.Ellipsis,
				maxLines = 1
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
			container = Neutral600,
			text = Neutral100
		)

		false -> CodeTagColors(
			container = Main070,
			text = Main100
		)
	}

	Box(
		modifier = modifier
			.background(
				color = colors.container,
				shape = RoundedCornerShape(8.dp)
			)
			.widthIn(min = 48.dp),
		contentAlignment = Alignment.Center
	) {
		Text(
			text = code,
			style = MaterialTheme.typography.labelMedium,
			color = colors.text,
			fontSize = 14.sp,
			modifier = modifier
				.padding(vertical = 8.dp)
		)
	}
}