package com.example.vasudevkutumbhakam.ui

import android.content.ClipData.Item
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun UserDetailsScreen(navController:NavHostController) {
    var fullName by remember { mutableStateOf("") }
    var fatherName by remember { mutableStateOf("") }
    var dob by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var pincode by remember { mutableStateOf("") }
    var state by remember { mutableStateOf("") }
    var district by remember { mutableStateOf("") }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(5.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        item { 
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(16.dp))
        }
        item {
            Text(text = "Full Name",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 16.sp)

            OutlinedTextField(
                value = fullName,
                onValueChange = { fullName = it },
                placeholder = { Text("Full Name") },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xffF9F9FE),
                    focusedContainerColor = Color(0xffF9F9FE),
                    focusedBorderColor = Color(0xffF6F6F6),
                    unfocusedBorderColor = Color(0xffF6F6F6),
                    focusedLabelColor = Color(0xff565656),
                    unfocusedLabelColor = Color(0xff565656)
                )
            )
        }
        item {
            Text(text = "Father's Name",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 16.sp)

            OutlinedTextField(
                value = fatherName,
                onValueChange = { fatherName = it },
                placeholder = { Text("Enter Father's Name") },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xffF9F9FE),
                    focusedContainerColor = Color(0xffF9F9FE),
                    focusedBorderColor = Color(0xffF6F6F6),
                    unfocusedBorderColor = Color(0xffF6F6F6),
                    focusedLabelColor = Color(0xff565656),
                    unfocusedLabelColor = Color(0xff565656)
                )
            )
        }
        item {
            Text(text = "Date of Birth",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 16.sp)

            OutlinedTextField(
                value = dob,
                onValueChange = { dob = it },
                placeholder = { Text("00/00/0000") },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xffF9F9FE),
                    focusedContainerColor = Color(0xffF9F9FE),
                    focusedBorderColor = Color(0xffF6F6F6),
                    unfocusedBorderColor = Color(0xffF6F6F6),
                    focusedLabelColor = Color(0xff565656),
                    unfocusedLabelColor = Color(0xff565656)
                )
            )
            Text("You must be 18 years or older to register.", color = Color(0xff636AE8), fontSize = 12.sp)
        }
        item {
            Text(text = "Gender",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 16.sp)

            OutlinedTextField(
                value = gender,
                onValueChange = { gender = it },
                placeholder = { Text("Gender") },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xffF9F9FE),
                    focusedContainerColor = Color(0xffF9F9FE),
                    focusedBorderColor = Color(0xffF6F6F6),
                    unfocusedBorderColor = Color(0xffF6F6F6),
                    focusedLabelColor = Color(0xff565656),
                    unfocusedLabelColor = Color(0xff565656)
                )
            )
        }
        item {

            Text(text = "Address",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 16.sp)

            OutlinedTextField(
                value = address,
                onValueChange = { address = it },
                placeholder = { Text("Text Area") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xffF9F9FE),
                    focusedContainerColor = Color(0xffF9F9FE),
                    focusedBorderColor = Color(0xffF6F6F6),
                    unfocusedBorderColor = Color(0xffF6F6F6),
                    focusedLabelColor = Color(0xff565656),
                    unfocusedLabelColor = Color(0xff565656)
                )
            )
            Text("350 to 400 characters", color =Color(0xff636AE8), fontSize = 12.sp)

            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Pin Code",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 16.sp)

            OutlinedTextField(
                value = pincode,
                onValueChange = { pincode = it },
                placeholder = { Text("Pincode") },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xffF9F9FE),
                    focusedContainerColor = Color(0xffF9F9FE),
                    focusedBorderColor = Color(0xffF6F6F6),
                    unfocusedBorderColor = Color(0xffF6F6F6),
                    focusedLabelColor = Color(0xff565656),
                    unfocusedLabelColor = Color(0xff565656)
                )
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "State / District",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 16.sp)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                OutlinedTextField(
                    value = state,
                    onValueChange = { state = it },
                    placeholder = { Text("State") },
                    modifier = Modifier.weight(1f),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedContainerColor = Color(0xffF9F9FE),
                        focusedContainerColor = Color(0xffF9F9FE),
                        focusedBorderColor = Color(0xffF6F6F6),
                        unfocusedBorderColor = Color(0xffF6F6F6),
                        focusedLabelColor = Color(0xff565656),
                        unfocusedLabelColor = Color(0xff565656)
                    )
                )
                OutlinedTextField(
                    value = district,
                    onValueChange = { district = it },
                    placeholder = { Text("District") },
                    modifier = Modifier.weight(1f),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedContainerColor = Color(0xffF9F9FE),
                        focusedContainerColor = Color(0xffF9F9FE),
                        focusedBorderColor = Color(0xffF6F6F6),
                        unfocusedBorderColor = Color(0xffF6F6F6),
                        focusedLabelColor = Color(0xff565656),
                        unfocusedLabelColor = Color(0xff565656)
                    )
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            Button(
                onClick = {
                    navController.navigate(VasuadevAppScreen.IdProof.name)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    Color(0xff636AE8)
                )
            ) {
                Text(text = "Next", fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.height(80.dp))
        }
    }
}
