package lmm.wildlife.ui.setup

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.androidx.compose.koinViewModel

@Composable
fun SetupView(
    viewModel: SetupViewModel = koinViewModel(),
    nextContent: @Composable () -> Unit
) {
    val isLoading by viewModel.setupUiState.collectAsState()

    if (isLoading) {
        LoadingScreen()
    } else {
        nextContent()
    }
}
