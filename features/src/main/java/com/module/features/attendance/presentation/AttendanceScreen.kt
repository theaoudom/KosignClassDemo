package com.module.features.attendance.presentation

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.module.features.attendance.presentation.state.AttendanceEvent
import com.module.features.attendance.presentation.state.AttendanceState

@Preview
@Composable
fun AttendanceScreen(
    state : AttendanceState? = null,
    onEvent : (AttendanceEvent) -> Unit = {}
) {
    val context = LocalContext.current
    val lazyListState = rememberLazyListState()

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
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Column {
                if (state?.isLoading == true)
                    Text(text = "Loading...")
                else {
                    TextField(
                        value = state?.searchText ?: "",
                        onValueChange = { search ->
                            onEvent(
                                AttendanceEvent.OnSearchChange(
                                    search = search
                                )
                            )
                        }
                    )
                    LazyColumn(
                        state = lazyListState,
                    ) {
                        items(state?.attendance?.data ?: emptyList()) { item ->
                            Text("${item.name}")
                        }
                    }
                }
            }
        }
    }

    if (state?.error != null){
        Toast.makeText(context, state.error.asString(context), Toast.LENGTH_SHORT).show()
        onEvent.invoke(
            AttendanceEvent.OnDismissDialog
        )
    }
}