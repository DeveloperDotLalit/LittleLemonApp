package com.meta.capstoneproject.littlelemonapp

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.meta.capstoneproject.littlelemonapp.compsables.DishSummary
import com.meta.capstoneproject.littlelemonapp.compsables.Home
import com.meta.capstoneproject.littlelemonapp.compsables.Onboarding
import com.meta.capstoneproject.littlelemonapp.compsables.Profile

@Composable
fun NavigationComposable(context: Context, navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = determineStartDestination(context)
    ) {
        composable(Home.route) {
            Home(navController)
        }
        composable(Profile.route) {
            Profile(navController)
        }
        composable(Onboarding.route) {
            Onboarding(navController)
        }
        composable(DishSummary.route) {
            DishSummary(navController)
        }
    }
}

private fun determineStartDestination(context: Context): String {
    val sharedPreferences = context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
    return if (sharedPreferences.getBoolean("userRegistered", false)) {
        Home.route
    } else {
        Onboarding.route
    }
}