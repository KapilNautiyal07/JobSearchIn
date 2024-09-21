package com.example.jobsearchin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jobsearchin.ui.theme.BlueJC
import com.example.jobsearchin.ui.theme.JobSearchinTheme
import com.example.jobsearchin.ui.theme.WhiteJC

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JobSearchinTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyBottomAppBar()


                }
            }
        }
    }
}

@Composable
fun MyBottomAppBar() {
    val navigationController = rememberNavController()
    val context = LocalContext.current.applicationContext
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }


    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = WhiteJC
            ) {
               IconButton(
                   onClick = { 
                       selected.value = Icons.Default.Home
                       navigationController.navigate(Screens.Home.screen){
                           popUpTo(0) 
                       }
                   },
                   modifier = Modifier.weight(1f)) {
                   Icon(Icons.Default.Home, contentDescription = null ,modifier =Modifier.size(26.dp)
                       , tint = if (selected.value == Icons.Default.Home) BlueJC else Color.LightGray)
               }

                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Edit
                        navigationController.navigate(Screens.All_Jobs.screen){
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)) {
                    Icon(painter = painterResource(id = R.drawable.officebag), contentDescription = null ,modifier =Modifier.size(26.dp)
                        , tint = if (selected.value == Icons.Default.Edit) BlueJC else Color.LightGray)
                }



                IconButton(
                    onClick = {
                        selected.value = Icons.Default.AddCircle
                        navigationController.navigate(Screens.My_Activity.screen){
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)) {
                    Icon(painter = painterResource(id = R.drawable.chatimg), contentDescription = null ,modifier =Modifier.size(26.dp)
                        , tint = if (selected.value == Icons.Default.AddCircle) BlueJC else Color.LightGray)
                }




                IconButton(
                    onClick = {
                        selected.value = Icons.Default.DateRange
                        navigationController.navigate(Screens.Loan.screen){
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)) {
                    Icon(painter = painterResource(id = R.drawable.rupeesign), contentDescription = null ,modifier =Modifier.size(26.dp)
                        , tint = if (selected.value == Icons.Default.DateRange) BlueJC else Color.LightGray)
                }






                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Person
                        navigationController.navigate(Screens.Profile.screen){
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)) {
                    Icon(Icons.Default.Person, contentDescription = null ,modifier =Modifier.size(26.dp)
                        , tint = if (selected.value == Icons.Default.Person) BlueJC else Color.LightGray)
                }



            }
        }
    ) { paddingValues ->
        NavHost(navController = navigationController,
            startDestination = Screens.Home.screen ,
            modifier = Modifier.padding(paddingValues)) {

            composable(Screens.Home.screen){ Home()}
            composable(Screens.All_Jobs.screen){ All_Jobs() }
            composable(Screens.My_Activity.screen){ My_Activity() }
            composable(Screens.Loan.screen){ Loan() }
            composable(Screens.Profile.screen){ Profile() }


        }

    }
}


