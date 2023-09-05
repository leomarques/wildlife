package lmm.wildlife.ui.animals

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import lmm.domain.model.Animal

@Composable
fun AnimalsLayout(animalsList: List<Animal>) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Row(Modifier.horizontalScroll(rememberScrollState())) {
            Column {
                Header()

                LazyColumn {
                    items(animalsList) { animal ->
                        AnimalItem(animal)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun AnimalsLayoutPreview() {
    AnimalsLayout(
        animalsList = listOf(
            Animal(
                name = "Cachorro",
                appelation = "Tatanka",
                tier = "Legendary",
                bodyType = "Massive",
                weapon = "Sniper Rifle",
                trapper = 1,
                camp = 0,
                total = 1,
                have = 0,
                need = 1
            ),
            Animal(
                name = "Cachorro",
                appelation = "Tatanka",
                tier = "Legendary",
                bodyType = "Massive",
                weapon = "Sniper Rifle",
                trapper = 1,
                camp = 0,
                total = 1,
                have = 0,
                need = 1
            ),
            Animal(
                name = "Cachorro",
                appelation = "Tatanka",
                tier = "Legendary",
                bodyType = "Massive",
                weapon = "Sniper Rifle",
                trapper = 1,
                camp = 0,
                total = 1,
                have = 0,
                need = 1
            ),
        )
    )
}
