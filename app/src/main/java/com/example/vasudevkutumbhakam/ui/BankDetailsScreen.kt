package com.example.vasudevkutumbhakam.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun BankDetailsScreen(navController: NavHostController) {
    var accountholdername by remember { mutableStateOf("") }
    var bankName by remember { mutableStateOf("") }
    var accountNumber by remember { mutableStateOf("") }
    var confirmAccount by remember { mutableStateOf("") }
    var ifsc by remember { mutableStateOf("") }


    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(5.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(11.dp)
    ) {
        item {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(16.dp)
            )
        }
        item {
            Text(
                text = "Account Holder Name",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 16.sp
            )

            OutlinedTextField(
                value = accountholdername,
                onValueChange = { accountholdername = it },
                placeholder = { Text("Enter Holder Name") },
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
            Text(
                text = "Bank Name",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 16.sp
            )

            OutlinedTextField(
                value = bankName,
                onValueChange = { bankName = it },
                placeholder = { Text("Enter Bank Name") },
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
            Text(
                text = "Account Number",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 16.sp
            )

            OutlinedTextField(
                value = accountNumber,
                onValueChange = { accountNumber = it },
                placeholder = { Text("Enter Account Number") },
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
            Text(
                text = "Confirm Account Number",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 16.sp
            )

            OutlinedTextField(
                value = confirmAccount,
                onValueChange = { confirmAccount = it },
                placeholder = { Text("Confirm Account Number") },
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
            Text(
                text = "IFSC Code",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 16.sp
            )

            OutlinedTextField(
                value = ifsc,
                onValueChange = { ifsc = it },
                placeholder = { Text("000000") },
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
            Spacer(modifier = Modifier.fillMaxWidth().height(150.dp))
        }
        item {
            Button(
                onClick = {
                    navController.navigate(VasuadevAppScreen.Submission.name)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    Color(0xff636AE8)
                ),
                enabled = accountholdername.isNotBlank() && bankName.isNotBlank() && accountNumber.isNotBlank() && confirmAccount.isNotBlank() && ifsc.isNotBlank()
            ) {
                Text(text = "Submit Application", fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.height(80.dp))
        }
    }
}