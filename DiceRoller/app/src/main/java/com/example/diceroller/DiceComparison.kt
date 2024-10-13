package com.example.diceroller

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DiceComparison(navController: NavController, current: Int, previous: Int, modifier: Modifier = Modifier) {
    val currentImageResource = when (current) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    val previousImageResource = when (previous) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Current Roll:")
        Image(
            painter = painterResource(currentImageResource),
            contentDescription = "Current roll: $current"
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text("Previous Roll:")
        Image(
            painter = painterResource(previousImageResource),
            contentDescription = "Previous roll: $previous"
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate(Screens.Roll.route) }) {
            Text(stringResource(R.string.back))
        }
    }
}


