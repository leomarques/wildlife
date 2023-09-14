package lmm.wildlife.ui.animals.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import lmm.wildlife.ui.theme.DarkBlue
import lmm.wildlife.ui.theme.DarkRed

@Composable
fun VendorsCount(first: String, second: String, third: String) {
    Text(
        text =
        buildAnnotatedString {
            withStyle(style = SpanStyle(color = DarkBlue)) {
                append(first)
            }
            withStyle(style = SpanStyle(color = Color.Gray)) {
                append(second)
            }
            withStyle(style = SpanStyle(color = DarkRed)) {
                append(third)
            }
        }
    )
}
