package bitshift.studios.flighttrail.presentation.screens.home.composables.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import bitshift.studios.flighttrail.R
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral100
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral700

@Composable
fun AppBar(
	modifier: Modifier = Modifier,
	width: Float,
	searchValue: String,
	onSearchValueChange: (String) -> Unit,
	onSearchBarClicked: () -> Unit,
	onInfoClicked: () -> Unit,
	onDoneClicked: () -> Unit,
	onCloseClicked: () -> Unit,
	isDarkTheme: Boolean
) {
	Row(
		horizontalArrangement = Arrangement.SpaceBetween,
		verticalAlignment = Alignment.CenterVertically,
		modifier = modifier.fillMaxWidth()
	) {
		SearchBar(
			width = width,
			searchValue = searchValue,
			onSearchValueChange = onSearchValueChange,
			onSearchBarClicked = onSearchBarClicked,
			onDoneClicked = onDoneClicked,
			onCloseClicked = onCloseClicked,
			isDarkTheme = isDarkTheme
		)

		IconButton(onClick = onInfoClicked) {
			Icon(
				painter = painterResource(id = R.drawable.icon_help),
				contentDescription = "help",
				tint = if (isDarkTheme) Neutral100 else Neutral700,
				modifier = modifier.size(32.dp)
			)
		}
	}
}