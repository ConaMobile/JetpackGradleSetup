package com.conamobile.jetpackgradlesetup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var blurDb by remember {
                mutableStateOf(0.0)
            }
            WindowCompat.setDecorFitsSystemWindows(window, false)
            Box(modifier = Modifier
                .fillMaxSize(),
                contentAlignment = Alignment.Center) {
                Column(verticalArrangement = Arrangement.Top,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .blur(blurDb.dp)
                        .fillMaxSize()) {
                    Image(
                        painter = painterResource(id = R.drawable.image),
                        contentDescription = null,
                        alignment = Alignment.Center,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth(),
                    )
                    Text(text = "Hello Jetpack",
                        fontSize = 40.sp)

                    Spacer(modifier = Modifier
                        .height(20.dp)
                        .padding(20.dp))
                }
                Slider(value = blurDb.toFloat(), onValueChange = {
                    blurDb = it.roundToInt().toDouble()
                },
                    enabled = true,
                    valueRange = 0f..100f,
                    modifier = Modifier
                        .padding(26.dp)
                        .align(Alignment.BottomCenter))
            }
        }
    }
}