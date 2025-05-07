package com.austral.learning_android.favorite

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.austral.learning_android.security.BiometricAuthManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val biometricAuthManager: BiometricAuthManager,
) : ViewModel() {
    private var _isAuthenticated = MutableStateFlow(false)
    val isAuthenticated = _isAuthenticated.asStateFlow()

    fun authenticate(context: Context) {
        biometricAuthManager.authenticate(
            context,
            onError = {
                _isAuthenticated.value = false
                Toast.makeText(context, "There was an error in the authentication", Toast.LENGTH_SHORT).show()
            },
            onSuccess = {
                _isAuthenticated.value = true
            },
            onFail = {
                _isAuthenticated.value = false
                Toast.makeText(context, "The authentication failed, try again", Toast.LENGTH_SHORT).show()
            }
        )
    }
}