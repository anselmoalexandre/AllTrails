package mz.co.bilheteira.alltrails

import android.content.res.Configuration
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmarks
import androidx.compose.material.icons.filled.Navigation
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.PermIdentity
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import mz.co.bilheteira.alltrails.ui.theme.AllTrailsTheme

@Composable
internal fun ATNavigationBar(modifier: Modifier = Modifier) {
    NavigationBar {
        ExploreTab(modifier)

        CommunityTab(modifier)

        NavigateTab(modifier)

        SavedTab(modifier)

        ProfileTab(modifier)
    }
}

@Composable
private fun RowScope.ExploreTab(modifier: Modifier) {
    NavItem(
        modifier = modifier,
        label = "Explore",
        icon = Icons.Default.Search,
        selected = true,
    )
}

@Composable
private fun RowScope.CommunityTab(modifier: Modifier) {
    NavItem(
        modifier = modifier,
        label = "Community",
        icon = Icons.Default.People
    )
}

@Composable
private fun RowScope.NavigateTab(modifier: Modifier) {
    NavItem(
        modifier = modifier,
        label = "Navigate",
        icon = Icons.Default.Navigation
    )
}

@Composable
private fun RowScope.SavedTab(modifier: Modifier) {
    NavItem(
        modifier = modifier,
        label = "Saved",
        icon = Icons.Default.Bookmarks
    )
}

@Composable
private fun RowScope.ProfileTab(modifier: Modifier) {
    NavItem(
        modifier = modifier,
        label = "Profile",
        icon = Icons.Default.PermIdentity
    )
}

@Composable
private fun RowScope.NavItem(
    modifier: Modifier,
    selected: Boolean = false,
    label: String,
    icon: ImageVector,
) {
    val selectedIndicatorColor = Color.Transparent
    val selectedColor = MaterialTheme.colorScheme.onSurface
    val unselectedColor = selectedColor.copy(
        alpha = 0.5F
    )

    val colorsWithoutIndicator = NavigationBarItemDefaults
        .colors()
        .copy(
            selectedIconColor = selectedColor,
            selectedTextColor = selectedColor,
            selectedIndicatorColor = selectedIndicatorColor,
            unselectedIconColor = unselectedColor,
            unselectedTextColor = unselectedColor,
        )

    NavigationBarItem(
        selected = selected,
        label = {
            Text(
                text = label,
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Bold.takeIf { selected }
            )
        },
        icon = {
            Icon(
                imageVector = icon,
                contentDescription = null
            )
        },
        onClick = {},
        modifier = modifier,
        colors = colorsWithoutIndicator,
    )
}


@Preview(name = "Bottom Navigation", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "Bottom Navigation", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun ATNavigationBarPreview() {
    AllTrailsTheme {
        ATNavigationBar()
    }
}
