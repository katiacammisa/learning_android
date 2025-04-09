package com.austral.learning_android.leaningViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LearningViewModel @Inject constructor() : ViewModel() {

    // No usamos MutableList porque dos cosas mutables no se mezclan bien
    private var _groceries = MutableStateFlow(listOf<Grocery>())
    val groceries = _groceries.asStateFlow()

    fun addItem(item: String) {
        val grocery = Grocery(item)
        viewModelScope.launch {
            _groceries.emit(
                _groceries.value + grocery
            )
        }
    }

    fun checkItem(grocery: Grocery) {
        viewModelScope.launch {
            _groceries.emit(
                _groceries.value - grocery + grocery.copy(bought = !grocery.bought)
            )
        }
    }

    fun removeItem(grocery: Grocery) {
        viewModelScope.launch {
            _groceries.emit(
                _groceries.value - grocery
            )
        }
    }
}