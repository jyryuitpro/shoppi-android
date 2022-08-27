package io.jyryuitpro.shoppi.android.ui.productdetail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import io.jyryuitpro.shoppi.android.common.KEY_PRODUCT_ID
import io.jyryuitpro.shoppi.android.databinding.FragmentProductDetailBinding
import io.jyryuitpro.shoppi.android.ui.common.ViewModelFactory
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import io.jyryuitpro.shoppi.android.R
import io.jyryuitpro.shoppi.android.ui.common.EventObserver

class ProductDetailFragment : Fragment() {

    private val viewModel: ProductDetailViewModel by viewModels { ViewModelFactory(requireContext()) }
    private lateinit var binding: FragmentProductDetailBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_product_detail, container, false)
        binding = FragmentProductDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val productId = requireArguments().getString(KEY_PRODUCT_ID)
        Log.d("ProductDetailFragment", "productId=$productId")

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        setNavigation()
        requireArguments().getString(KEY_PRODUCT_ID)?.let { productId ->
            setLayout(productId)
        }
        setAddCart()
    }

    private fun setAddCart() {
        viewModel.addCartEvent.observe(viewLifecycleOwner, EventObserver {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle(getString(R.string.dialog_title_add_cart))
                .setPositiveButton(getString(R.string.dialog_button_label_confirm)) { dialog, which ->

                }
                .show()
        })
    }

    private fun setNavigation() {
        binding.toolbarProductDetail.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun setLayout(productId: String) {
        viewModel.loadProductDetail(productId)
        val descriptionAdapter = ProductDescriptionAdapter()
        binding.rvProductDetail.adapter = descriptionAdapter
        viewModel.product.observe(viewLifecycleOwner) { product ->
            binding.product = product
            descriptionAdapter.submitList(product.descriptions)
        }
    }
}