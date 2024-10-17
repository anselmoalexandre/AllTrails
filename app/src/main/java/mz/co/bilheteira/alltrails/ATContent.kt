package mz.co.bilheteira.alltrails

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mz.co.bilheteira.alltrails.ui.theme.AllTrailsTheme

@Composable
internal fun AllTrailsContent() {
    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxSize(),
        ) {
            ATSearchBar(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
            )

            FilterButtonRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            )

            TrailList()

            ATNavigationBar(modifier = Modifier.fillMaxWidth())
        }
    }
}

@Composable
private fun ColumnScope.TrailList() {
    LazyColumn(
        contentPadding = PaddingValues(
            start = 16.dp,
            top = 0.dp,
            end = 16.dp,
            bottom = 16.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .weight(1F)
    ) {
        items(count = 4) { index ->
            if (index == 1) {
                TrailGroupListItem()
            } else {
                TrailListItem()
            }
        }
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
internal fun AllTrailsContentPreview() {
    AllTrailsTheme {
        AllTrailsContent()
    }
}