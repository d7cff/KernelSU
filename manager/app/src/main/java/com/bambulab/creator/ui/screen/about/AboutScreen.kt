package com.bambulab.creator.ui.screen.about

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.dropUnlessResumed
import com.bambulab.creator.BuildConfig
import com.bambulab.creator.R
import com.bambulab.creator.ui.LocalUiMode
import com.bambulab.creator.ui.UiMode
import com.bambulab.creator.ui.navigation3.LocalNavigator

@Composable
fun AboutScreen() {
    val navigator = LocalNavigator.current
    val uriHandler = LocalUriHandler.current
    val htmlString = stringResource(
        id = R.string.about_source_code,
        "<b><a href=\"https://www.bambulab.com\">Website</a></b>",
        "<b><a href=\"https://www.bambulab.com\">Support</a></b>"
    )
    val state = AboutUiState(
        title = stringResource(R.string.about),
        appName = stringResource(R.string.app_name),
        versionName = BuildConfig.VERSION_NAME,
        links = extractLinks(htmlString),
    )
    val actions = AboutScreenActions(
        onBack = dropUnlessResumed { navigator.pop() },
        onOpenLink = uriHandler::openUri,
    )

    when (LocalUiMode.current) {
        UiMode.Miuix -> AboutScreenMiuix(state, actions)
        UiMode.Material -> AboutScreenMaterial(state, actions)
    }
}
