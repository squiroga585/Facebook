package me.sebastianquiroga.facebook.ui.screens

import android.R.attr.contentDescription
import android.R.attr.tint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import me.sebastianquiroga.facebook.R
import androidx.compose.material3.Icon
import androidx.compose.ui.res.painterResource

// Colores extraídos de tu pantalla/proyecto
private val FacebookLightBlue = Color(0xFF4267B2)
private val FacebookGray = Color(0xFFF0F2F5)
private val FacebookBorderGray = Color(0xFFCCD0D5)
private val FacebookTextGray = Color(0xFF606770)
private val FacebookDarkText = Color(0xFF1C1E21)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPasswordScreen(navController: NavController) {
    var emailOrPhone by remember { mutableStateOf("") }
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {

                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 24.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            // Logo Facebook
            Text(
                text = "facebook",
                color = FacebookLightBlue,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            // Encabezado
            Text(
                text = "Recupera tu cuenta",
                color = FacebookDarkText,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Introduce tu correo electrónico o número de teléfono para buscar tu cuenta.",
                color = FacebookTextGray,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 8.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Campo de entrada
            OutlinedTextField(
                value = emailOrPhone,
                onValueChange = { emailOrPhone = it },
                placeholder = { Text("Correo electrónico o número de teléfono", color = FacebookTextGray) },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = FacebookGray,
                    unfocusedContainerColor = FacebookGray,
                    focusedBorderColor = FacebookLightBlue,
                    unfocusedBorderColor = FacebookBorderGray
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Botón Buscar cuenta / Enviar
            Button(
                onClick = {
                    if (emailOrPhone.isNotBlank()) {
                        Toast.makeText(context, "Buscando cuenta para: $emailOrPhone", Toast.LENGTH_SHORT).show()
                        navController.popBackStack() // Simula el envío y regresa al Login
                    } else {
                        Toast.makeText(context, "Ingresa un correo o teléfono válido", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = FacebookLightBlue)
            ) {
                Text(text = "Buscar cuenta", fontSize = 16.sp, color = Color.White)
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Botón Cancelar
            TextButton(onClick = { navController.popBackStack() }) {
                Text(text = "Cancelar", color = FacebookTextGray, fontSize = 14.sp)
            }

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}