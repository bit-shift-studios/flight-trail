package bitshift.studios.flighttrail.presentation.screens.home.composables.display

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import bitshift.studios.flighttrail.R
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral100
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral200
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral500
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral700

private data class AirportMatchesDisplayColors(
	val text: Color,
	val secondaryText: Color
)

@Composable
fun AirportMatchesDisplay(
	modifier: Modifier = Modifier,
	isDarkTheme: Boolean,
	padding: PaddingValues
) {
	val typography = MaterialTheme.typography

	val colors = when(isDarkTheme) {
		true -> AirportMatchesDisplayColors(
			text = Neutral100,
			secondaryText = Neutral200.copy(alpha = 0.8f)
		)

		false -> AirportMatchesDisplayColors(
			text = Neutral500,
			secondaryText = Neutral700.copy(alpha = 0.8f)
		)
	}

	LazyColumn(
		modifier = modifier
			.fillMaxSize()
			.padding(padding)
			.padding(16.dp)
	) {
		item {
			Row(
				modifier = Modifier.fillMaxWidth()
			) {
				Column {
					Text(
						text = stringResource(id = R.string.airport),
						style = typography.bodySmall,
						color = colors.secondaryText
					)

					Text(
						text = stringResource(id = R.string.matches),
						style = typography.bodyLarge,
						color = colors.text
					)
				}
			}
		}
	}
}