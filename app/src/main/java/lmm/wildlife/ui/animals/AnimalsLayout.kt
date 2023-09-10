package lmm.wildlife.ui.animals

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import lmm.domain.model.Animal
import lmm.wildlife.ui.animals.components.AnimalItem
import lmm.wildlife.ui.animals.components.Header
import lmm.wildlife.ui.animals.components.MySearchBar

@Composable
fun AnimalsLayout(animalsList: List<Animal>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        val filter = remember {
            mutableStateOf("")
        }

        MySearchBar(
            onSearch = { text ->
                filter.value = text
            }
        )

        Row(Modifier.horizontalScroll(rememberScrollState())) {
            Column {
                Header()

                LazyColumn {
                    items(animalsList.filter { animal ->
                        animal.name.lowercase().startsWith(filter.value.lowercase())
                    }) { animal ->
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
