package com.example.vasudevkutumbhakam.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.vasudevkutumbhakam.R
import java.lang.reflect.Modifier

enum class VasuadevAppScreen(val title :String){
    Home("Home"),
    Earn("Play & Earn"),
    Loans("Loan"),
    Assist("Assist"),
    Profile("Profile"),
    User("User"),
    IdProof("ID Proof")
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun VasuadevApp(appViewModel: AppViewModel= viewModel(),
        navController: NavHostController = rememberNavController()) {

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen =VasuadevAppScreen.valueOf(
        backStackEntry?.destination?.route?:VasuadevAppScreen.Home.name
    )

    Scaffold(bottomBar = {
        BottomAppBar(navController = navController, currentScreen =currentScreen )

    }) {
        NavHost(navController = navController, startDestination =VasuadevAppScreen.Home.name ) {
            composable(route = VasuadevAppScreen.Home.name){
                HomeScreen()
            }

            composable(route = VasuadevAppScreen.Profile.name){
                ProfileScreen()
            }

            composable(route = VasuadevAppScreen.Loans.name){
                LoanStepsScreen(navController)
            }

            composable(route=VasuadevAppScreen.User.name){
                UserDetailsScreen(navController)
            }

            composable(route = VasuadevAppScreen.IdProof.name){
                IDProofScreen()
            }
        }
    }
}

@Composable
fun BottomAppBar(navController: NavHostController,
                 currentScreen: VasuadevAppScreen){
    Row (horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = androidx.compose.ui.Modifier
            .fillMaxWidth()
            .height(95.dp)
            .padding(10.dp)
            .background(
                color = Color.White
            )){

        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
            ,    modifier = androidx.compose.ui.Modifier.clickable {
                navController.navigate(VasuadevAppScreen.Home.name) {
                    popUpTo(0)
                }
            }) {
            Icon(imageVector = Icons.Outlined.Home, contentDescription ="Home" )
            Text(text = "Home", fontSize = 10.sp)
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
            ,    modifier = androidx.compose.ui.Modifier.clickable {
                navController.navigate(VasuadevAppScreen.Home.name) {
                    popUpTo(0)
                }
            }) {
            Image(painter = painterResource(id = R.drawable.earn), contentDescription ="" ,
                modifier = androidx.compose.ui.Modifier.size(24.dp))
            Text(text = "Play & Earn", fontSize = 10.sp)
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
            ,    modifier = androidx.compose.ui.Modifier.clickable {
                navController.navigate(VasuadevAppScreen.Loans.name) {
                    popUpTo(0)
                }
            }) {
            Image(painter = painterResource(id = R.drawable.loan), contentDescription = "",
                modifier = androidx.compose.ui.Modifier.size(24.dp))
            Text(text = "Loans", fontSize = 10.sp)
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
            ,    modifier = androidx.compose.ui.Modifier.clickable {
                navController.navigate(VasuadevAppScreen.Home.name) {
                    popUpTo(0)
                }
            }) {
            Image(painter = painterResource(id = R.drawable.assist), contentDescription ="" ,
                modifier = androidx.compose.ui.Modifier.size(24.dp))
            Text(text = "Assist", fontSize = 10.sp)
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
            ,    modifier = androidx.compose.ui.Modifier.clickable {
                navController.navigate(VasuadevAppScreen.Profile.name) {
                    popUpTo(0)
                }
            }) {
            Icon(imageVector = Icons.Outlined.AccountCircle, contentDescription ="Home" )
            Text(text = "Profile", fontSize = 10.sp)
        }
    }
}