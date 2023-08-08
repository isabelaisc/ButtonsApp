package com.example.buttonapp

import android.nfc.Tag
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buttonapp.ui.theme.ButtonAppTheme
import java.lang.Exception
import java.lang.RuntimeException
import com.example.buttonapp.ui.theme.DebugButtonColors
import com.example.buttonapp.ui.theme.ErrorButtonColors
import com.example.buttonapp.ui.theme.InfoButtonColors
import com.example.buttonapp.ui.theme.WarningButtonColors


const val TAG = "ButtonApp"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ButtonAppTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Greeting("Jetpack")
            ActionButtonDebug(
                text = "Debug",
                buttonColors = DebugButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                /*Ação do Botão*/
                Log.d(TAG, "App: Clicou em DEBUG!")
            }
            ActionButtonInfo(
                text = "Info",
                buttonColors = InfoButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                /*Ação do Botão*/
                Log.i(TAG, "App: Clicou em INFO!")
            }
            ActionButtonWarning(
                text = "Warning",
                buttonColors = WarningButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                /*Ação do Botão*/
                Log.w(TAG, "App: Clicou em Warning!")
            }
            ActionButtonError(
                text = "Error",
                buttonColors = ErrorButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                try {
                    throw RuntimeException("Clicou em Error!")
                } catch (ex: Exception) {
                    Log.e(TAG, "${ex.message}")
                }
            }
        }

    }
}

@Composable
fun ActionButton(
    text: String,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    modifier: Modifier = Modifier,
    block: () -> Unit
) {
    ElevatedButton(
        onClick = block,
        shape = RoundedCornerShape(5.dp),
        colors = buttonColors,
        modifier = modifier
    ) {
        Text(text = text)
    }
}

@Composable
fun ActionButtonDebug(
    text: String,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    modifier: Modifier = Modifier,
    block: () -> Unit
) {
    ActionButton(text, buttonColors, modifier, block)
}

@Composable
fun ActionButtonInfo(
    text: String,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    modifier: Modifier = Modifier,
    block: () -> Unit
) {
    ActionButton(text, buttonColors, modifier, block)
}

@Composable
fun ActionButtonWarning(
    text: String,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    modifier: Modifier = Modifier,
    block: () -> Unit
) {
    ActionButton(text, buttonColors, modifier, block)
}

@Composable
fun ActionButtonError(
    text: String,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    modifier: Modifier = Modifier,
    block: () -> Unit
) {
    ActionButton(text, buttonColors, modifier, block)
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Aula de $name!",
        style = MaterialTheme.typography.bodyLarge.copy(
            fontWeight = FontWeight.Bold
        ),
        color = MaterialTheme.colorScheme.secondary
    )
}

@Preview(showBackground = true, widthDp = 250)
@Composable
fun AppPreview() {
    ButtonAppTheme {
        App()
    }
}

@Preview(showBackground = true, widthDp = 250)
@Composable
fun ActionButtonDebugPreview() {
    ButtonAppTheme {
        ActionButtonDebug(
            text = "Debug",
            buttonColors = DebugButtonColors(),
            modifier = Modifier.fillMaxWidth(0.5f)
        ) {
            Log.d(TAG, "App: Clicou em DEBUG!")
        }
    }
}

@Preview(showBackground = true, widthDp = 250)
@Composable
fun ActionButtonInfoPreview() {
    ButtonAppTheme {
        ActionButtonInfo(
            text = "Info",
            buttonColors = InfoButtonColors(),
            modifier = Modifier.fillMaxWidth(0.5f)
        ) {
            Log.i(TAG, "App: Clicou em INFO!")
        }
    }
}

@Preview(showBackground = true, widthDp = 250)
@Composable
fun ActionButtonWarningPreview() {
    ButtonAppTheme {
        ActionButtonWarning(
            text = "Warning",
            buttonColors = WarningButtonColors(),
            modifier = Modifier.fillMaxWidth(0.5f)
        ) {
            Log.w(TAG, "App: Clicou em Warning!")
        }
    }
}

@Preview(showBackground = true, widthDp = 250)
@Composable
fun ActionButtonErrorPreview() {
    ButtonAppTheme {
        ActionButtonError(
            text = "Error",
            buttonColors = ErrorButtonColors(),
            modifier = Modifier.fillMaxWidth(0.5f)
        ) {
            try {
                throw RuntimeException("Clicou em Error!")
            } catch (ex: Exception) {
                Log.e(TAG, "${ex.message}")
            }
        }
    }
}
@Preview(showBackground = true, widthDp = 120)
@Composable
fun ActionButtonPreview(){
    ActionButton(text = "Cadastrar") {
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ButtonAppTheme {
        Greeting("Jetpack")
    }
}
