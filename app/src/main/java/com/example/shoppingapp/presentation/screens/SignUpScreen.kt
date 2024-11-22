package com.example.shoppingapp.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.shoppingapp.R
import com.example.shoppingapp.domain.model.UserModel
import com.example.shoppingapp.presentation.navigation.LoginRoute
import com.example.shoppingapp.presentation.view_model.ShoppingAppViewModel

@Composable
fun SignUpScreen(navController: NavHostController, viewModel: ShoppingAppViewModel) {

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var createPass by remember { mutableStateOf("") }
    var confirmPass by remember { mutableStateOf("") }

    var registrationComplete by remember { mutableStateOf(false) }
    val context = LocalContext.current

    val state = viewModel.signUpState.collectAsStateWithLifecycle()

    CompleteSignUpBox(
        isOpen = registrationComplete,
        onDismissRequest = { registrationComplete = false })

    Box(modifier = Modifier.fillMaxSize()) {

        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
        ) {
            // Calculate responsive circle size based on screen width
            val screenWidth = maxWidth
            val screenHeight = maxHeight

            // Circle sizes as a percentage of the screen width
            val firstCircleSize = screenWidth * 0.6f // 30% of the screen width
            val secondCircleSize = screenWidth * 0.35f // 20% of the screen width

            // First Circle (Top-Right)
            Box(
                modifier = Modifier
                    .size(firstCircleSize) // Responsive size
                    .align(Alignment.TopEnd) // Align to the top-right corner
                    .offset(
                        x = screenWidth * 0.1f, // Adjust x-offset dynamically (10% of screen width)
                        y = -screenHeight * 0.1f // Adjust y-offset dynamically (-10% of screen height)
                    )
                    .background(
                        color = Color(0xFFF68B8B),
                        shape = CircleShape
                    )
            )

            // Second Circle (Bottom-Left)
            Box(
                modifier = Modifier
                    .size(secondCircleSize) // Responsive size
                    .align(Alignment.BottomStart) // Align to the bottom-left corner
                    .offset(
                        x = -screenWidth * 0.05f, // Adjust x-offset dynamically (-5% of screen width)
                        y = screenHeight * 0.05f // Adjust y-offset dynamically (5% of screen height)
                    )
                    .background(
                        color = Color(0xFFF68B8B),
                        shape = CircleShape
                    )
            )
        }


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "SignUp", fontSize = 30.sp, fontWeight = FontWeight.ExtraBold)

            Spacer(modifier = Modifier.height(35.dp))

            //Name
            Row(modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = firstName,
                    onValueChange = { firstName = it },
                    modifier = Modifier.weight(1f),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF8C8585),
                        unfocusedBorderColor = Color(0xFF8C8585)
                    ),
                    shape = RoundedCornerShape(15.dp),
                    placeholder = {
                        Text(text = "First Name", color = Color(0xFF8C8585))
                    },
                    singleLine = true
                )
                Spacer(modifier = Modifier.width(18.dp))

                OutlinedTextField(
                    value = lastName,
                    onValueChange = { lastName = it },
                    modifier = Modifier.weight(1f),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF8C8585),
                        unfocusedBorderColor = Color(0xFF8C8585)
                    ),
                    shape = RoundedCornerShape(15.dp),
                    placeholder = {
                        Text(text = "Last Name", color = Color(0xFF8C8585))
                    },
                    singleLine = true
                )


            }

            Spacer(modifier = Modifier.height(18.dp))

            //Email
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF8C8585),
                    unfocusedBorderColor = Color(0xFF8C8585)
                ),
                shape = RoundedCornerShape(15.dp),
                placeholder = {
                    Text(text = "Email", color = Color(0xFF8C8585))
                },
                singleLine = true
            )

            //Create Pass
            Spacer(modifier = Modifier.height(18.dp))

            OutlinedTextField(
                value = createPass,
                onValueChange = { createPass = it },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF8C8585),
                    unfocusedBorderColor = Color(0xFF8C8585)
                ),
                shape = RoundedCornerShape(15.dp),
                placeholder = {
                    Text(text = "Create Password", color = Color(0xFF8C8585))
                },
                singleLine = true
            )

            Spacer(modifier = Modifier.height(18.dp))

            //Confirm Password
            OutlinedTextField(
                value = confirmPass,
                onValueChange = { confirmPass = it },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF8C8585),
                    unfocusedBorderColor = Color(0xFF8C8585)
                ),
                shape = RoundedCornerShape(15.dp),
                placeholder = {
                    Text(text = "Confirm Password", color = Color(0xFF8C8585))
                },
                singleLine = true,
            )

            Spacer(modifier = Modifier.height(22.dp))

            Button(
                onClick = {
                    if (firstName.isNotEmpty() && lastName.isNotEmpty() && email.isNotEmpty() && createPass.isNotEmpty()) {
                        viewModel.createUser(
                            UserModel(
                                name = firstName + lastName,
                                email = email,
                                password = createPass,
                            )
                        )
                    }
                    else{
                        Toast.makeText(context, "Fill All Details", Toast.LENGTH_SHORT)
                            .show()
                    }


                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF68B8B)
                )
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Signup", fontSize = 18.sp)
                    if (state.value.isLoading) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(23.dp),
                            color = Color.White,
                            strokeWidth = 2.dp
                        )
                    }
                    if (state.value.isSuccess.isNotEmpty()) {
                        registrationComplete = true
                        viewModel.resetIsSuccess()
                        firstName = ""
                        lastName = ""
                        email = ""
                        createPass = ""
                        confirmPass = ""
                    }
                    else if (state.value.error.isNotEmpty()){
                        Toast.makeText(context, "Account Creation Failed", Toast.LENGTH_SHORT)
                            .show()
                        viewModel.resetError()
                    }

                }
            }



            Spacer(modifier = Modifier.height(25.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Already Have an account?", fontSize = 18.sp, color = Color(0xFFF68B8B))
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "Login",
                    modifier = Modifier.clickable { navController.navigate(LoginRoute) },
                    fontSize = 18.sp,
                    color = Color(0xFFF68B8B),
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(25.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                HorizontalDivider(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 40.dp),
                    thickness = 1.dp,
                    color = Color(
                        0xFF2B2A2A
                    )
                )
                Text(text = "OR")
                HorizontalDivider(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 40.dp),
                    thickness = 1.dp,
                    color = Color(
                        0xFF2B2A2A
                    )
                )

            }

            Spacer(modifier = Modifier.height(30.dp))

            //Facebook Button
            OutlinedButton(onClick = { /*TODO*/ }, shape = RoundedCornerShape(15.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.facebook),
                        contentDescription = null,
                        modifier = Modifier.size(28.dp)
                    )
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Log in with Facebook",
                        color = Color(0xFF8C8585),
                        textAlign = TextAlign.Center
                    )
                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            //Facebook Button
            OutlinedButton(onClick = { /*TODO*/ }, shape = RoundedCornerShape(15.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = null,
                        modifier = Modifier.size(28.dp)
                    )

                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Log in with Facebook",
                        color = Color(0xFF8C8585),
                        textAlign = TextAlign.Center
                    )
                }
            }

        }
    }

}
