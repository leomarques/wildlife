package lmm.wildlife.ui.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import lmm.wildlife.ui.LoadingScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = koinViewModel(),
    nextContent: @Composable () -> Unit
) {
    val uiState by viewModel.splashUiState.collectAsState()

    if (uiState.isLoading) {
        LoadingScreen()
    } else {
        nextContent()
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen {}
}
