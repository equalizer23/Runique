package com.ravl.runique

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.ravl.auth.presentation.intro.IntroScreenRoot
import com.ravl.auth.presentation.register.RegisterScreen
import com.ravl.auth.presentation.register.RegisterScreenRot
import com.ravl.auth.presentation.register.RegisterState
import com.ravl.core.presentation.designsystem.RuniqueTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val viewModel by viewModel<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen().apply {
            setKeepOnScreenCondition{
                viewModel.state.isCheckingAuth
            }
        }
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RuniqueTheme {
                if(!viewModel.state.isCheckingAuth){
                    val navController = rememberNavController()
                    NavigationRoot(
                        navController = navController,
                        isLoggedIn = viewModel.state.isLogged
                    )
                }
            }
        }
    }
}
