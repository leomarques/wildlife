package lmm.wildlife.ui.animals.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import lmm.domain.model.Animal
import lmm.wildlife.R
import lmm.wildlife.ui.theme.SpaceSize

@Composable
fun AnimalItem(animal: Animal) {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surface)
            .fillMaxWidth()
            .height(SpaceSize.ListItemHeight)
            .padding(
                vertical = SpaceSize.SmallSpaceSize,
                horizontal = SpaceSize.DefaultSpaceSize
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Row {
                Text(
                    text = "${animal.name} ",
                    style = MaterialTheme.typography.bodyLarge
                )

                Text(
                    text = "(${animal.tier}) ",
                    style = MaterialTheme.typography.bodyLarge,
                    fontStyle = FontStyle.Italic,
                    color = animal.tier.getTierColor() ?: MaterialTheme.colorScheme.onSurface
                )

                if (animal.appelation.isNotBlank()) {
                    Text(
                        text = "(${animal.appelation})",
                        style = MaterialTheme.typography.bodyLarge,
                        fontStyle = FontStyle.Italic,
                        color = animal.appelation.getAppelationColor()
                            ?: MaterialTheme.colorScheme.onSurface
                    )
                }
            }
            Text(
                text = animal.weapon.ifBlank { stringResource(R.string.any_weapon) },
                style = MaterialTheme.typography.bodyMedium,
                color = animal.weapon.getWeaponColor()
            )
        }
        Text("${animal.camp}:${animal.trapper}", color = Color.Gray)
    }

    Divider(thickness = SpaceSize.XXSmallSpaceSize)
}

@Preview
@Composable
fun AnimalItemPreview() {
    AnimalItem(
        animal = Animal(
            name = "Bison",
            appelation = "Tatanka",
            tier = "Skin",
            bodyType = "Massive",
            weapon = "Sniper Rifle",
            trapper = 1,
            camp = 0
        )
    )
}
