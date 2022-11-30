package com.codelabs.state

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.codelabs.state.data.WellnessTasksList
import com.codelabs.state.ui.WellnessViewModel

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    viewModel: WellnessViewModel = viewModel()
) {
    Column(modifier = modifier) {
        StatefulCounter()

        WellnessTasksList(
            list = viewModel.tasks,
            onCheckedTask = { task, checked ->
                viewModel.changeTaskChecked(task, checked)
            },
            onCloseTask = { task ->
                viewModel.remove(task)
            }
        )
    }
}
