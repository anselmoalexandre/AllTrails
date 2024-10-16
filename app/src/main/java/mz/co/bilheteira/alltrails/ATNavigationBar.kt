package mz.co.bilheteira.alltrails

import android.content.res.Configuration
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
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
        icon = Icons.Default.Search
    )
}

@Composable
private fun RowScope.CommunityTab(modifier: Modifier) {
    NavItem(
        modifier = modifier,
        label = "Community",
        icon = Icons.Default.Person
    )
}

@Composable
private fun RowScope.NavigateTab(modifier: Modifier) {
    NavItem(
        modifier = modifier,
        label = "Navigate",
        icon = Icons.Default.KeyboardArrowUp
    )
}

@Composable
private fun RowScope.SavedTab(modifier: Modifier) {
    NavItem(
        modifier = modifier,
        label = "Saved",
        icon = Icons.Default.AccountBox
    )
}

@Composable
private fun RowScope.ProfileTab(modifier: Modifier) {
    NavItem(
        modifier = modifier,
        label = "Profile",
        icon = Icons.Default.AccountCircle
    )
}

@Composable
private fun RowScope.NavItem(
    modifier: Modifier,
    selected: Boolean = false,
    label: String,
    icon: ImageVector,
) {
    NavigationBarItem(
        modifier = modifier,
        selected = selected,
        label = {
            Text(
                text = label,
                style = MaterialTheme.typography.labelSmall
            )
        },
        icon = {
            Icon(
                imageVector = icon,
                contentDescription = null
            )
        },
        onClick = {},
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
