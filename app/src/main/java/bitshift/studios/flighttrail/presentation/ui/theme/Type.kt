package bitshift.studios.flighttrail.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import bitshift.studios.flighttrail.R

val AvenirLT = FontFamily(
	Font(
		resId = R.font.avenir_black,
		weight = FontWeight.Black,
		style = FontStyle.Normal
	),
	Font(
		resId = R.font.avenir_xbold,
		weight = FontWeight.ExtraBold,
		style = FontStyle.Normal
	),
	Font(
		resId = R.font.avenir_normal,
		weight = FontWeight.Normal,
		style = FontStyle.Normal
	)
)

val Inter = FontFamily(
	Font(
		resId = R.font.inter_bold,
		weight = FontWeight.Bold,
		style = FontStyle.Normal
	),
	Font(
		resId = R.font.inter_medium,
		weight = FontWeight.Medium,
		style = FontStyle.Normal
	),
	Font(
		resId = R.font.inter_normal,
		weight = FontWeight.Normal,
		style = FontStyle.Normal
	)
)

val Typography = Typography(
	displayLarge = TextStyle(
		fontFamily = AvenirLT,
		fontWeight = FontWeight.Black,
		fontSize = 44.sp,
		lineHeight = 58.sp
	),
	displayMedium = TextStyle(
		fontFamily = AvenirLT,
		fontWeight = FontWeight.ExtraBold,
		fontSize = 22.sp,
		lineHeight = 34.sp
	),
	displaySmall = TextStyle(
		fontFamily = AvenirLT,
		fontWeight = FontWeight.ExtraBold,
		fontSize = 16.sp,
		lineHeight = 24.sp
	),
	headlineMedium = TextStyle(
		fontFamily = AvenirLT,
		fontWeight = FontWeight.ExtraBold,
		fontSize = 18.sp,
		lineHeight = 30.sp
	),
	headlineLarge = TextStyle(
		fontFamily = AvenirLT,
		fontWeight = FontWeight.ExtraBold,
		fontSize = 40.sp,
		lineHeight = 52.sp
	),
	titleMedium = TextStyle(
		fontFamily = Inter,
		fontWeight = FontWeight.Bold,
		fontSize = 18.sp,
		lineHeight = 30.sp
	),
	bodyLarge = TextStyle(
		fontFamily = Inter,
		fontWeight = FontWeight.Medium,
		fontSize = 24.sp,
		lineHeight = 36.sp
	),
	bodyMedium = TextStyle(
		fontFamily = Inter,
		fontWeight = FontWeight.Medium,
		fontSize = 18.sp,
		lineHeight = 30.sp
	),
	bodySmall = TextStyle(
		fontFamily = Inter,
		fontWeight = FontWeight.Medium,
		fontSize = 14.sp,
		lineHeight = 28.sp
	),
	labelMedium = TextStyle(
		fontFamily = AvenirLT,
		fontWeight = FontWeight.Black,
		fontSize = 18.sp,
		lineHeight = 30.sp
	),
	labelSmall = TextStyle(
		fontFamily = AvenirLT,
		fontWeight = FontWeight.ExtraBold,
		fontSize = 16.sp,
		lineHeight = 28.sp
	)
)