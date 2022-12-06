package com.nikhil.compose.ui.codelab.state

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nikhil.compose.R
import com.nikhil.compose.ui.codelab.state.model.WellnessTask
import com.nikhil.compose.ui.theme.AppTheme

@Composable
fun StateCore() {
    WellnessScreen()

}

@Composable
fun WellnessScreen() {
    AppTheme{
        Column() {
            StatefulWaterSection(Modifier.padding(16.dp))
            TaskStatefulSection(Modifier.padding(16.dp))
        }
    }
}

@Composable
fun TaskStatefulSection(modifier: Modifier) {
   val viewModel:WellnessViewModel = viewModel()

    val listState = rememberLazyListState()


    LazyColumn(state = listState){
        items(viewModel.wellnessTasks){task->
            WellnessRowStateless(
                task.label,task.isChecked,
                {ischecked->
                    viewModel.updateTask(task,ischecked)
                },
                {
                    viewModel.removeTask(task)
                },
                modifier)
            Divider(modifier=Modifier.padding(horizontal = 16.dp))
        }

    }

}

@Composable
fun WellnessRowStateless(
    label: String,
    checked: Boolean,
    onCheckedChange:  ((Boolean) -> Unit)?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = label,
            modifier = Modifier
                .weight(1f)
                .padding(16.dp)
        )
        Checkbox(checked = checked, onCheckedChange =onCheckedChange )
        IconButton(onClick = onClick) {
            Icon(imageVector = Icons.Filled.Close, contentDescription = stringResource(R.string.task_close) )
        }
    }
}




@Composable
fun StatefulWaterSection(modifier: Modifier) {
    val viewModel:WellnessViewModel = viewModel()
    StatelessWaterSection(
        viewModel.count.value,
        {viewModel.incrementWaterCount()}
        ,modifier
    )
}

@Composable
fun StatelessWaterSection(count: Int, onClick: () -> Unit, modifier: Modifier) {
    Column(modifier = modifier) {
        if(count>0){
            Text(
                text = stringResource(id = R.string.water_message,count),
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Button(
            onClick = onClick,
            enabled = count<10
        ) {
            Text(
                text = stringResource(id = R.string.water_button)
            )
        }
    }
}

@Preview(
    showBackground = true, device = Devices.PIXEL,
    showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "LightMode"
)
@Composable
fun WellnessScreenLightPreview() {
    WellnessScreen()
}

@Preview(
    showBackground = true,
    device = Devices.PIXEL,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DarkMode"
)
@Composable
fun WellnessScreenDarkPreview() {
    WellnessScreen()
}
