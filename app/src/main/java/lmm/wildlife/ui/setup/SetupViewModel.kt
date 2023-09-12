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

    private val _setupUiState = MutableStateFlow(true)
    val setupUiState: StateFlow<Boolean> = _setupUiState.asStateFlow()

    init {
        viewModelScope.launch {
            dataInteractor.shouldPopulateDB().collect { shouldPopulateDB ->
                if (shouldPopulateDB) {
                    saveAllAnimalsInteractor.execute {
                        _setupUiState.update { false }
                    }
                } else {
                    _setupUiState.update { false }
                }
            }
        }
    }
}
