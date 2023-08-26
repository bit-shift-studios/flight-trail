package bitshift.studios.flighttrail.presentation.ui.core

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import bitshift.studios.flighttrail.R
import bitshift.studios.flighttrail.presentation.ui.theme.Main080
import bitshift.studios.flighttrail.presentation.ui.theme.Main100
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral100
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral200
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral400
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral600

private data class ExternalLinkColors(
	val icon: Color,
	val text: Color,
	val link: Color
)

private data class ExternalLinkButtonColors(
	val icon: Color,
	val text: Color,
	val base: Color
)

@Composable
fun ExternalLink(
	modifier: Modifier = Modifier,
	isDarkTheme: Boolean,
	hyperlink: String,
	iconID: Int,
	text: String
) {
	val openLink = rememberLauncherForActivityResult(
		contract = ActivityResultContracts.StartActivityForResult(),
	) { _ -> }

	val interactionSource = MutableInteractionSource()

	val colors = when (isDarkTheme) {
		true -> ExternalLinkColors(
			icon = Main080,
			text = Neutral200,
			link = Neutral200
		)

		false -> ExternalLinkColors(
			icon = Main100,
			text = Neutral400,
			link = Neutral400
		)
	}

	Row(
		horizontalArrangement = Arrangement.SpaceBetween,
		modifier = modifier
			.fillMaxWidth()
			.clickable(
				indication = null,
				interactionSource = interactionSource,
				onClick = {
					val intent = Intent(Intent.ACTION_VIEW, Uri.parse(hyperlink))
					openLink.launch(intent)
				}
			)
	) {
		Row(
			horizontalArrangement = Arrangement.spacedBy(16.dp)
		) {
			Icon(
				painter = painterResource(id = iconID),
				contentDescription = text,
				tint = colors.icon
			)

			Text(
				text = text,
				style = MaterialTheme.typography.bodySmall,
				textDecoration = TextDecoration.Underline,
				color = colors.text
			)
		}

		Icon(
			painter = painterResource(id = R.drawable.icon_external_link),
			contentDescription = "external",
			tint = colors.link
		)
	}
}

@Composable
fun ExternalLinkIconButton(
	modifier: Modifier = Modifier,
	isDarkTheme: Boolean,
	hyperlink: String,
	iconID: Int,
	text: String
) {
	val openLink = rememberLauncherForActivityResult(
		contract = ActivityResultContracts.StartActivityForResult(),
	) { _ -> }

	val colors = when(isDarkTheme) {
		true -> ExternalLinkButtonColors(
			icon = Main100,
			text = Neutral600,
			base = Neutral100
		)

		false -> ExternalLinkButtonColors(
			icon = Main080,
			text = Neutral100,
			base = Neutral600
		)
	}

	Button(
		onClick = {
			val intent = Intent(Intent.ACTION_VIEW, Uri.parse(hyperlink))
			openLink.launch(intent)
		},
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
		Row(
			horizontalArrangement = Arrangement.spacedBy(12.dp),
			verticalAlignment = Alignment.CenterVertically
		) {
			Icon(
				painter = painterResource(id = iconID),
				contentDescription = text,
				tint = colors.icon
			)
			
			Text(
				text = text,
				style = MaterialTheme.typography.bodyMedium,
				color = colors.text
			)
		}
	}
}