package com.example.vasudevkutumbhakam.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.vasudevkutumbhakam.R

@Composable
fun IncomeApp(navControl: NavHostController) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "main"
    ) {
        composable("main") { MainScreen(navController,navControl) }
        composable("salaried_kyc") { SalariedOption(navControl) }
        composable("farmer_kyc") { FarmerOption(navControl) }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController,navControl: NavHostController) {
    var selectedOption by remember { mutableStateOf("salaried_kyc") } // "video" or "aadhar"

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
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
                IncomeOptionCard(
                    title = "Salaried Income",
                    isSelected = selectedOption == "salaried_kyc",
                    onClick = { selectedOption = "salaried_kyc" },
                    modifier = Modifier.weight(1f),
                )


                // Aadhar KYC Option
                IncomeOptionCard(
                    title = "Farmer Income",
                    isSelected = selectedOption == "farmer_kyc",
                    onClick = { selectedOption = "farmer_kyc" },
                    modifier = Modifier.weight(1f),
                )
            }
        }

        item {
            Spacer(modifier = Modifier.height(24.dp))
        }

        item {
            // Content based on selection
            when (selectedOption) {
                "salaried_kyc" -> SalariedOption(navControl)
                "farmer_kyc" -> FarmerOption(navControl)
            }
        }
    }
}

@Composable
fun IncomeOptionCard(
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
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
                    modifier = Modifier
                        .weight(1f)
                        .padding(5.dp)
                )
                Row(modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Absolute.SpaceAround) {
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
fun SalariedOption(navControl: NavHostController){
    var monthlySalary by remember { mutableStateOf("") }
    val isChecked = remember { mutableStateOf(false) }


    Column(
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth().padding(10.dp)
    ) {
        Text(text = "Monthly Salary / Income",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 16.sp)

        OutlinedTextField(
            value = monthlySalary,
            onValueChange = { monthlySalary = it },
            placeholder = { Text("Monthly Income") },
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

        Spacer(modifier = Modifier.fillMaxWidth().height(80.dp))

        Row {
            Checkbox(checked = isChecked.value, onCheckedChange = { isChecked.value = it })
            Text("I declare that my monthly household income is more than Rs. 15000, and my borrowing under the present facility does not qualify to be treated as a microfinance loan",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 12.sp)
        }

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = {
                navControl.navigate(VasuadevAppScreen.IdProof.name)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                Color(0xff636AE8)
            ),
            enabled = isChecked.value
        ) {
            Text(text = "Next", fontSize = 16.sp)
        }
        Spacer(modifier = Modifier.height(80.dp))
    }
}

@Composable
fun FarmerOption(navControl: NavHostController){
    var monthlySalary by remember { mutableStateOf("") }
    var crop_type by remember { mutableStateOf("") }
    var total_area by remember { mutableStateOf("") }
    val isChecked = remember { mutableStateOf(false) }


    Column(
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth().padding(10.dp)
    ) {
        Text(text = "Monthly Salary / Income",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 16.sp)

        OutlinedTextField(
            value = monthlySalary,
            onValueChange = { monthlySalary = it },
            placeholder = { Text("Monthly Income") },
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
        Text(text = "Type of Crop",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 16.sp)

        OutlinedTextField(
            value = crop_type,
            onValueChange = { crop_type = it },
            placeholder = { Text("Crop Type") },
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
        Text(text = "Total Area",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 16.sp)

        OutlinedTextField(
            value =total_area,
            onValueChange = { total_area = it },
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

        Spacer(modifier = Modifier.fillMaxWidth().height(80.dp))

        Row {
            Checkbox(checked = isChecked.value, onCheckedChange = { isChecked.value = it })
            Text("I declare that my monthly household income is more than Rs. 15000, and my borrowing under the present facility does not qualify to be treated as a microfinance loan",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 12.sp)
        }

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = {
                navControl.navigate(VasuadevAppScreen.IdProof.name)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                Color(0xff636AE8)
            ),
            enabled = isChecked.value
        ) {
            Text(text = "Next", fontSize = 16.sp)
        }
        Spacer(modifier = Modifier.height(80.dp))
    }
}


