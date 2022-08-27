package io.jyryuitpro.shoppi.android.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.jyryuitpro.shoppi.android.model.Banner
import io.jyryuitpro.shoppi.android.model.Title
import io.jyryuitpro.shoppi.android.repository.home.HomeRepository
import io.jyryuitpro.shoppi.android.ui.common.Event

class HomeViewModel(private val homeRepository: HomeRepository) : ViewModel() {

    private val _title = MutableLiveData<Title>()
    val title: LiveData<Title> = _title

    private val _topBanners = MutableLiveData<List<Banner>>()
    val topBanners: LiveData<List<Banner>> = _topBanners

    private val _openProductEvent = MutableLiveData<Event<String>>()
    val openProductEvent: LiveData<Event<String>> = _openProductEvent

    init {
        loadHomeData()
    }

    fun openProductDetail(productId: String) {
        _openProductEvent.value = Event(productId)
    }

    private fun loadHomeData() {
        // TODO Data Layer - Repository 에 요청
        val homeData = homeRepository.getHomeData()
        homeData?.let {
            _title.value = homeData.title
            _topBanners.value = homeData.topBanners
        }
    }
}