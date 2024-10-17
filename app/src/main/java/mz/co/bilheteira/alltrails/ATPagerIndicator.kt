package mz.co.bilheteira.alltrails

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import mz.co.bilheteira.alltrails.ui.theme.AllTrailsTheme

/**
 * Leftmost Circle:
 * - Selected (selectedIndex == 0)
 * - Unselected (selectedIndex == 1)
 * - Showing more (selectedIndex > 1)
 *
 * Middle Circle
 * - Selected (index > 0 && index < lastIndex)
 * - Unselected (index == 0 || index == lastIndex)
 *
 * Rightmost Circle
 * - Selected (selectedIndex == lastIndex)
 * - Unselected (selectedIndex < lastIndex)
 * - Showing more (selectedIndex < lastIndex )
 *
 * TODO: What if less than three pages?
 * - If one page, show nothing
 * - If two pages, show two dots.
 */

@Composable
internal fun ATPagerIndicator(
    currentPageIndex: Int,
    totalPages: Int,
    modifier: Modifier = Modifier
) {
    val selectedColor = Color.White

    val defaultColor = selectedColor.copy(
        alpha = 0.65F
    )

    val defaultSize = 12.dp
    val miniSize = 8.dp //defaultSize / 2

    Row(
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
    ) {
        LeadingIndicatorDot(
            currentPageIndex = currentPageIndex,
            selectedColor = selectedColor,
            defaultColor = defaultColor,
            defaultSize = defaultSize,
            miniSize = miniSize
        )

        MiddleIndicatorDot(
            currentPageIndex = currentPageIndex,
            totalPages = totalPages,
            selectedColor = selectedColor,
            defaultColor = defaultColor,
            defaultSize = defaultSize
        )

        TrailingIndicatorDot(
            currentPageIndex = currentPageIndex,
            totalPages = totalPages,
            selectedColor = selectedColor,
            defaultColor = defaultColor,
            defaultSize = defaultSize,
            miniSize = miniSize
        )
    }
}

/**
 * Leftmost Circle:
 * - Selected (selectedIndex == 0)
 * - Unselected (selectedIndex == 1)
 * - Showing more (selectedIndex > 1)
 */
@Composable
private fun LeadingIndicatorDot(
    currentPageIndex: Int,
    selectedColor: Color,
    defaultColor: Color,
    defaultSize: Dp,
    miniSize: Dp
) {
    val startIndicatorColor = when {
        currentPageIndex == 0 -> selectedColor
        else -> defaultColor
    }

    val startIndicatorSize = when {
        currentPageIndex <= 1 -> defaultSize
        else -> miniSize
    }

    IndicatorDot(
        color = startIndicatorColor,
        size = startIndicatorSize
    )
}

/**
 * Middle Circle
 * - Selected (index > 0 && index < lastIndex)
 * - Unselected (index == 0 || index == lastIndex)
 */
@Composable
private fun MiddleIndicatorDot(
    currentPageIndex: Int,
    totalPages: Int,
    selectedColor: Color,
    defaultColor: Color,
    defaultSize: Dp
) {
    val middleIndicatorColor = when {
        currentPageIndex > 0 && currentPageIndex < totalPages - 1 -> selectedColor
        else -> defaultColor
    }

    IndicatorDot(
        color = middleIndicatorColor,
        size = defaultSize
    )
}

/**
 * Rightmost Circle
 * - Selected (selectedIndex == lastIndex)
 * - Unselected (selectedIndex < lastIndex)
 * - Showing more (selectedIndex < lastIndex )
 */
@Composable
private fun TrailingIndicatorDot(
    currentPageIndex: Int,
    totalPages: Int,
    selectedColor: Color,
    defaultColor: Color,
    defaultSize: Dp,
    miniSize: Dp
) {
    val trailingIndicatorColor = when {
        currentPageIndex == totalPages - 1 -> selectedColor
        else -> defaultColor
    }

    val trailingIndicatorSize = when {
        currentPageIndex >= totalPages - 2 -> defaultSize
        else -> miniSize
    }

    IndicatorDot(
        color = trailingIndicatorColor,
        size = trailingIndicatorSize
    )
}

@Composable
internal fun IndicatorDot(
    color: Color,
    size: Dp,
) {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(color)
            .size(size)
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
internal fun StartPagerIndicatorPreview() {
    AllTrailsTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            ATPagerIndicator(
                currentPageIndex = 0,
                totalPages = 5
            )
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
internal fun MiddlePagerIndicatorPreview() {
    AllTrailsTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            ATPagerIndicator(
                currentPageIndex = 2,
                totalPages = 5
            )
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
internal fun EndPagerIndicatorPreview() {
    AllTrailsTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            ATPagerIndicator(
                currentPageIndex = 4,
                totalPages = 5
            )
        }
    }
}
