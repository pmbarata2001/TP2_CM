package com.example.diceroller

sealed class Screens(val route: String) {
    object Roll: Screens("roll_screen")
    object DiceResult : Screens("result_screen/{result}")
    object BusinessCard : Screens("business_card_screen")
    object DiceComparison : Screens("dice_comparison_screen?current={current}&previous={previous}")
}