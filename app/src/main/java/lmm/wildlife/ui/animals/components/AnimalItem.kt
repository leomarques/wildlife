package lmm.wildlife.ui.animals.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import lmm.domain.model.Animal
import lmm.wildlife.ui.theme.DarkBlue
import lmm.wildlife.ui.theme.DarkGreen
import lmm.wildlife.ui.theme.DarkOrange
import lmm.wildlife.ui.theme.DarkPurple
import lmm.wildlife.ui.theme.DarkRed
import lmm.wildlife.ui.theme.DarkYellow

@Composable
fun AnimalItem(animal: Animal) {
    Column(
        Modifier
            .background(MaterialTheme.colorScheme.background)
    ) {
        Row {
            PropertyCell(animal.name)
            PropertyCell(
                text = animal.tier,
                textColor = Color.White,
                textBoxColor = getTierColor(animal.tier)
            )
            PropertyCell(
                animal.bodyType,
                textColor = Color.White,
                textBoxColor = getBodyTypeColor(animal.bodyType)
            )
            PropertyCell(
                text = animal.weapon,
                textColor = Color.White,
                textBoxColor = getWeaponColor(animal.weapon)
            )
            PropertyCell(animal.trapper.toString())
            PropertyCell(animal.camp.toString())
            PropertyCell(
                animal.appelation,
                textColor = Color.White,
                textBoxColor = getAppelationColor(animal.appelation)
            )
        }
    }
}

fun getTierColor(tier: String): Color? {
    return when (tier) {
        "Legendary" -> DarkOrange
        "Perfect" -> DarkGreen
        "Feather" -> DarkBlue
        "Antler" -> DarkPurple
        "Carcass" -> DarkYellow
        else -> null
    }
}

fun getWeaponColor(weapon: String): Color? {
    return when (weapon) {
        "Sniper Rifle" -> DarkPurple
        "Regular Rifle" -> DarkGreen
        "Varmint Rifle" -> DarkBlue
        "Repeater" -> DarkRed
        "Game Arrow" -> DarkOrange
        else -> null
    }
}

fun getAppelationColor(appelation: String): Color? {
    return when (appelation) {
        "Black" -> DarkRed
        "Tatanka" -> DarkGreen
        "White" -> DarkBlue
        "Collared" -> DarkPurple
        else -> null
    }
}

fun getBodyTypeColor(bodyType: String): Color? {
    return when (bodyType) {
        "Massive" -> DarkRed
        "Large" -> DarkOrange
        "Moderate" -> DarkPurple
        "Medium" -> DarkBlue
        "Small" -> DarkGreen
        else -> null
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
