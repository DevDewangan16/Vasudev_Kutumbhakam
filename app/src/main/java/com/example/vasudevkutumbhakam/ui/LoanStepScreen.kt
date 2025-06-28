package com.example.vasudevkutumbhakam.ui
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.vasudevkutumbhakam.R

@Composable
fun LoanStepsScreen(navController: NavHostController) {
    val stepItems = listOf(
        Pair("User Details", R.drawable.user),
        Pair("Income Details", R.drawable.income),
        Pair("ID Proof", R.drawable.proof),
        Pair("KYC", R.drawable.kyc),
        Pair("Bank Details", R.drawable.bank)
    )

    LazyColumn {
        item {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp))
                Text(
                    text = "Discover your Credit and get Loan",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.loan_logo), contentDescription = "",
                        modifier = Modifier.size(100.dp)
                    )
                }

                Text(
                    text = "Complete any of the below steps which will provide us with a better understanding of who you are.",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                Text(
                    text = "The more steps you complete successfully, the better your Credit and Pricing would be.",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(bottom = 24.dp)
                )

                stepItems.forEach { (step, iconRes) ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = iconRes),
                            contentDescription = null,
                            modifier = Modifier.size(22.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = step, fontSize = 16.sp, modifier = Modifier.weight(1f))

                        Icon(
                            painter = painterResource(id = R.drawable.arrow_forward),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                    Divider()
                }
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp))
        }
    }
        item {
            Button(
                onClick = {
                    navController.navigate(VasuadevAppScreen.User.name)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    Color(0xff636AE8)
                )
            ) {
                Text(text = "Continue", fontSize = 16.sp)
            }
        }
    }
}
