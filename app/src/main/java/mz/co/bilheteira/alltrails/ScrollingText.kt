package mz.co.bilheteira.alltrails

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import mz.co.bilheteira.alltrails.ui.theme.AllTrailsTheme

@Composable
internal fun ScrollingText(
    text: String,
    modifier: Modifier = Modifier,
) {
    AnimatedContent(
        targetState = text,
        transitionSpec = { searchTextChangeAnimation() },
        label = ""
    ) { state ->
        Text(
            text = state,
            modifier = modifier,
        )
    }
}

private fun searchTextChangeAnimation(
    durationMillis: Int = 1400,
): ContentTransform {
    val enterTransition = slideInVertically(
        animationSpec = tween(durationMillis),
    ) { height ->
        height
    } + fadeIn(
        animationSpec = tween(durationMillis),
    )

    val exitTransition = slideOutVertically(
        animationSpec = tween(durationMillis),
    ) { height ->
        -height
    } + fadeOut(
        animationSpec = tween(durationMillis),
    )

    return enterTransition.togetherWith(exitTransition)
}

@Preview
@Composable
internal fun ScrollingTextPreview() {
    AllTrailsTheme {
        ScrollingText(text = "Find trails")
    }
}
