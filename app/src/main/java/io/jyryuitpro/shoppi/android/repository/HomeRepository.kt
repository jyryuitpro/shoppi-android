package io.jyryuitpro.shoppi.android.repository

import io.jyryuitpro.shoppi.android.model.HomeData

class HomeRepository(private val assetDataSource: HomeAssetDataSource) {

    fun getHomeData(): HomeData? {
        return assetDataSource.getHomeData()
    }
}