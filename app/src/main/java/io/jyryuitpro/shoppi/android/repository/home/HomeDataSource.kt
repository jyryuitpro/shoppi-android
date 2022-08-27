package io.jyryuitpro.shoppi.android.repository.home

import io.jyryuitpro.shoppi.android.model.HomeData

interface HomeDataSource {

    fun getHomeData(): HomeData?
}