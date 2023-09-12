package lmm.wildlife.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import lmm.wildlife.ui.animals.AnimalsView
import lmm.wildlife.ui.setup.SetupView

const val setupScreen = "setup"
const val animalsScreen = "animals"

@Composable
fun Navigation() {
    var currentScreen by remember {
        mutableStateOf(setupScreen)
    }

    when (currentScreen) {
        setupScreen -> SetupView {
            currentScreen = animalsScreen
        }

        animalsScreen -> AnimalsView()
    }
}
