package com.austral.learning_android.leaningViewModels

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun LearningViewModels() {
    val viewModel = hiltViewModel<LearningViewModel>()
    val groceries by viewModel.groceries.collectAsState()

    val dialogVisible = remember {
        mutableStateOf(false)
    }

    if(dialogVisible.value) {
        Dialog(onDismissRequest = { dialogVisible.value = false }) {
            val newItemName = remember {
                mutableStateOf("")
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .background(color = Color.White)
                    .padding(20.dp)
            ) {
                Text(
                    "Add an item to your list",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                )
                TextField(
                    value = newItemName.value,
                    onValueChange = {
                        newItemName.value = it
                    },
                )
                Button(
                    onClick =  {
                        viewModel.addItem(newItemName.value)
                        dialogVisible.value = false
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black, contentColor = Color.White)
                ) {
                    Text("Add item")
                }
            }
        }
    }

    Column(
        modifier = Modifier.padding(vertical = 20.dp).fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                "My grocery list:",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
            )
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "add",
                modifier = Modifier
                    .size(40.dp)
                    .clickable {
                    dialogVisible.value = true
                }
            )
        }
        Spacer(Modifier.size(10.dp))
        groceries
            .sortedBy { it.name }
            .sortedBy { !it.bought }
            .forEach { grocery ->
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Checkbox(
                            checked = grocery.bought,
                            onCheckedChange = {
                                viewModel.checkItem(grocery)
                            }
                        )
                        Text(grocery.name)
                    }
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "delete",
                        modifier = Modifier.clickable {
                            viewModel.removeItem(grocery)
                        }
                    )
                }
            }
    }
}