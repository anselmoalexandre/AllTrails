package mz.co.bilheteira.alltrails

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Map
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
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

            TrailList(modifier = Modifier.weight(1F))

            ATNavigationBar(modifier = Modifier.fillMaxWidth())
        }
    }
}

@Composable
private fun TrailList(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth(),
    ) {
        val listState = rememberLazyListState()
        val firstVisibleItemIndex = remember {
            derivedStateOf {
                listState.firstVisibleItemScrollOffset
            }
        }

        LazyColumn(
            contentPadding = PaddingValues(
                start = 16.dp,
                top = 0.dp,
                end = 16.dp,
                bottom = 16.dp
            ),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            state = listState,
            modifier = modifier
                .fillMaxWidth()
        ) {
            items(count = 4) { index ->
                if (index == 1) {
                    TrailGroupListItem()
                } else {
                    TrailListItem()
                }
            }
        }

        ExtendedFloatingActionButton(
            onClick = {},
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(Alignment.BottomCenter)
        ) {
            Icon(
                imageVector = Icons.Default.Map,
                contentDescription = null
            )

            AnimatedVisibility(
                visible = firstVisibleItemIndex.value == 0
            ) {
                Text(
                    text = "Map",
                    modifier = Modifier.padding(start = 5.dp)
                )
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