package edu.ucne.ocupaciones.ui.Occupation_list


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.IconButton
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import edu.ucne.ocupaciones.Model.Occupation


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OccupationListScreen(
    onClick: () ->Unit,
    viewModel: OccupationListViewModel = hiltViewModel()
) {
   Scaffold (
       topBar = {CenterAlignedTopAppBar(title = {Text("Occupation List")})
       },
       floatingActionButton = {
           FloatingActionButton(onClick = onClick) {
               Icon(imageVector = Icons.Default.Add, contentDescription = "Add a Occupation")
           }

       }
   ) {
       val uiState by viewModel.uiState.collectAsState()

       Column(modifier = Modifier
           .fillMaxWidth()
           .padding(it)) {
          OccupationList(
              occupation = uiState.occupations,
              modifier = Modifier
                  .fillMaxSize()
                  .padding(it)
          )
       }
   }
}



@Composable
fun OccupationList(
    occupation: List<Occupation>,
    viewModel: OccupationListViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(occupation) { occupation ->
            OccupationRow(occupation, viewModel)
        }
    }
}

@Composable
fun OccupationRow(occupation: Occupation, viewModel: OccupationListViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Text(
            text = occupation.Description,
            style = MaterialTheme.typography.titleLarge
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "Salary: ${occupation.Salary}"
            )
            IconButton(
                modifier = Modifier.padding(0.dp),
                onClick = { viewModel.DeleteOccupation(occupation)}) {
                Icon(imageVector = Icons.Outlined.Clear, contentDescription = "add",
                    tint = Color.Red)
            }
        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            color = Color.LightGray
        )
    }
}

