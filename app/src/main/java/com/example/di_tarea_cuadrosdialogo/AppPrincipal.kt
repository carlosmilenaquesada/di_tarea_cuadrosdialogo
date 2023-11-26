package com.example.di_tarea_cuadrosdialogo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable

fun AppPrincipal() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        MostrarDialogPersonalizado()
        MostrarAlertDialogPersonalizado()

    }

}