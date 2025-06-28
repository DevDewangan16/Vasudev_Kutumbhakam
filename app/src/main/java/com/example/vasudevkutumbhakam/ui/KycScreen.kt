package com.example.vasudevkutumbhakam.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.vasudevkutumbhakam.R

// Define color scheme
object KYCColors {
    val Purple = Color(0xFF6366F1)
    val LightGray = Color(0xFFF8F9FA)
    val DarkGray = Color(0xFF374151)
    val White = Color.White
    val Teal = Color(0xFF10B981)
    val LightBlue = Color(0xFFE0E7FF)
}


@Composable
fun KYCApp(navControl:NavHostController) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "main"
    ) {
        composable("main") { MainKYCScreen(navController) }
        composable("video_kyc_guide") { VideoKYCGuideScreen(navController) }
        composable("video_call") { VideoCallScreen(navControl) }
        composable("aadhar_details") { AadharDetailsScreen(navController) }
        composable("verify_otp") { VerifyOTPScreen(navControl) }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainKYCScreen(navController: NavController) {
    var selectedOption by remember { mutableStateOf("video") } // "video" or "aadhar"

    LazyColumn(
        modifier = Modifier
            .fillMaxSize().padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            // Option selection
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Video KYC Option
                KYCOptionCard(
                    title = "Video KYC",
                    isSelected = selectedOption == "video",
                    onClick = { selectedOption = "video" },
                    modifier = Modifier.weight(1f),
                    imageRes = R.drawable.ic_video_kyc
                )


                // Aadhar KYC Option
                KYCOptionCard(
                    title = "Aadhar KYC",
                    isSelected = selectedOption == "aadhar",
                    onClick = { selectedOption = "aadhar" },
                    modifier = Modifier.weight(1f),
                    imageRes = R.drawable.ic_aadhar_kyc
                )
            }
        }

        item {
            Spacer(modifier = Modifier.height(24.dp))
        }

        item {
            // Content based on selection
            when (selectedOption) {
                "video" -> VideoKYCContent(navController)
                "aadhar" -> AadharKYCContent(navController)
            }
        }
    }
}

@Composable
fun KYCOptionCard(
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    imageRes:Int
) {
    Card(
        modifier = modifier
            .height(60.dp)
            .clickable(enabled = isEnabled) { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) KYCColors.Purple else KYCColors.White
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Column() {
                Text(
                    text = title,
                    fontSize = 16.sp,
                    color = if (isSelected) KYCColors.White else KYCColors.DarkGray,
                    fontWeight = if (isSelected) FontWeight.Medium else FontWeight.Normal,
                    modifier = Modifier.weight(1f).padding(5.dp)
                )
                Row(modifier = Modifier.weight(1f).fillMaxWidth(),
                    horizontalArrangement = Arrangement.Absolute.SpaceAround) {

                    Image(painter = painterResource(id = imageRes), contentDescription = "",
                        modifier=Modifier.size(24.dp))
                    // Toggle indicator
                    Switch(
                        checked = isSelected,
                        onCheckedChange = if (isEnabled) { { onClick() } } else { {} },
                        modifier = Modifier.size(16.dp),
                        enabled = isEnabled
                    )
                }
            }

        }
    }
}

@Composable
fun VideoKYCContent(navController: NavController) {
    var termsAccepted by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Text(
            text = "How to do video KYC",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = KYCColors.DarkGray,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth()
        )
        
        Image(painter = painterResource(id = R.drawable.video1), contentDescription ="",
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp))

        Spacer(modifier = Modifier.height(12.dp))

        Image(painter = painterResource(id = R.drawable.video2), contentDescription ="",
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp))

        Spacer(modifier = Modifier.height(12.dp))

        Image(painter = painterResource(id = R.drawable.video3), contentDescription ="",
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp))

        Spacer(modifier = Modifier.height(12.dp))

        Image(painter = painterResource(id = R.drawable.video4), contentDescription ="",
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp))

        Spacer(modifier = Modifier.height(24.dp))

        // Checkbox and button
        Row(
            modifier = Modifier.padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = termsAccepted,
                onCheckedChange = { termsAccepted = it }
            )
            Text(
                text = "I have read the Video KYC Terms & Conditions and provide my consent to the same.",
                fontSize = 12.sp,
                color = KYCColors.DarkGray,
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        Button(
            onClick = { navController.navigate("video_call") },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = KYCColors.Purple),
            enabled = termsAccepted
        ) {
            Text(
                text = "Start Video Call",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Spacer(modifier = Modifier.height(80.dp))
    }
}


@Composable
fun AadharKYCContent(navController: NavController) {
    var aadharNumber by remember { mutableStateOf("") }
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var consent1 by remember { mutableStateOf(false) }
    var consent2 by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Aadhar card Card Details",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = KYCColors.DarkGray,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Aadhar number input
        Text(
            text = "Enter your aadhar number",
            fontSize = 16.sp,
            color = KYCColors.DarkGray,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = aadharNumber,
            onValueChange = { if (it.length <= 12) aadharNumber = it },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            placeholder = { Text("Enter 12-digit Aadhar number") },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xffF9F9FE),
                focusedContainerColor = Color(0xffF9F9FE),
                focusedBorderColor = Color(0xffF6F6F6),
                unfocusedBorderColor = Color(0xffF6F6F6),
                focusedLabelColor = Color(0xff565656),
                unfocusedLabelColor = Color(0xff565656)
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        // First name
        Text(
            text = "First Name as per aadhar",
            fontSize = 16.sp,
            color = KYCColors.DarkGray,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = firstName,
            onValueChange = { firstName = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Enter First Name") },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xffF9F9FE),
                focusedContainerColor = Color(0xffF9F9FE),
                focusedBorderColor = Color(0xffF6F6F6),
                unfocusedBorderColor = Color(0xffF6F6F6),
                focusedLabelColor = Color(0xff565656),
                unfocusedLabelColor = Color(0xff565656)
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Last name
        Text(
            text = "Last Name as per aadhar",
            fontSize = 16.sp,
            color = KYCColors.DarkGray,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = lastName,
            onValueChange = { lastName = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Enter last Name") },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xffF9F9FE),
                focusedContainerColor = Color(0xffF9F9FE),
                focusedBorderColor = Color(0xffF6F6F6),
                unfocusedBorderColor = Color(0xffF6F6F6),
                focusedLabelColor = Color(0xff565656),
                unfocusedLabelColor = Color(0xff565656)
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Consent checkboxes
        Row(
            verticalAlignment = Alignment.Top
        ) {
            Checkbox(
                checked = consent1,
                onCheckedChange = { consent1 = it }
            )
            Text(
                text = "I confirm the above aadhar belongs to me. I authorize Vasudev Kutumbhakam Microfinance and its partner lenders to access my CKYCR records, perform credit assessments on my behalf, and retrieve my credit report from registered credit bureaus and financial score providers as part of their loan risk evaluation. I also agree to share these reports with other affiliated lending partners.",
                fontSize = 11.sp,
                color = KYCColors.DarkGray,
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.Top
        ) {
            Checkbox(
                checked = consent2,
                onCheckedChange = { consent2 = it }
            )
            Text(
                text = "I hereby authorize Vasudev Kutumbhakam Microfinance to fetch my GST registration details linked to the providedaadhar , if available, from the official GST portal, as part of business verification and documentation.",
                fontSize = 11.sp,
                color = KYCColors.DarkGray,
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { navController.navigate("verify_otp") },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = KYCColors.Purple),
            enabled = aadharNumber.length == 12 && firstName.isNotBlank() && lastName.isNotBlank() && consent1 && consent2
        ) {
            Text(
                text = "Send OTP",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Spacer(modifier = Modifier.height(80.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VideoCallScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(KYCColors.LightGray)
    ) {
        // Camera frame
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(600.dp)
                .padding(16.dp)
                .border(4.dp, KYCColors.Purple, RoundedCornerShape(16.dp))
                .background(Color.Gray.copy(alpha = 0.3f), RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.Center
        ) {
            // Close button
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(16.dp)
            ) {
                Icon(
                    Icons.Default.Close,
                    contentDescription = "Close",
                    tint = KYCColors.White
                )
            }

            // Agent video placeholder
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .background(KYCColors.Teal, RoundedCornerShape(8.dp))
                    .align(Alignment.TopEnd)
                    .offset(x = (-16).dp, y = 16.dp)
            ) {
                // Agent avatar placeholder
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(KYCColors.White.copy(alpha = 0.9f), RoundedCornerShape(8.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Agent", color = KYCColors.DarkGray)
                }
            }

            Text(
                text = "Person being verified",
                color = KYCColors.DarkGray,
                fontSize = 16.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        // Number display
        Text(
            text = "Read the displaying Number",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = KYCColors.DarkGray,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        Text(
            text = "586423412",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = KYCColors.DarkGray,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        // Control button
        Box(
            modifier = Modifier.clickable {
                navController.navigate(VasuadevAppScreen.Bank.name)
            }
                .size(64.dp)
                .background(KYCColors.White, CircleShape)
                .align(Alignment.CenterHorizontally),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(Color.Transparent, CircleShape)
                    .border(3.dp, KYCColors.DarkGray, CircleShape)
            )
        }

        Spacer(modifier = Modifier.height(80.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VerifyOTPScreen(navController: NavController) {
    var otp by remember { mutableStateOf("000000") }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(KYCColors.LightGray)
    ) {

        item {
            Spacer(modifier = Modifier.height(32.dp))
        }

        item {
            Column(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "Enter 6 digits OTP",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = KYCColors.DarkGray
                )

                Text(
                    text = "OTP has been sent to **** **** 1234 aadhar number",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 4.dp)
                )

                Spacer(modifier = Modifier.height(32.dp))

                // OTP Input
                OutlinedTextField(
                    value = otp,
                    onValueChange = { if (it.length <= 6) otp = it },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    textStyle = androidx.compose.ui.text.TextStyle(
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(android.R.drawable.stat_notify_sync),
                        contentDescription = "Refresh",
                        tint = KYCColors.Purple,
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = " OTP sent . Retry in 27 seconds",
                        fontSize = 14.sp,
                        color = KYCColors.Purple,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }

                Spacer(modifier = Modifier.height(48.dp))

                Button(
                    onClick = {
                        navController.navigate(VasuadevAppScreen.Bank.name)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = KYCColors.Purple)
                ) {
                    Text(
                        text = "Verify OTP",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}

@Composable
fun VideoKYCGuideScreen(navController: NavController) {
    // This would be the how-to guide screen
    // Implementation similar to VideoKYCContent but as a separate screen
}

@Composable
fun AadharDetailsScreen(navController: NavController) {
    // This would be the Aadhar details input screen
    // Implementation similar to AadharKYCContent but as a separate screen
}