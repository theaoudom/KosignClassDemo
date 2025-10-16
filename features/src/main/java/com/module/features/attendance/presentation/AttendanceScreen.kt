package com.module.features.attendance.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.module.features.attendance.presentation.state.AttendanceEvent
import com.module.features.attendance.presentation.state.AttendanceState

@Preview
@Composable
fun AttendanceScreen(
    state : AttendanceState? = null,
    onEvent : (AttendanceEvent) -> Unit = {}
) {

    LaunchedEffect(Unit) {
        onEvent.invoke(
            AttendanceEvent.OnGetAttendance
        )
    }

    Scaffold (
        topBar = {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Cyan),
                text = "Top Bar Attendance"
            )
        }
    ){ paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Red)
                .padding(paddingValues)
        ){
            Text(
                text = "Screen Content"
            )
        }
    }
}