package com.example.shoppingapp.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.shoppingapp.presentation.navigation.LoginRoute


@Composable
fun CompleteSignUpBox(
    isOpen: Boolean,
    onDismissRequest: () -> Unit
) {

    if (isOpen) {
        AlertDialog(
            modifier = Modifier.fillMaxHeight(0.3f),
            onDismissRequest = onDismissRequest,
            text = {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Spacer(modifier = Modifier.height(25.dp))
                    Icon(
                        imageVector = Icons.Filled.CheckCircle,
                        contentDescription = null,
                        tint = Color(0xFFF68B8B),
                        modifier = Modifier
                            .fillMaxWidth()
                            .scale(3.7f)
                            .align(Alignment.CenterHorizontally),
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                    Text(
                        text = "Success",
                        color = Color(0xFFF68B8B),
                        fontSize = 16.sp,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            },

            confirmButton = {
                Text(
                    text = "Congratulations, you have\ncompleted our registration!",
                    modifier = Modifier.fillMaxWidth(), fontSize = 14.sp, textAlign = TextAlign.Center
                )
            },
            dismissButton = {
                Button(
                    onClick = onDismissRequest,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(15.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFF68B8B)
                    )
                ) {
                    Text(text = "Done", fontSize = 16.sp)
                }
            },
            shape = RoundedCornerShape(15.dp)
        )
    }
}