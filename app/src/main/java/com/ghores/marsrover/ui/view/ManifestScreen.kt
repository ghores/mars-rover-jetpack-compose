package com.ghores.marsrover.ui.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ghores.marsrover.model.RoverManifestUiState
import com.ghores.marsrover.ui.manifestlist.MarsRoverManifestViewModel

@Composable
fun ManifestScreen(
    roverName: String?,
    marsRoverManifestViewModel: MarsRoverManifestViewModel
) {
    val viewState by marsRoverManifestViewModel.roverManifestUiState.collectAsStateWithLifecycle()

    if (roverName != null) {
        LaunchedEffect(Unit) {
            marsRoverManifestViewModel.getMarsRoverManifest(roverName)
        }
        when(val roverManifestUiState = viewState) {
            RoverManifestUiState.Error -> Error()
            RoverManifestUiState.Loading -> Loading()
            is RoverManifestUiState.Success -> ManifestList(roverManifestUiModelList = roverManifestUiState.roverManifestUiModelList)
        }
    }
}