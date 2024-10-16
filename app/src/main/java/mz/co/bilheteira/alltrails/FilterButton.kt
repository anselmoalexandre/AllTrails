package mz.co.bilheteira.alltrails

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Nature
import androidx.compose.material.icons.filled.PinDrop
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mz.co.bilheteira.alltrails.ui.theme.AllTrailsTheme

@Composable
internal fun FilterButton(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    text: String,
    selected: Boolean = false,
) {
    val contentColor = MaterialTheme.colorScheme.onBackground

    val borderColor = if (selected) {
        contentColor
    } else {
        contentColor.copy(alpha = 0.33F)
    }

    val borderStroke = BorderStroke(
        width = 1.dp,
        color = borderColor
    )

    OutlinedButton(
        modifier = modifier,
        onClick = {},
        shape = RoundedCornerShape(size = 8.dp),
        contentPadding = PaddingValues(all = 8.dp),
        border = borderStroke,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = contentColor
        )

        Spacer(modifier = Modifier.width(5.dp))

        Text(
            text = text,
            color = contentColor
        )
    }
}

@Preview(name = "Day Mode", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "Night Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun SelectedFilterButtonPreview() {
    AllTrailsTheme {
        Surface(
            color = MaterialTheme.colorScheme.background,
        ) {
            FilterButton(
                icon = Icons.Default.PinDrop,
                text = "Nearby",
                selected = true,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview(name = "Day Mode", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "Night Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun UnselectedFilterButtonPreview() {
    AllTrailsTheme {
        Surface(
            color = MaterialTheme.colorScheme.background,
        ) {
            FilterButton(
                icon = Icons.Default.Nature,
                text = "Among trees",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
