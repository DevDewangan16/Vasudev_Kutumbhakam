package com.example.vasudevkutumbhakam.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.vasudevkutumbhakam.R

@Composable
fun SubmissionScreen(){
    Column (
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(10.dp)
    ){
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(16.dp))

        Box(modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopStart) {
            Image(
                painter = painterResource(id = R.drawable.logo), contentDescription = "Logo",
                modifier = Modifier
                    .height(30.dp)
                    .width(110.dp)
            )
        }

        Image(painter = painterResource(id = R.drawable.submission_banner), contentDescription = "",
            modifier = Modifier
                .height(358.dp)
                .width(315.dp))

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(30.dp))

        Image(
            painter = painterResource(id = R.drawable.timer), contentDescription ="",
            modifier = Modifier.size(150.dp)
        )
    }
}