package io.jyryuitpro.shoppi.android

import android.content.Context
import android.util.Log

class AssetLoader(private val context: Context) {

    fun getJsonString(fileName: String): String? {
        // val string = loadAsset(context, fileName)
        // 이와 같이 성공 혹은 실패 케이스로 나뉘어지는 작업을 처리 할 때,
        // 코틀린에서는 runCatching와 함께 처리할 수 있습니다.
        return kotlin.runCatching {
            loadAsset(fileName)
        // isFailure -> null
        }.getOrNull()
    }

    private fun loadAsset(fileName: String): String {
        return context.assets.open(fileName).use { inputStream ->
            val size = inputStream.available()
            val bytes = ByteArray(size)
            inputStream.read(bytes)
            String(bytes)
//            val homeData = String(bytes)
//            Log.d("homeData", homeData)
        }
    }
}