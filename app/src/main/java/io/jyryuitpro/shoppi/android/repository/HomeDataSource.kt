package io.jyryuitpro.shoppi.android.repository

import io.jyryuitpro.shoppi.android.model.HomeData

interface HomeDataSource {

    fun getHomeData(): HomeData?
}