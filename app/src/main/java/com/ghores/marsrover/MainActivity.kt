package com.ghores.marsrover

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ghores.marsrover.navigation.SetupNavGraph
import com.ghores.marsrover.ui.theme.MarsRoversTheme
import com.ghores.marsrover.ui.view.Rover
import com.ghores.marsrover.ui.view.RoverList

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarsRoversTheme {

                navController = rememberNavController()

                SetupNavGraph(navController = navController)
            }
        }
    }
}
