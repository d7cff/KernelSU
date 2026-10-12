package com.bambulab.creator.ui.component.uninstalldialog

import androidx.compose.runtime.Composable
import com.bambulab.creator.ui.LocalUiMode
import com.bambulab.creator.ui.UiMode

@Composable
fun UninstallDialog(
    show: Boolean,
    onDismissRequest: () -> Unit
) {
    when (LocalUiMode.current) {
        UiMode.Miuix -> UninstallDialogMiuix(show, onDismissRequest)
        UiMode.Material -> UninstallDialogMaterial(show, onDismissRequest)
    }
}
