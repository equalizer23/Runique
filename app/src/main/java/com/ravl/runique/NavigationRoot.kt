package com.ravl.runique

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ravl.auth.presentation.intro.IntroScreenRoot
import com.ravl.auth.presentation.login.LoginScreenRoot
import com.ravl.auth.presentation.register.RegisterScreenRot

@Composable
fun NavigationRoot(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = "auth"
    ){
        authGraph(navController)
        runGraph(navController)
    }
}

private fun NavGraphBuilder.authGraph(navController: NavHostController){
    navigation(
       startDestination = "intro",
        route = "auth"
    ){
        composable("intro"){
            IntroScreenRoot(
                onSignUpClick = { navController.navigate("register") },
                onSignInClick = { navController.navigate("login") }
            )
        }

        composable("register"){
            RegisterScreenRot(
                onSignInClick = {
                    navController.navigate("login"){
                        popUpTo("register"){
                            inclusive = true
                            saveState = true
                        }
                        restoreState = true
                    }
                },
                onSuccessfulRegistration = {
                    navController.navigate("login")
                }
            )
        }
        
        composable("login"){
            LoginScreenRoot(onLoginSuccess = {
                navController.navigate("run"){
                    popUpTo("auth"){
                        inclusive = true
                    }
                }
            }, onSignUpClick = {
                navController.navigate("register"){
                    popUpTo("login"){
                        inclusive = true
                        saveState = true
                    }
                    restoreState = true
                }
            })
        }
    }
}

private fun NavGraphBuilder.runGraph(navController: NavHostController){
    navigation(
        startDestination = "run_overview",
        route = "run"
    ) {
        composable("run_overview") {
            Text("Run overview")
        }

    }
}