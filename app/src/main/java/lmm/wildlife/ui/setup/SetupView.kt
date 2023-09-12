package lmm.wildlife.ui.setup

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.androidx.compose.koinViewModel

@Composable
fun SetupView(
    viewModel: SetupViewModel = koinViewModel(),
    onDone: () -> Unit
) {
    val isLoading by viewModel.isLoading.collectAsState()

    if (isLoading) {
        LoadingScreen()
    } else {
        onDone()
    }
}
