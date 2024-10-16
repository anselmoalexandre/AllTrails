package mz.co.bilheteira.alltrails

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mz.co.bilheteira.alltrails.ui.theme.AllTrailsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ATSearchInput(modifier: Modifier = Modifier) {
    SearchBar(
        modifier = modifier,
        query = "Find trails",
        onSearch = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Search,
                contentDescription = "Leading icon"
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Tune,
                contentDescription = "Trailing icon"
            )
        },
        active = false,
        onQueryChange = {},
        onActiveChange = {},
    ) {

    }
}

@Preview(name = "Day Mode", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "Night Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun ATSearchInputPreview() {
    AllTrailsTheme {
        ATSearchInput(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )
    }
}
