package io.jyryuitpro.shoppi.android.ui.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import io.jyryuitpro.shoppi.android.GlideApp

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        GlideApp.with(view)
            .load(imageUrl)
            .into(view)
    }
}