package io.jyryuitpro.shoppi.android.repository.home

import com.google.gson.Gson
import io.jyryuitpro.shoppi.android.AssetLoader
import io.jyryuitpro.shoppi.android.model.HomeData

class HomeAssetDataSource(private val assetLoader: AssetLoader) : HomeDataSource {

    private val gson = Gson()

    override fun getHomeData(): HomeData? {
        return assetLoader.getJsonString("home.json")?.let { homeJsonString ->
            gson.fromJson(homeJsonString, HomeData::class.java)
        }
    }
}