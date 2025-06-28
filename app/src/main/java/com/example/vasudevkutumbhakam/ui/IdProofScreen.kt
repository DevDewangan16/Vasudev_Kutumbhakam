package com.example.vasudevkutumbhakam.ui

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.vasudevkutumbhakam.R

@Composable
fun IDProofScreen(navController: NavHostController) {
    val idProofNumber = remember { mutableStateOf("") }
    val frontImage = remember { mutableStateOf<Uri?>(null) }
    val backImage = remember { mutableStateOf<Uri?>(null) }
    val isChecked = remember { mutableStateOf(false) }

    val launcherFront = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri -> frontImage.value = uri }
    val launcherBack = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri -> backImage.value = uri }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(5.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(16.dp))
        }
        item {
            Text(text = "ID Proof Number",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 16.sp)

            OutlinedTextField(
                value = idProofNumber.value,
                onValueChange = { idProofNumber.value = it },
                placeholder = { Text("Aadhaar / PAN") },
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
            Card(modifier = Modifier.fillMaxWidth(), elevation = CardDefaults.cardElevation(4.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xffF4F4F4)
                )) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Upload Your Aadhaar Card",
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center
                        )
                    Spacer(Modifier.height(8.dp))

                    Text("Front",
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 16.sp)
                    Box(modifier = Modifier
                        .height(170.dp)
                        .fillMaxWidth()) {
                        if (frontImage.value == null) {
                            Image(painter = painterResource(id = R.drawable.front_proof), contentDescription ="", contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize() )
                            IconButton(onClick = { launcherFront.launch("image/*") }) {
                                Image(painter = painterResource(id = R.drawable.ic_upload), contentDescription = "",
                                    modifier = Modifier.size(44.dp),)
                            }
                        } else {
                            Image(painter = rememberAsyncImagePainter(frontImage.value), contentDescription = null, contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize())
                            IconButton(onClick = { frontImage.value = null }) {
                                Image(painter = painterResource(id = R.drawable.ic_delete), contentDescription = "",
                                    modifier = Modifier.size(44.dp))
                            }
                        }
                    }

                    Spacer(Modifier.height(8.dp))

                    Text("Back",
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 16.sp)
                    Box(modifier = Modifier
                        .height(170.dp)
                        .fillMaxWidth()) {
                        if (backImage.value == null) {
                            Image(painter = painterResource(id = R.drawable.back_proof), contentDescription ="", contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize() )
                            IconButton(onClick = { launcherBack.launch("image/*") }) {
                                Image(painter = painterResource(id = R.drawable.ic_upload), contentDescription = "",
                                    modifier = Modifier.size(44.dp))
                            }
                        } else {
                            Image(painter = rememberAsyncImagePainter(backImage.value), contentDescription = null, contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize())
                            IconButton(onClick = { backImage.value = null }) {
                                Image(painter = painterResource(id = R.drawable.ic_delete), contentDescription = "",
                                    modifier = Modifier.size(44.dp))
                            }
                        }
                    }
                }
            }
        }
        item {
            Row {
                Checkbox(checked = isChecked.value, onCheckedChange = { isChecked.value = it })
                Text("I hereby declare that the ID proof submitted by me is valid, belongs to me, and I authorize Vasudev Kutumbhakam to use this document for identity verification and KYC purposes, as per applicable regulations.",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 12.sp)
            }

            Spacer(Modifier.height(16.dp))

            Button(
                onClick = {
                    navController.navigate(VasuadevAppScreen.Kyc.name)
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