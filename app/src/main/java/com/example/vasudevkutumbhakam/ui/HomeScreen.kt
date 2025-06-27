package com.example.vasudevkutumbhakam.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vasudevkutumbhakam.R

@Composable
fun HomeScreen(){
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        item {
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(20.dp))
        }
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(painter = painterResource(id = R.drawable.logo), contentDescription ="Logo",
                    modifier = Modifier
                        .height(30.dp)
                        .width(110.dp))
                Icon(imageVector = Icons.Default.Notifications, contentDescription ="Notificagtion Bell" )
            }
        }
        item {
            Card (
                elevation = CardDefaults.cardElevation(2.dp),
                modifier = Modifier
                    .height(175.dp)
                    .width(350.dp)
                , colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ){
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Column(
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Total Credit Limit",
                                fontSize = 12.sp,
                                color = Color(0xff4B4B4B)

                            )
                            Text(
                                text = "₹5,000 - ₹90,000",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold)
                        }
                        Image(painter = painterResource(id = R.drawable.logo1), contentDescription = "",
                            modifier = Modifier
                                .height(21.dp)
                                .width(24.dp))
                    }

                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Column(
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Available Credit Limit",
                                fontSize = 12.sp,
                                color = Color(0xff4B4B4B)

                            )
                            Text(
                                text = "₹0,000",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold)
                        }
                        Card(modifier = Modifier.padding(2.dp)
                            .height(25.dp)
                            .width(75.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xff636AE8)
                            )
                            ) {
                            Text(text = "Get Loan",
                                fontSize = 16.sp,
                                color = Color.White,
                                )
                        }
                    }
                }
            }
        }
    }
}