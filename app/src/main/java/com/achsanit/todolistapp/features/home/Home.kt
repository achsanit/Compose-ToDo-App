package com.achsanit.todolistapp.features.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.achsanit.todolistapp.foundation.navigation.RouteScreen
import com.achsanit.todolistapp.foundation.ui.components.DraggableListItem
import com.achsanit.todolistapp.foundation.ui.components.dragGestureHandler
import com.achsanit.todolistapp.foundation.ui.components.rememberDragDropListState
import kotlinx.coroutines.Job
import java.util.Collections

@Composable
fun HomeScreen(
    navController: NavController,
    onClickToDetailScreen: () -> Unit
) {
//    Column(
//        modifier = Modifier.fillMaxSize()
//            .padding(24.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(
//            modifier = Modifier.clickable { onClickToDetailScreen() },
//            text = "Home Screen",
//            style = TextStyle(
//                fontSize = 20.sp,
//                fontWeight = FontWeight.Bold,
//                color = MaterialTheme.colorScheme.primary
//            )
//        )
//    }
    val listItem = mutableListOf("text 1", "text 2", "text 3")
    val coroutineScope = rememberCoroutineScope()
    val overscrollJob = remember { mutableStateOf<Job?>(null) }
    val dragDropListState = rememberDragDropListState(onMove = { index1, index2 ->
        Collections.swap(listItem, index1, index2)
    })

    LazyColumn(
        modifier = Modifier.dragGestureHandler(coroutineScope, dragDropListState, overscrollJob),
        state = dragDropListState.getLazyListState()
    ) {
        itemsIndexed(listItem) { index, item ->
            val displacementOffset = if (index == dragDropListState.getCurrentIndexOfDraggedListItem()) {
                dragDropListState.elementDisplacement.takeIf { it != 0f }
            } else {
                null
            }
            DraggableListItem(item = item, displacementOffset = displacementOffset)
        }
    }
}