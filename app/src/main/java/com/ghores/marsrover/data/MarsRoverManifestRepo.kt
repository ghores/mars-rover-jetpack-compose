package com.ghores.marsrover.data

import com.ghores.marsrover.model.RoverManifestUiState
import com.ghores.marsrover.model.toUiModel
import com.ghores.marsrover.service.MarsRoverManifestService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MarsRoverManifestRepo @Inject constructor(
    private val marsRoverManifestService: MarsRoverManifestService
) {
    fun getMarsRoverManifest(roverName: String): Flow<RoverManifestUiState> = flow {
        try {
            emit(
                toUiModel(
                    marsRoverManifestService.getMarsRoverManifest(
                        roverName.lowercase()
                    )
                )
            )
        } catch (throwable: Throwable) {
            emit(RoverManifestUiState.Error)
        }
    }
}