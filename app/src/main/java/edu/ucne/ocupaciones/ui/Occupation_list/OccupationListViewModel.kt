package edu.ucne.ocupaciones.ui.Occupation_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.ucne.ocupaciones.Model.Occupation
import edu.ucne.ocupaciones.respository.OccupationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class OccupationListUIState(
    val occupations: List<Occupation> = emptyList(),

)

@HiltViewModel
class OccupationListViewModel @Inject constructor(
    val respository: OccupationRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(OccupationListUIState())
    val uiState: StateFlow<OccupationListUIState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            respository.getAll().collect { list ->
                _uiState.update {
                    it.copy(occupations = list)
                }
            }
        }
    }

    fun DeleteOccupation(occupation: Occupation) {
        viewModelScope.launch(Dispatchers.IO) {
            respository.deleteOccupation(occupation)
        }
    }
}


