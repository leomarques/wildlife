package lmm.wildlife.ui.animals

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import lmm.domain.model.Animal

@Composable
fun AnimalItem(animal: Animal) {
    Column(
        Modifier
            .background(MaterialTheme.colorScheme.background)
    ) {
        Row {
            PropertyCell(animal.name)
            PropertyCell(animal.tier)
            PropertyCell(animal.weapon)
            PropertyCell(animal.trapper.toString())
            PropertyCell(animal.camp.toString())
            PropertyCell(animal.appelation)
            PropertyCell(animal.bodyType)
        }
    }
}

@Preview
@Composable
fun AnimalItemPreview() {
    AnimalItem(
        animal = Animal(
            name = "Cachorro",
            appelation = "Tatanka",
            tier = "Legendary",
            bodyType = "Massive",
            weapon = "Sniper Rifle",
            trapper = 1,
            camp = 0,
            total = 1,
            have = 0,
            need = 1
        )
    )
}
