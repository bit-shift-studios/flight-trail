package bitshift.studios.flighttrail.presentation.screens.home.composables.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import bitshift.studios.flighttrail.R
import bitshift.studios.flighttrail.presentation.ui.core.ExternalLink
import bitshift.studios.flighttrail.presentation.ui.core.ExternalLinkIconButton
import bitshift.studios.flighttrail.presentation.ui.theme.Main080
import bitshift.studios.flighttrail.presentation.ui.theme.Main100
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral100
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral200
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral400
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral600
import bitshift.studios.flighttrail.presentation.ui.theme.Neutral700

private data class ModalColors(
	val background: Color,
	val border: Color,
	val text: Color,
	val highlight: Color
)

private data class Link(
	val icon: Int,
	val text: String,
	val hyperlink: String
)

private val links = listOf(
	Link(
		icon = R.drawable.icon_code,
		text = "Source Code",
		hyperlink = "https://github.com/bit-shift-studios/flight-trail"
	),
	Link(
		icon = R.drawable.icon_bug_report,
		text = "Report a bug",
		hyperlink = "https://github.com/bit-shift-studios/flight-trail/issues"
	)
)

@Composable
fun HelpModal(
	modifier: Modifier = Modifier,
	onOverlayClicked: () -> Unit,
	isDarkTheme: Boolean
) {
	val interactionSource = MutableInteractionSource()
	var shouldAnimateScale by remember { mutableStateOf(false) }

	val scale by animateFloatAsState(
		targetValue = if (shouldAnimateScale) 1f else 0.97f,
		animationSpec = tween(
			durationMillis = 50,
			easing = FastOutSlowInEasing
		),
		label = "scale anim"
	)

	val colors = when (isDarkTheme) {
		true -> ModalColors(
			background = Color(0xFF12141A),
			border = Neutral600,
			text = Neutral200,
			highlight = Main080
		)

		false ->	ModalColors(
			background = Neutral100,
			border = Neutral200,
			text = Neutral400,
			highlight = Main100
		)
	}

	LaunchedEffect(Unit) {
		shouldAnimateScale = true
	}

	Column(
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center,
		modifier = modifier
			.fillMaxSize()
			.background(Neutral700.copy(alpha = 0.8f))
			.clickable { onOverlayClicked() }
	) {
		InfoModal(
			border = colors.border,
			background = colors.background,
			text = colors.text,
			highlight = colors.highlight,
			isDarkTheme = isDarkTheme,
			modifier = Modifier
				.scale(scale)
				.clickable(
					indication = null,
					interactionSource = interactionSource,
					onClick = {}
				)
		)
	}
}

@Composable
fun InfoModal(
	modifier: Modifier = Modifier,
	border: Color,
	background: Color,
	text: Color,
	highlight: Color,
	isDarkTheme: Boolean
) {
	val typography = MaterialTheme.typography

	LazyColumn(
		modifier = modifier
			.padding(vertical = 16.dp)
			.clip(RoundedCornerShape(32.dp))
			.background(
				color = background,
				shape = RoundedCornerShape(32.dp)
			)
			.border(
				width = 2.dp,
				shape = RoundedCornerShape(32.dp),
				color = border
			)
			.widthIn(
				min = 290.dp,
				max = 320.dp
			)
	) {
		item {
			Column(
				verticalArrangement = Arrangement.spacedBy(24.dp),
				modifier = Modifier.padding(20.dp)
			) {
				val appIconResID = if (isDarkTheme) R.drawable.app_icon_light else R.drawable.app_icon_dark
				val textString = buildAnnotatedString {
					withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
						append("FLIGHT")
					}

					withStyle(SpanStyle(fontWeight = FontWeight.Normal)) {
						append(" Trail")
					}
				}

				Row(
					horizontalArrangement = Arrangement.spacedBy(16.dp)
				) {
					Image(
						painter = painterResource(id = appIconResID),
						contentDescription = null,
						modifier = Modifier.size(48.dp)
					)

					Column(
						verticalArrangement = Arrangement.spacedBy(2.dp)
					) {
						Text(
							text = textString,
							style = typography.displayMedium,
							color = text
						)

						Text(
							text = stringResource(id = R.string.app_version),
							style = typography.displaySmall,
							color = highlight
						)
					}
				}

				Row {
					Text(
						text = stringResource(id = R.string.app_info),
						style = typography.bodySmall,
						color = text
					)
				}

				Column(
					verticalArrangement = Arrangement.spacedBy(16.dp)
				) {
					links.forEach { item ->
						ExternalLink(
							isDarkTheme = isDarkTheme,
							hyperlink = item.hyperlink,
							iconID = item.icon,
							text = item.text
						)
					}
				}

				ExternalLinkIconButton(
					isDarkTheme = isDarkTheme,
					hyperlink = "https://twitter.com/xero_dev",
					iconID = R.drawable.icon_brand_twitter,
					text = "Follow the Developer"
				)
			}
		}
	}
}