package lmm.wildlife.ui.animals.components

import lmm.wildlife.ui.theme.DarkBlue
import lmm.wildlife.ui.theme.DarkGreen
import lmm.wildlife.ui.theme.DarkOrange
import lmm.wildlife.ui.theme.DarkPurple
import lmm.wildlife.ui.theme.DarkRed
import lmm.wildlife.ui.theme.DarkYellow

fun String.getTierColor() = when (this) {
    "Legendary" -> DarkOrange
    "Perfect" -> DarkGreen
    "Feather" -> DarkBlue
    "Antler" -> DarkPurple
    "Carcass" -> DarkYellow
    else -> null
}

fun String.getWeaponColor() = when (this) {
    "Sniper Rifle" -> DarkPurple
    "Regular Rifle" -> DarkBlue
    "Varmint Rifle" -> DarkOrange
    "Repeater" -> DarkRed
    "Game Arrow" -> DarkGreen
    else -> DarkYellow
}

fun String.getAppelationColor() = when (this) {
    "Black" -> DarkRed
    "Tatanka" -> DarkGreen
    "White" -> DarkBlue
    "Collared" -> DarkPurple
    else -> null
}

//fun String.getBodyTypeColor() = when (this) {
//    "Massive" -> DarkRed
//    "Large" -> DarkOrange
//    "Moderate" -> DarkPurple
//    "Medium" -> DarkBlue
//    "Small" -> DarkGreen
//    else -> null
//}
