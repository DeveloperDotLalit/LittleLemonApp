package com.meta.capstoneproject.littlelemonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setContent {
                val navController = rememberNavController()
                NavigationComposable(context = applicationContext,navController = navController)
            }
        }
    }
}

