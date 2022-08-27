package io.jyryuitpro.shoppi.android.ui.categorydetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.jyryuitpro.shoppi.android.model.Promotion
import io.jyryuitpro.shoppi.android.model.TopSelling
import io.jyryuitpro.shoppi.android.repository.categorydetail.CategoryDetailRepository
import kotlinx.coroutines.launch

class CategoryDetailViewModel(private val categoryDetailRepository: CategoryDetailRepository) : ViewModel() {

    private val _topSelling = MutableLiveData<TopSelling>()
    val topSelling: LiveData<TopSelling> = _topSelling

    private val _promotions = MutableLiveData<Promotion>()
    val promotions: LiveData<Promotion> = _promotions

    init {
        loadCategoryDetail()
    }

    private fun loadCategoryDetail() {
        viewModelScope.launch {
            val categoryDetail = categoryDetailRepository.getCategoryDetail()
            _topSelling.value = categoryDetail.topSelling
            _promotions.value = categoryDetail.promotions
        }
    }
}