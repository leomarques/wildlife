package lmm.wildlife.ui.animals

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import lmm.domain.model.Animal
import lmm.wildlife.ui.animals.components.AnimalItem
import lmm.wildlife.ui.animals.components.MySearchBar
import java.text.Normalizer

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

        LazyColumn {
            items(
                animalsList
                    .filter { animal ->
                        animal.name
                            .lowercase()
                            .normalize()
                            .startsWith(
                                filter.value
                                    .lowercase()
                                    .normalize()
                            )
                    }
                    .sortedBy { animal -> animal.name.normalize() }
            ) { animal ->
                AnimalItem(animal)
            }
        }
    }
}

fun CharSequence.normalize(): String {
    val temp = Normalizer.normalize(this, Normalizer.Form.NFD)
    return "\\p{InCombiningDiacriticalMarks}+".toRegex().replace(temp, "")
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
