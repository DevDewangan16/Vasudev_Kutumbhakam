package com.example.vasudevkutumbhakam.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vasudevkutumbhakam.R

data class ProfileMenuItem(
    val title: String,
    val icon: ImageVector,
    val onClick: () -> Unit = {}
)

@Composable
fun ProfileScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {

        // Profile Section
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Profile Image with verification badge
                Box {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background), // You'll need to add this image
                        contentDescription = "Profile Picture",
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                    // Verification badge
                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .clip(CircleShape)
                            .background(Color(0xff636AE8))
                            .align(Alignment.BottomEnd),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Verified",
                            tint = Color.White,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Name
                Text(
                    text = "Rohan Gaikwad",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(4.dp))

                // Phone number
                Text(
                    text = "+91 1234567890",
                    fontSize = 14.sp,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(2.dp))

                // Email
                Text(
                    text = "rohangaikwad@gmail.com",
                    fontSize = 14.sp,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Invite & Earn Button
                Button(
                    onClick = { /* Handle invite & earn */ },
                    modifier = Modifier
                        .width(200.dp)
                        .height(40.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xff636AE8)
                    ),
                ) {
                    Text(
                        text = "Invite & Earn upto 250",
                        color = Color.White,
                        fontSize = 14.sp
                    )
                }
            }
        }

        // Menu Items
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
            ) {
                Column {
                    val menuItems = listOf(
                        ProfileMenuItem("Manage Account", Icons.Default.Person),
                        ProfileMenuItem("Bank Account", Icons.Default.Home),
                        ProfileMenuItem("About Us", Icons.Default.Info),
                        ProfileMenuItem("Help Centre", Icons.Default.Info),
                        ProfileMenuItem("Terms and conditions", Icons.Default.AccountBox),
                        ProfileMenuItem("Privacy Policy", Icons.Default.CheckCircle),
                        ProfileMenuItem("Rate App", Icons.Default.Star),
                        ProfileMenuItem("Log Out", Icons.Default.ExitToApp)
                    )

                    menuItems.forEachIndexed { index, item ->
                        ProfileMenuRow(
                            item = item,
                            showDivider = index < menuItems.size - 1
                        )
                    }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
        // Share and Earn Reward Card
        item{
            Image(painter = painterResource(id = R.drawable.share_earn_banner), contentDescription = "Share and Earn Banner." ,
                modifier = Modifier.fillMaxWidth().height(98.dp).padding(5.dp))
        }

        // Add some bottom spacing for the navigation bar
        item {
            Spacer(modifier = Modifier.height(100.dp))
        }
    }
}

@Composable
fun ProfileMenuRow(
    item: ProfileMenuItem,
    showDivider: Boolean = true
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { item.onClick() }
                .padding(horizontal = 16.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = item.title,
                    tint = Color.Gray,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = item.title,
                    fontSize = 16.sp,
                    color = Color.Black
                )
            }

            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "Navigate",
                tint = Color.Gray,
                modifier = Modifier.size(20.dp)
            )
        }

        if (showDivider) {
            Divider(
                modifier = Modifier.padding(horizontal = 16.dp),
                color = Color(0xFFE0E0E0),
                thickness = 0.5.dp
            )
        }
    }
}