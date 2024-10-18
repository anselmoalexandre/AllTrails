package mz.co.bilheteira.alltrails

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
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
        TrailImageContainer()

        TrailInformationContainer()
    }
}

@Composable
private fun TrailInformationContainer() {
    Row(
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth(),
    ) {
        TrailInformation(
            modifier = Modifier
                .weight(1F),
        )

        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Default.Download,
                contentDescription = null,
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.onBackground,
                        shape = CircleShape
                    )
                    .padding(4.dp)
            )
        }
    }
}

@Composable
private fun TrailInformation(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        TrailTitle()

        TrailSubTitle()

        TrailDetails()
    }
}

@Composable
private fun TrailDetails() {
    val contentColor = LocalContentColor.current.copy(
        alpha = 0.75F
    )

    val detailsText = buildAnnotatedString {
        appendInlineContent("ratingIcon", "[icon]")
        append("4.6 • Easy • 2.20 Miles • Est. 44m")
    }

    val inlineContent = mapOf(
        Pair(
            // This tell the [CoreText] to replace the placeholder string "[icon]" by
            // the composable given in the [InlineTextContent] object.
            "ratingIcon",
            InlineTextContent(
                // Placeholder tells text layout the expected size and vertical alignment of
                // the children
                Placeholder(
                    width = LocalTextStyle.current.fontSize,
                    height = LocalTextStyle.current.fontSize,
                    placeholderVerticalAlign = PlaceholderVerticalAlign.TextCenter
                )
            ) {
                // This Icon will fill maximum size, which is specified by the [Placeholder] above.
                // Notice the width and height in [Placeholder] are specified in the TextUnit,
                // and are converted into pixel by text layout.

                Icon(
                    imageVector = Icons.Filled.Star,
                    tint = contentColor,
                    contentDescription = null
                )
            }
        )
    )

    Text(
        text = detailsText,
        inlineContent = inlineContent,
        style = MaterialTheme.typography.bodyMedium,
        color = contentColor,
    )
}

@Composable
private fun TrailSubTitle() {
    Text(
        text = "Lake Mohegan Recreation Area",
        style = MaterialTheme.typography.bodyMedium,
        color = LocalContentColor.current.copy(
            alpha = 0.75F
        ),
    )
}

@Composable
private fun TrailTitle() {
    Text(
        text = "Lake Mohegan Loop",
        style = MaterialTheme.typography.titleLarge
    )
}

@Composable
private fun TrailImageContainer() {
    val images = remember {
        TrailImageGenerator.generate()
    }

    val pagerState = rememberPagerState {
        images.size
    }

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(25.dp))
            .aspectRatio(1.5F),
    ) {

        TrailImages(
            imageResList = images,
            pagerState = pagerState
        )

        BookmarkIcon()

        ATPagerIndicator(
            currentPageIndex = pagerState.currentPage,
            totalPages = pagerState.pageCount,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
        )
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

@Composable
private fun TrailImages(
    imageResList: List<Int>,
    pagerState: PagerState,
) {
    HorizontalPager(
        state = pagerState,
    ) { pageIndex ->
        Image(
            painter = painterResource(id = imageResList[pageIndex]),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
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
private fun TrailListItemPreview() {
    AllTrailsTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            TrailListItem()
        }
    }
}
