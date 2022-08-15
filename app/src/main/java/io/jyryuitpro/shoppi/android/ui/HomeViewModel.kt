package io.jyryuitpro.shoppi.android.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.jyryuitpro.shoppi.android.Banner
import io.jyryuitpro.shoppi.android.Title

class HomeViewModel : ViewModel() {

    private val _title = MutableLiveData<Title>()
    val title: LiveData<Title> = _title

    private val _topBanners = MutableLiveData<List<Banner>>()
    val topBanners: LiveData<List<Banner>> = _topBanners

    fun loadHomeData() {
        // todo: Data Layer - Repository 에 요청
    }
}