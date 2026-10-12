package com.bambulab.creator.ui.screen.appprofile

import androidx.compose.runtime.Immutable
import com.bambulab.creator.Natives
import com.bambulab.creator.ui.screen.superuser.GroupedApps

@Immutable
data class AppProfileUiState(
    val uid: Int,
    val packageName: String,
    val profile: Natives.Profile,
    val appGroup: GroupedApps,
    val sharedUserId: String,
) {
    val isUidGroup get() = appGroup.apps.size > 1
}

@Immutable
data class AppProfileActions(
    val onBack: () -> Unit,
    val onLaunchApp: (String, Int) -> Unit,
    val onForceStopApp: (String, Int) -> Unit,
    val onRestartApp: (String, Int) -> Unit,
    val onViewTemplate: (String) -> Unit,
    val onManageTemplate: () -> Unit,
    val onProfileChange: (Natives.Profile) -> Unit,
)
