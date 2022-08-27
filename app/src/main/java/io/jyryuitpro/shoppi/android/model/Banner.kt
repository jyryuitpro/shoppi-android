package io.jyryuitpro.shoppi.android.model

import com.google.gson.annotations.SerializedName

data class Banner(
    @SerializedName("background_image_url") val backgroundImageUrl: String,
    val badge: BannerBadge,
    val label: String,
    @SerializedName("product_detail") val productDetail: Product
)

data class BannerBadge(
    val label: String,
    @SerializedName("background_color") val backgroundColor: String
)
