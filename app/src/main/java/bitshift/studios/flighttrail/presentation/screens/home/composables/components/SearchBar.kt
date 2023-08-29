package bitshift.studios.flighttrail.presentation.screens.home.composables.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import bitshift.studios.flighttrail.R
import bitshift.studios.flighttrail.presentation.ui.theme.Main080
import bitshift.studios.flighttrail.presentation.ui.theme.Main100
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral200
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral300
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral500
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral600
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral700

private data class SearchBarColors(
	val container: Color,
	val border: Color,
	val text: Color,
	val highlighted: Color,
	val placeholder: Color
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
	modifier: Modifier = Modifier,
	searchValue: String,
	onSearchValueChange: (String) -> Unit,
	onDoneClicked: () -> Unit,
	onCloseClicked: () -> Unit,
	isDarkTheme: Boolean
) {
	val colors = when (isDarkTheme) {
		true -> SearchBarColors(
			container = Neutral600,
			border = Neutral500,
			text = Neutral200,
			highlighted = Main080,
			placeholder = Neutral200
		)

		false -> SearchBarColors(
			container = Neutral200,
			border = Neutral300,
			text = Neutral700,
			highlighted = Main100,
			placeholder = Neutral500
		)
	}

	val typography = MaterialTheme.typography

	OutlinedTextField(
		value = searchValue,
		onValueChange = onSearchValueChange,
		singleLine = true,
		maxLines = 1,
		leadingIcon = {
			Icon(
				painter = painterResource(id = R.drawable.icon_search),
				contentDescription = "search",
				tint = colors.highlighted,
				modifier = Modifier.size(24.dp)
			)
		},
		trailingIcon = {
			if (searchValue.isNotEmpty()) {
				Icon(
					painter = painterResource(id = R.drawable.icon_clear),
					contentDescription = "clear",
					tint = colors.text.copy(alpha = 0.5f),
					modifier = Modifier
						.size(18.dp)
						.clickable { onCloseClicked() }
				)
			}
		},
		placeholder = {
			Text(
				text = stringResource(id = R.string.search_flights),
				style = typography.bodySmall,
				color = colors.placeholder
			)
		},
		textStyle = typography.bodySmall,
		colors = TextFieldDefaults.outlinedTextFieldColors(
			containerColor = colors.container,
			unfocusedBorderColor = colors.container,
			focusedBorderColor = colors.container,
			textColor = colors.text
		),
		shape = RoundedCornerShape(16.dp),
		keyboardActions = KeyboardActions(
			onDone = { onDoneClicked() }
		),
		modifier = modifier
			.width(280.dp)
			.height(52.dp)
			.padding(start = 16.dp)
	)
}