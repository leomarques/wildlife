package lmm.wildlife.ui.animals

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import lmm.wildlife.ui.theme.SpaceSize

@Composable
fun PropertyCell(
    text: String,
    color: Color = MaterialTheme.colorScheme.onSurface
) {
    Box(
        modifier = Modifier
            .requiredWidth(SpaceSize.CellSpaceSize)
            .background(MaterialTheme.colorScheme.surface)
            .border(
                BorderStroke(
                    width = Dp.Hairline,
                    color = DividerDefaults.color
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.padding(vertical = SpaceSize.SmallSpaceSize),
            text = text,
            maxLines = 1,
            color = color
        )
    }
}

@Preview
@Composable
fun PropertyCellPreview() {
    PropertyCell(text = "Cell")
}
