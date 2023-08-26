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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import bitshift.studios.flighttrail.R
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral100
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral600

@Composable
fun AppBar(
	modifier: Modifier = Modifier,
	width: Dp,
	searchValue: String,
	onSearchValueChange: (String) -> Unit,
	onButtonClicked: () -> Unit,
	onHelpButtonClicked: () -> Unit,
	onCloseClicked: () -> Unit,
	showIconButton: Boolean,
	showSearchBar: Boolean,
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
			onButtonClicked = onButtonClicked,
			onCloseClicked = onCloseClicked,
			showIconButton = showIconButton,
			showSearchBar = showSearchBar,
			isDarkTheme = isDarkTheme
		)

		IconButton(onClick = onHelpButtonClicked) {
			Icon(
				painter = painterResource(id = R.drawable.icon_help),
				contentDescription = "help",
				tint = if (isDarkTheme) Neutral100 else Neutral600,
				modifier = modifier.size(30.dp)
			)
		}
	}
}