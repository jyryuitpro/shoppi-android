package io.jyryuitpro.shoppi.app

import android.content.Context
import android.util.Log

class AssetLoader {
    fun getJsonString(context: Context, fileName: String): String? {
        return kotlin.runCatching {
            loadAsset(context, fileName)
        }.getOrNull()
    }

    private fun loadAsset(context: Context, fileName: String): String {
        return context.assets.open(fileName).use { inputStream ->
            val size = inputStream.available()
            val bytes = ByteArray(size)
            inputStream.read(bytes)
//            val homeData = String(bytes)
//            Log.d("homeData", homeData)
            String(bytes)
        }
    }
}