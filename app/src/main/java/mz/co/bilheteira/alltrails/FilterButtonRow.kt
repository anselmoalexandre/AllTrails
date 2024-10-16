package mz.co.bilheteira.alltrails

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChildFriendly
import androidx.compose.material.icons.filled.Nature
import androidx.compose.material.icons.filled.PinDrop
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mz.co.bilheteira.alltrails.ui.theme.AllTrailsTheme

@Composable
internal fun FilterButtonRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(
            horizontal = 16.dp,
        )
    ) {
        nearbyButton()

        amongTreesButton()

        kidFriendlyButton()
    }
}

private fun LazyListScope.nearbyButton() {
    item {
        FilterButton(
            icon = Icons.Default.PinDrop,
            text = "Nearby",
            selected = true,
        )
    }
}

private fun LazyListScope.amongTreesButton() {
    item {
        FilterButton(
            icon = Icons.Default.Nature,
            text = "Among trees",
        )
    }
}

private fun LazyListScope.kidFriendlyButton() {
    item {
        FilterButton(
            icon = Icons.Default.ChildFriendly,
            text = "Kid-friendly",
        )
    }
}

@Preview(
    name = "Day Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "Night Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
internal fun FilterButtonRowPreview() {
    AllTrailsTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            FilterButtonRow()
        }
    }
}
