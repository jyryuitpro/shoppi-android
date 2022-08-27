package io.jyryuitpro.shoppi.android.ui.productdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.jyryuitpro.shoppi.android.model.Product
import io.jyryuitpro.shoppi.android.repository.cart.CartRepository
import io.jyryuitpro.shoppi.android.repository.productdetail.ProductDetailRepository
import io.jyryuitpro.shoppi.android.ui.common.Event
import kotlinx.coroutines.launch

class ProductDetailViewModel(
    private val productDetailRepository: ProductDetailRepository,
    private val cartRepository: CartRepository
) : ViewModel() {

    private val _product = MutableLiveData<Product>()
    val product: LiveData<Product> = _product

    private val _addCartEvent = MutableLiveData<Event<Unit>>()
    val addCartEvent: LiveData<Event<Unit>> = _addCartEvent

    fun loadProductDetail(productId: String) {
        viewModelScope.launch {
            _product.value = productDetailRepository.getProductDetail(productId)
        }
    }

    fun addCart(product: Product) {
        viewModelScope.launch {
            cartRepository.addCartItem(product)
            _addCartEvent.value = Event(Unit)
        }
    }
}