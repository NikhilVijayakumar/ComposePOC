package com.nikhil.compose.ui.codelab.state

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nikhil.compose.R
import com.nikhil.compose.ui.theme.AppTheme
import java.text.NumberFormat

@Composable
fun StateIntro() {
    CalculateTipScreen()

}

@Composable
fun CalculateTipScreen() {
    AppTheme {
        TipComponent()
    }
}

@Composable
fun TipComponent() {
    var amountInput by remember {
        mutableStateOf("")
    }
    val amount = amountInput.toDoubleOrNull()?:0.0
    val tip = amount * 0.15


        Column(
            Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.size(32.dp))
            TipHeading(modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.size(32.dp))
            GetTip(value = amountInput,
                onValueChange = {
                amountInput = it
            },
                modifier = Modifier.fillMaxWidth()
                )
            Spacer(modifier = Modifier.size(32.dp))
            ShowTip(
               amount = NumberFormat.getCurrencyInstance().format(tip),
                modifier = Modifier.fillMaxWidth()
                )
        }

}

@Composable
fun ShowTip(amount: String, modifier: Modifier = Modifier) {
    Text(
        text = stringResource(id = R.string.tip_amount, amount),
        modifier = modifier,
        style = MaterialTheme.typography.bodyMedium,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GetTip(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {


    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.padding(horizontal = 24.dp),
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        label = { Text(text = stringResource(id = R.string.tip_placeholder)) }

    )
}

@Composable
fun TipHeading(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(id = R.string.tip_heading),
        modifier = modifier
            .fillMaxWidth(),
        style = MaterialTheme.typography.headlineMedium,
        textAlign = TextAlign.Center
    )
}

@Preview(
    showBackground = true, device = Devices.PIXEL,
    showSystemUi = true, uiMode = UI_MODE_NIGHT_NO,
    name = "LightMode"
)
@Composable
fun CalculateTipLightPreview() {
    CalculateTipScreen()
}


@Preview(
    showBackground = true, device = Devices.PIXEL,
    showSystemUi = true, uiMode = UI_MODE_NIGHT_YES,
    name = "NightMode"
)
@Composable
fun CalculateTipDarkPreview() {
    CalculateTipScreen()
}