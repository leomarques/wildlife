package lmm.wildlife.ui.animals.components

import lmm.wildlife.ui.theme.DarkBlue
import lmm.wildlife.ui.theme.DarkGreen
import lmm.wildlife.ui.theme.DarkOrange
import lmm.wildlife.ui.theme.DarkPurple
import lmm.wildlife.ui.theme.DarkRed
import lmm.wildlife.ui.theme.DarkYellow

fun String.getTierColor() = when (this) {
    "Legendary" -> DarkOrange
    "Skin" -> DarkGreen
    "Feather" -> DarkBlue
    "Antler" -> DarkPurple
    "Carcass" -> DarkYellow

    "Lendário" -> DarkOrange
    "Pele" -> DarkGreen
    "Pena" -> DarkBlue
    "Chifre" -> DarkPurple
    "Carcaça" -> DarkYellow

    else -> null
}

fun String.getWeaponColor() = when (this) {
    "Sniper Rifle" -> DarkPurple
    "Regular Rifle" -> DarkBlue
    "Varmint Rifle" -> DarkOrange
    "Repeater" -> DarkRed
    "Game Arrow" -> DarkGreen

    "Rifle de Precisão" -> DarkPurple
    "Rifle Padrão" -> DarkBlue
    "Rifle Antipragas" -> DarkOrange
    "Arma de Repetição" -> DarkRed
    "Flecha de Caça Pequena" -> DarkGreen

    else -> DarkYellow
}

fun String.getAppelationColor() = when (this) {
    "Black" -> DarkRed
    "Tatanka" -> DarkGreen
    "White" -> DarkBlue
    "Collared" -> DarkPurple

    "Negro" -> DarkRed
    "Búfalo" -> DarkGreen
    "Branco" -> DarkBlue
    "Colarinho" -> DarkPurple

    else -> null
}
