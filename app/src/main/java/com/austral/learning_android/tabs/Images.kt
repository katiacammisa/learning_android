package com.austral.learning_android.tabs

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import com.austral.learning_android.R

@Composable
fun Images() {
    Column {
        SubcomposeAsyncImage(
            model = "https://www.brandemia.org/wp-content/uploads/2012/10/logo_principal.jpg",
            contentDescription = "Android Image",
            contentScale = ContentScale.Crop,
            loading = {
                CircularProgressIndicator(
                    color = Color.Gray,
                    modifier = Modifier.size(48.dp)
                )
            }
        )
        Image(
            painterResource(R.drawable.android),
            contentDescription = "",
        )
    }
}

@Preview
@Composable
fun PreviewImages() {
    Images()
}