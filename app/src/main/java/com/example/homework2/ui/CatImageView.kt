package com.example.homework2.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.SubcomposeAsyncImage
import com.example.homework2.R
import com.example.homework2.ui.layout.Paddings
import com.example.homework2.ui.layout.Size
import com.example.homework2.viewModel.ICatViewModel


@Composable
fun CatImageView(catId: Int, viewModel: ICatViewModel) {

    var imageKey by remember(catId) { mutableStateOf(catId) }

    val context = LocalContext.current
    val showToast = showToast()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SubcomposeAsyncImage(
            model = "${context.getString(viewModel.imageUrlId)}?cat=$catId",
            contentDescription = context.getString(R.string.asyncImage_contentDescription),
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Paddings.small)
                .clip(RoundedCornerShape(Paddings.medium))
                .clickable {
                    viewModel.onCatImageViewClicked(context = context, catId = catId, showToast = showToast)
                },
            loading = {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            },
            error = {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = context.getString(R.string.error_contentDescription),
                            modifier = Modifier.size(Size.iconSize),
                            tint = MaterialTheme.colorScheme.error
                        )

                        Spacer(modifier = Modifier.height(Paddings.small))

                        OutlinedButton(
                            onClick = { imageKey++ },
                            modifier = Modifier.fillMaxWidth(0.7f)
                        ) {
                            Text(text = R.string.repeat.toString())
                        }
                    }
                }
            }
        )

        Spacer(modifier = Modifier.height(Paddings.medium))
    }
}