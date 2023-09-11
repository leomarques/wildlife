package lmm.wildlife.ui.setup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import lmm.domain.interactors.DataInteractor
import lmm.domain.interactors.SaveAllAnimalsInteractor

class SetupViewModel(
    private val dataInteractor: DataInteractor,
    private val saveAllAnimalsInteractor: SaveAllAnimalsInteractor,
) : ViewModel() {

    private val _setupUiState = MutableStateFlow(SetupUIState())
    val setupUiState: StateFlow<SetupUIState> = _setupUiState.asStateFlow()

    init {
        viewModelScope.launch {
            if (dataInteractor.isFirstTime()) {
                saveAllAnimalsInteractor.execute {
                    _setupUiState.update { currentState ->
                        currentState.copy(isLoading = false)
                    }
                }
            } else {
                _setupUiState.update { currentState ->
                    currentState.copy(isLoading = false)
                }
            }
        }
    }
}
