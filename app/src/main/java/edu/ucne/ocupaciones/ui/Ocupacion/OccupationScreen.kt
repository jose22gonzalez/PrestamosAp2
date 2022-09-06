package edu.ucne.ocupaciones.ui.Ocupacion

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import  androidx.compose.foundation.layout.fillMaxWidth
import  androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OccupationScreen(
    onNavigateBack: () -> Unit,
    viewModel: OccupationViewModel = hiltViewModel()
) {
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(title = { Text("Occupation Entry")})

        },

    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(8.dp)
                ) {
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text(text = "Descrition")},
                        value = viewModel.description,
                        onValueChange = {viewModel.description = it}
                    )
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text(text = "Salary")},
                        value = viewModel.salary,
                        onValueChange = {viewModel.salary = it},
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        )


                    )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    ,

                onClick = {
                viewModel.Save()
                onNavigateBack()
            }) {
               Text(text = "Add a Occupation")
            }

        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun Preview() {
    OccupationScreen( {  })
}









