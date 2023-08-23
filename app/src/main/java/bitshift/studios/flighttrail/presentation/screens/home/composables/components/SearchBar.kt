package bitshift.studios.flighttrail.presentation.screens.home.composables.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import bitshift.studios.flighttrail.R
import bitshift.studios.flighttrail.presentation.ui.theme.Main080
import bitshift.studios.flighttrail.presentation.ui.theme.Main100
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral500
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral700
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral800
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral900

private data class SearchBarColors(
	val container: Color,
	val text: Color,
	val highlighted: Color,
	val placeholder: Color
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
	modifier: Modifier = Modifier,
	width: Dp,
	searchValue: String,
	onSearchValueChange: (String) -> Unit,
	onButtonClicked: () -> Unit,
	onCloseClicked: () -> Unit,
	showIconButton: Boolean,
	showSearchBar: Boolean,
	isDarkTheme: Boolean
) {
	val searchBarColors = SearchBarColors(
		container = if (isDarkTheme) Neutral800 else Neutral500,
		text = if (isDarkTheme) Neutral500 else Neutral900,
		highlighted = if (isDarkTheme) Main080 else Main100,
		placeholder = if (isDarkTheme) Neutral500 else Neutral700
	)

	val typography = MaterialTheme.typography

	Box {
		if(showIconButton) {
			IconButton(onClick = onButtonClicked) {
				Icon(
					painter = painterResource(id = R.drawable.icon_search),
					contentDescription = null,
					tint = searchBarColors.text,
					modifier = modifier.size(24.dp)
				)
			}
		}

		if (showSearchBar) {
			OutlinedTextField(
				value = searchValue,
				onValueChange = onSearchValueChange,
				singleLine = true,
				maxLines = 1,
				leadingIcon = {
					Icon(
						painter = painterResource(id = R.drawable.icon_search),
						contentDescription = "search",
						tint = searchBarColors.highlighted,
						modifier = Modifier.size(24.dp)
					)
				},
				trailingIcon = {
					if (searchValue.isEmpty()) {
						Icon(
							painter = painterResource(id = R.drawable.icon_clear),
							contentDescription = "clear",
							tint = searchBarColors.text.copy(alpha = 0.6f),
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
						color = searchBarColors.placeholder
					)
				},
				colors = TextFieldDefaults.outlinedTextFieldColors(
					containerColor = searchBarColors.container,
					unfocusedBorderColor = searchBarColors.container,
					focusedBorderColor = searchBarColors.container,
					textColor = searchBarColors.text
				),
				shape = RoundedCornerShape(16.dp),
				modifier = Modifier
					.width(width)
					.height(52.dp)
					.padding(start = 16.dp)
			)
		}
		
		if (!showSearchBar) {
			Spacer(modifier = Modifier.height(52.dp))
		}
	}
}