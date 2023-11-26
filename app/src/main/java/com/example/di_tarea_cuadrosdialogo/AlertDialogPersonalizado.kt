package com.example.di_tarea_cuadrosdialogo

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import com.google.android.material.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MostrarAlertDialogPersonalizado() {
    var show by rememberSaveable {
        mutableStateOf(false)
    }

    var terminosAceptados by rememberSaveable {
        mutableStateOf(false)
    }
    Column(
        Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Ejemplo Alert Dialog")
        Spacer(Modifier.height(16.dp))
        Button(onClick = { show = true }, shape = RoundedCornerShape(5.dp)) {
            Text(text = "Aceptar términos")
        }
        Spacer(Modifier.height(16.dp))
        TextField(
            value = TextFieldValue(
                if (terminosAceptados) {
                    "Los términos han sido aceptados."
                } else {
                    "Los términos no han sido aceptados todavía."
                }
            ),
            onValueChange = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp, vertical = 5.dp),
            trailingIcon = {
                val imagen = if (terminosAceptados) {
                    R.drawable.mtrl_ic_check_mark
                } else {
                    R.drawable.mtrl_ic_cancel
                }

                Icon(
                    painter = painterResource(id = imagen), contentDescription = "View"
                )
            },
            shape = RoundedCornerShape(0),
            maxLines = 1,
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                containerColor = Color(0xFFFAFAFA),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent

            ),
            textStyle = TextStyle(fontSize = 14.sp)
        )
    }
    AlertDialogPersonalizado(show = show, onDismiss = {
        show = false
        terminosAceptados = false
    }, onConfirm = {
        show = false
        terminosAceptados = true
    })
}

@Composable
fun AlertDialogPersonalizado(
    show: Boolean, onDismiss: () -> Unit, onConfirm: () -> Unit
) {
    if (show) {
        AlertDialog(
            onDismissRequest = { onDismiss() },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "Aceptar")
                }
            },
            title = { Text(text = "Términos de uso") },
            text = { Text(text = "En el presente documento (en adelante, el “Contrato”) se establecen los términos y condiciones de Robert Half Internacional Empresa de Servicios Transitorios Limitada, con domicilio en Avenida Isidora Goyenechea 2800 Piso 15. Torre Titanium 7550-647 Las Condes, que serán de aplicación al acceso y uso por parte del Usuario de esta página web (el  “Sitio Web”). Les rogamos lean atentamente el presente Contrato. \n" +
                    "Al acceder, consultar o utilizar el Sitio Web, los Usuarios (“Vd.”, “usted”, “Usuario”, o “usuario”) aceptan cumplir los términos y condiciones establecidos en este Contrato. En caso de que usted no acepte quedar vinculado por los presentes términos y condiciones, no podrá acceder a, ni utilizar, el Sitio Web. ") },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "Cancelar")
                }
            },
            properties = DialogProperties(
                dismissOnBackPress = true, dismissOnClickOutside = true
            )
        )
    }
}


