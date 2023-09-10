package lmm.wildlife.ui.animals.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import lmm.wildlife.ui.theme.SpaceSize

@Composable
fun PropertyCell(
    text: String,
    textColor: Color = MaterialTheme.colorScheme.onSurface,
    textBoxColor: Color? = null
) {
    Box(
        modifier = Modifier
            .requiredWidth(SpaceSize.CellSpaceSize)
            .background(MaterialTheme.colorScheme.surface)
            .border(
                width = Dp.Hairline,
                color = DividerDefaults.color
            ),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .padding(SpaceSize.SmallSpaceSize)
                .clip(shape = RoundedCornerShape(10.dp))
                .border(
                    width = Dp.Hairline,
                    color = textBoxColor ?: MaterialTheme.colorScheme.surface,
                    shape = RoundedCornerShape(10.dp)
                )
                .background(textBoxColor ?: MaterialTheme.colorScheme.surface)
        ) {
            Text(
                modifier = Modifier
                    .padding(
                        vertical = SpaceSize.XSmallSpaceSize,
                        horizontal = SpaceSize.SmallSpaceSize
                    ),
                text = text,
                maxLines = 1,
                color = textColor
            )
        }
    }
}

@Preview
@Composable
fun PropertyCellPreview() {
    PropertyCell(text = "Exceptionally long")
}
