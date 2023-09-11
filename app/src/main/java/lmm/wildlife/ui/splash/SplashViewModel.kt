package lmm.wildlife.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import lmm.domain.interactors.DataInteractor
import lmm.domain.interactors.SaveAllAnimalsInteractor

class SplashViewModel(
    private val dataInteractor: DataInteractor,
    private val saveAllAnimalsInteractor: SaveAllAnimalsInteractor,
) : ViewModel() {

    private val _splashUiState = MutableStateFlow(SplashUIState())
    val splashUiState: StateFlow<SplashUIState> = _splashUiState.asStateFlow()

    init {
        viewModelScope.launch {
            if (dataInteractor.isFirstTime()) {
                saveAllAnimalsInteractor.execute {
                    dataInteractor.saveNotFirstTime()

                    _splashUiState.update { currentState ->
                        currentState.copy(isLoading = false)
                    }
                }
            } else {
                _splashUiState.update { currentState ->
                    currentState.copy(isLoading = false)
                }
            }
        }
    }
}
