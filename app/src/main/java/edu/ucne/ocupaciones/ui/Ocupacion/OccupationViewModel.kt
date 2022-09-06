package edu.ucne.ocupaciones.ui.Ocupacion

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.ucne.ocupaciones.Model.Occupation
import edu.ucne.ocupaciones.respository.OccupationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import edu.ucne.ocupaciones.ui.Occupation_list.OccupationListViewModel

@HiltViewModel
class OccupationViewModel @Inject constructor(
    val respository: OccupationRepository
) : ViewModel() {
    var description by mutableStateOf("")
    var salary by mutableStateOf("")


    fun validarsalary(): Boolean{
        var paso = false
        paso = salary.toDouble() > 0
        return paso

    }

    fun validardescription(): Boolean{
        var paso = false
        paso = description == null
        return paso
    }

    fun Save() {
        if(validarsalary() && validardescription()){
            viewModelScope.launch {
                respository.insertOccupation(
                    Occupation(
                        Description = description,
                        Salary = salary.toDouble()

                    )
                )
            }
        }

    }
}
