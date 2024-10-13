package com.example.diceroller

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import java.security.AccessController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.diceroller.DiceResult
import com.example.diceroller.DiceWithButtonAndImage


@Composable
fun NavGraph (navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.Roll.route
    ) {
        composable(route = Screens.Roll.route) {
            DiceWithButtonAndImage(navController = navController)
        }
        composable(route = Screens.DiceResult.route + "?result={result}") {
            navBackStack ->
            var resultShow: Int = navBackStack.arguments?.getString("result")?.toIntOrNull()?:1
            DiceResult(navController = navController, resultShow = resultShow)
        }
        composable(route = Screens.BusinessCard.route) {
            BusinessCard(navController = navController)
        }
        composable(route = Screens.DiceComparison.route + "?current={current}&previous={previous}") { navBackStack ->
            val current = navBackStack.arguments?.getString("current")?.toIntOrNull() ?: 1
            val previous = navBackStack.arguments?.getString("previous")?.toIntOrNull() ?: 1
            DiceComparison(navController = navController, current = current, previous = previous)
        }
    }
}