package lmm.wildlife.ui.animals

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.androidx.compose.koinViewModel

@Composable
fun AnimalsView(viewModel: AnimalsViewModel = koinViewModel()) {

    val uiState by viewModel.animalsUiState.collectAsState()

    AnimalsLayout(uiState.animalsList)
}
