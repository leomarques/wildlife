package lmm.wildlife.ui.animals

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import lmm.domain.interactors.GetAllAnimalsInteractor

class AnimalsViewModel(
    private val getAllAnimalsInteractor: GetAllAnimalsInteractor
) : ViewModel() {

    private val _animalsUIState = MutableStateFlow(AnimalsUIState(emptyList()))
    val animalsUiState: StateFlow<AnimalsUIState> = _animalsUIState.asStateFlow()

    init {
        viewModelScope.launch {
            getAllAnimalsInteractor.execute().collect { list ->
                _animalsUIState.value = AnimalsUIState(list)
            }
        }
    }
}
