package me.sebastianquiroga.facebook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import me.sebastianquiroga.facebook.ui.screens.FacebookLoginScreen
import me.sebastianquiroga.facebook.ui.screens.FacebookRegisterScreen
import me.sebastianquiroga.facebook.ui.screens.FeedScreen
import me.sebastianquiroga.facebook.ui.screens.ForgotPasswordScreen
import me.sebastianquiroga.facebook.ui.theme.FacebookTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FacebookTheme {
                val myNavController = rememberNavController()

                NavHost(
                    navController = myNavController,
                    startDestination = "login",
                    modifier = Modifier.fillMaxSize()
                ) {
                    // 1. Pantalla de Login
                    composable(route = "login") {
                        FacebookLoginScreen(
                            onClickRegister = { myNavController.navigate("register") },
                            onClickiniciarSesion = { myNavController.navigate("feed") },
                            onClickForgotPassword = { myNavController.navigate("forgot_password") }
                        )
                    }

                    // 2. Pantalla de Registro
                    composable(route = "register") {
                        FacebookRegisterScreen(
                            onClickBack = { myNavController.popBackStack() }
                        )
                    }

                    // 3. Pantalla Olvidaste tu contraseña
                    composable(route = "forgot_password") {
                        ForgotPasswordScreen(navController = myNavController)
                    }

                    // 4. Pantalla del Feed
                    composable(route = "feed") {
                        FeedScreen()
                    }
                }
            }
        }
    }
}
