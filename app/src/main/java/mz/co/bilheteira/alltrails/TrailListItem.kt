package mz.co.bilheteira.alltrails

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mz.co.bilheteira.alltrails.ui.theme.AllTrailsTheme

@Composable
internal fun TrailListItem(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
        ) {
            TrailImage()

            BookmarkIcon()
        }
    }
}

@Composable
private fun BoxScope.BookmarkIcon() {
    IconButton(
        onClick = {},
        modifier = Modifier
            .offset(x = (-10).dp, y = 10.dp)
            .clip(CircleShape)
            .background(
                color = MaterialTheme.colorScheme.background
            )
            .align(Alignment.TopEnd)
    ) {
        Icon(
            imageVector = Icons.Default.BookmarkBorder,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onBackground
        )
    }
}

/**
 * For now, we are showing a static image but we could convert this to
 * a pager indicator in future
 */

@Composable
private fun TrailImage() {
    Image(
        painter = painterResource(R.drawable.trails),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1F),
    )
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
private fun TrailListItemPreview() {
    AllTrailsTheme {
        TrailListItem()
    }
}
