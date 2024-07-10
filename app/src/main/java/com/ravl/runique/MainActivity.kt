package com.ravl.runique

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ravl.auth.presentation.intro.IntroScreenRoot
import com.ravl.core.presentation.designsystem.RuniqueTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RuniqueTheme {
                IntroScreenRoot(onSignUpClick = {}) {
                    
                }
            }
        }
    }
}
