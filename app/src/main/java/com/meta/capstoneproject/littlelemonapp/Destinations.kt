package com.meta.capstoneproject.littlelemonapp

interface Destinations {
    val route: String
}

object Home : Destinations {
    override val route = "Home"
}
object Onboarding : Destinations {
    override val route = "Onboarding"
}
object Profile : Destinations {
    override val route = "Profile"
}
object DishSummary : Destinations {
    override val route = "DishSummary"
}