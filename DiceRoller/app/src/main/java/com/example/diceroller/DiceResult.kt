package com.example.diceroller

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
fun DiceResult(navController: NavController, resultShow: Int = 1, modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(resultShow) }
    var textFieldValue by remember { mutableStateOf(result.toString()) }
    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Column (
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally ) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = result.toString()
        )

        if (result == 3) {
            Button(onClick = { result++ }) {
                Text(text = "Increment Result")
            }
        }

        if (result == 4) {
            Text(text = "Select a result screen:")

            Spacer(modifier = Modifier.height(16.dp))

            // Criar os seis botões
            for (i in 1..6) {
                Button(onClick = {
                    navController.navigate(Screens.DiceResult.route.replace("{result}", i.toString()))
                }) {
                    Text(text = "Go to screen $i")
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        if(result == 5) {
            TextField(
                value = textFieldValue,
                onValueChange = { newValue ->
                    textFieldValue = newValue
                    result = newValue.toIntOrNull() ?: result
                },
                label = { Text("Enter a new die value") },

            )

        }

        Button(onClick = { navController.navigate(Screens.Roll.route) }) {
            Text(stringResource(R.string.back))
        }
    }

}