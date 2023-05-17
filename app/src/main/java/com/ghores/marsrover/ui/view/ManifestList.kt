package com.ghores.marsrover.ui.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ghores.marsrover.R
import com.ghores.marsrover.model.RoverManifestUiModel

@Composable
fun ManifestList(
    roverManifestUiModelList: List<RoverManifestUiModel>
) {
    Surface(color = MaterialTheme.colorScheme.background, modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            items(count = roverManifestUiModelList.size, itemContent = { index ->
                Manifest(roverManifestUiModel = roverManifestUiModelList[index])
            })
        }
    }
}

@Composable
fun Manifest(
    roverManifestUiModel: RoverManifestUiModel
) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clickable { }
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = stringResource(id = R.string.sol, roverManifestUiModel.sol))
            Text(text = stringResource(id = R.string.earth_date, roverManifestUiModel.earthDate))
            Text(text = stringResource(id = R.string.number_of_photo, roverManifestUiModel.photoNumber))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ManifestPreview() {
    Manifest(roverManifestUiModel = RoverManifestUiModel(sol = "4", earthDate = "2021-03-05", photoNumber = "34"))
}