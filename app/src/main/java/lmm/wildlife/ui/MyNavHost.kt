package lmm.wildlife.ui

import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import lmm.wildlife.ui.animals.AnimalsView
import lmm.wildlife.ui.setup.SetupView

const val setupScreen = "setup"
const val animalsScreen = "animals"

@Composable
fun MyNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = setupScreen
) {
    NavHost(
        modifier = modifier.background(MaterialTheme.colorScheme.background),
        navController = navController,
        startDestination = startDestination
    ) {
        composable(setupScreen) {
            SetupView {
                navController.navigatePop(animalsScreen)
            }
        }
        composable(animalsScreen) {
            AnimalsView()
        }
    }
}

private fun NavHostController.navigatePop(animalsScreen: String) {
    navigate(animalsScreen) {
        popUpToTop(this@navigatePop)
    }
}

fun NavOptionsBuilder.popUpToTop(navController: NavController) {
    popUpTo(navController.currentBackStackEntry?.destination?.route ?: return) {
        inclusive = true
    }
}
