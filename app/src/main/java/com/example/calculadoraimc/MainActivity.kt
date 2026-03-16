package com.example.calculadoraimc

import android.media.Image
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculadoraimc.ui.theme.CalculadoraIMCTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculadoraIMCTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CalculadoraImc(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CalculadoraImc(modifier: Modifier = Modifier){
    // Inicio da tela

    Column(
        modifier = modifier
            .background(Color.White)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        var altura = remember {
            mutableStateOf("")
        }
        var peso = remember {
            mutableStateOf("")
        }
        var resultado = remember {
            mutableStateOf("22")
        }
        Column(
            modifier = Modifier
                .background(color = Color.Cyan)
                .fillMaxWidth()
                .height(180.dp)
                .padding(
                    top = 16.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                16.dp
            )
        ) {
            Row() {
                Image(
                    painter = painterResource(R.drawable.bmi),
                    contentDescription = "BMI",
//                colorFilter = ColorFilter.tint(Color.Black),
                    modifier = Modifier.size(60.dp)
                )
            }
            Row() {
                Text(
                    text = "Calculadora IMC",
                    fontSize = 26.sp,
                    color = Color.White
                )
            }
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = (-30.dp))
                .height(300.dp)
                .padding(horizontal = 36.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFE3FBFF) //0XFFA29898
            ),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(
                modifier = Modifier
                    .background(color = Color(245, 245, 245, 255))
                    .padding(
                        start = 30.dp,
                        end = 30.dp,
                        top = 30.dp
                    )
                    .height(300.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(
                    16.dp
                ),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Row() {
                    Text(
                        text = "Seus Dados",
                        fontSize = 26.sp,
                        color = Color.Cyan
                    )
                }
                Row() {
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp),
                        value = altura.value,
                        onValueChange = { novoValor ->
                            Log.i("Teste",novoValor)
                            altura.value = novoValor
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        label = {
                            Text(text = "Altura(cm)")
                        },
                        singleLine = true,
                        shape = RoundedCornerShape(16.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = colorResource(R.color.teal_200),
                            focusedBorderColor = colorResource(R.color.teal_200)
                        )
                    )
                }
                Row() {
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp),
                        value = peso.value,
                        onValueChange = { novoValor ->
                            Log.i("Teste",novoValor)
                            peso.value = novoValor
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        label = {
                            Text(text = "Peso(kg)")
                        },
                        singleLine = true,
                        shape = RoundedCornerShape(16.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = colorResource(R.color.teal_200),
                            focusedBorderColor = colorResource(R.color.teal_200)
                        )
                    )
                }
                Row() {
                    Button(
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Text(
                            text = "Calcular",
                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }
                }
            }
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(horizontal = 66.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0,255,0)
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "22 Peso Ideal",
                    fontSize = 30.sp,
                    color = Color.White
                )
            }
        }

    }
}