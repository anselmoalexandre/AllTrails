package mz.co.bilheteira.alltrails

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import mz.co.bilheteira.alltrails.ui.theme.AllTrailsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ATSearchBar(modifier: Modifier = Modifier) {
    val searchOptions = listOf("trails", "parks", "cities")

    var typeIndex by remember {
        mutableIntStateOf(0)
    }

    LaunchedEffect(Unit) {
        while (true) {
            delay(3000)

            typeIndex = (typeIndex + 1) % searchOptions.size
        }
    }

    SearchBar(
        inputField = {
            SearchBarDefaults.InputField(
                query = "",
                onQueryChange = {},
                onSearch = {},
                expanded = false,
                onExpandedChange = {},
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Search,
                        contentDescription = "Leading icon"
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Tune,
                        contentDescription = "Trailing icon",
                        modifier = Modifier
                            .background(
                                color = MaterialTheme.colorScheme.background,
                                shape = CircleShape
                            )
                            .padding(5.dp)
                    )
                },
                placeholder = {
                    Row {
                        Text(
                            text = "Find"
                        )

                        ScrollingText(
                            text = searchOptions[typeIndex],
                            modifier = Modifier.padding(start = 5.dp)
                        )
                    }
                },
            )
        },
        expanded = false,
        onExpandedChange = {},
        modifier = modifier,
    ) {}
}

@Preview(name = "Day Mode", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "Night Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun ATSearchInputPreview() {
    AllTrailsTheme {
        ATSearchBar(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )
    }
}
