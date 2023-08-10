package com.example.introducaoojetpack

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.introducaoojetpack.ui.theme.IntroducaooJetPackTheme
import com.example.introducaoojetpack.ui.theme.PrimeiroButtonColor
import com.example.introducaoojetpack.ui.theme.SegundoButtonColor
import com.example.introducaoojetpack.ui.theme.TerceiroButtonColor

const val  TAG = "testeAndroid"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App();
        }
    }

}

@Composable
fun App(){
    IntroducaooJetPackTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            /*mexe somente no fundo do app, caso queira mudar o fundo*/
            color = MaterialTheme.colorScheme.background
        ) {
            Column(verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally){
                /*Caso queira uma quebra de linha é só colocar um greeting em baixo do outro*/
                /*Já é responsivo*/
                Greeting(name = "JetPack")

                /*Definindo cor e tamanho dos Botões*/
                ActionButton(text = "Botão",
                    buttonColors = PrimeiroButtonColor(),
                    modifier = Modifier.fillMaxWidth(1f) ){
                    Log.w(TAG, "App: Clicou no 1º Botão")
                    }

                ActionButton(text = "2Botão",
                    buttonColors = SegundoButtonColor(),
                    modifier = Modifier.fillMaxWidth(0.3f)) {
                    Log.d(TAG, "App: Clicou no 1º Botão")
                }

                ActionButton(text = "3Botão",
                    buttonColors = TerceiroButtonColor(),
                    modifier = Modifier.fillMaxWidth(0.4f)) {
                    Log.d(TAG, "App: Clicou no 1º Botão")
                }

                ActionButton(text = "4Botão",
                    buttonColors = TerceiroButtonColor(),
                    modifier = Modifier.fillMaxWidth(0.1f)) {
                    try {
                        throw  RuntimeException("App: Clicou no 1º Botão")
                    }catch (ex : Exception){
                        Log.e(TAG, "${ex.message}")
                    }

                }

            }
        }
    }
}

/*Preview é uma função aonde consegue mostrar a gente como vai ficar o app */
@Preview(showBackground = true, /*Largura*/widthDp = 150, /*Altura*/heightDp = 200)
@Composable
fun AppPreview(){
    App()
}


@Composable
fun ActionButton(
    /*parametros*/

    text: String, buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    modifier: Modifier = Modifier,
    block: () -> Unit /*Execução*/
){
/*Contrução do Botão*/
    ElevatedButton(
        onClick = block,
        shape = RoundedCornerShape(5.dp),
        colors = buttonColors,
        modifier = Modifier
        ) {
        /*texto que o botão vai receber*/
        Text(text = text)
        
    }
}

@Preview(showBackground = true)
@Composable
fun ActionButtonPreview(){
    ActionButton(text = "Cadastrar") {
        
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IntroducaooJetPackTheme {
        Greeting("Android")
    }
}