package lmm.wildlife.ui.animals.components

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import lmm.wildlife.R

@Composable
fun Header() {
    Row {
        PropertyHeader(stringResource(R.string.name))
        PropertyHeader(stringResource(R.string.tier))
        PropertyHeader(stringResource(R.string.body_type))
        PropertyHeader(stringResource(R.string.weapon))
        PropertyHeader(stringResource(R.string.trapper))
        PropertyHeader(stringResource(R.string.camp))
        PropertyHeader(stringResource(R.string.appelation))
    }
}

@Composable
private fun PropertyHeader(text: String) {
    PropertyCell(
        text = text,
        textColor = Color.Gray
    )
}
