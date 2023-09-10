package lmm.wildlife.ui.animals.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import lmm.wildlife.ui.theme.SpaceSize

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySearchBar(
    onSearch: (String) -> Unit
) {
    var text by rememberSaveable { mutableStateOf("") }
    
    Box {
        SearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(SpaceSize.SmallSpaceSize)
                .padding(bottom = SpaceSize.SmallSpaceSize),
            query = text,
            onQueryChange = {
                text = it
                onSearch(it)
            },
            onSearch = onSearch,
            active = false,
            onActiveChange = {},
            placeholder = { Text("Search for animal name", color = Color.Gray) },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
        ) {}
    }
}

@Preview
@Composable
fun MySearchBarPreview() {
    MySearchBar {}
}
