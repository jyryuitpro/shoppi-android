package io.jyryuitpro.shoppi.android.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.jyryuitpro.shoppi.android.databinding.ItemHomeBannerBinding
import io.jyryuitpro.shoppi.android.model.Banner

class HomeBannerAdapter : ListAdapter<Banner, HomeBannerAdapter.HomeBannerViewHolder>(BannerDiffCallback()) {

    private lateinit var binding: ItemHomeBannerBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeBannerViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home_banner, parent, false)
//        return HomeBannerViewHolder(view)
        binding = ItemHomeBannerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeBannerViewHolder(binding)
    }

    // onCreateViewHolder에서 HomeBannerViewHolder가 잘 생성이되면 holder로 전달이 됩니다.
    // holder의 데이터를 바인딩하는 곳 입니다.
    override fun onBindViewHolder(holder: HomeBannerViewHolder, position: Int) {
        // ListAdapter에서 제공하는 getItem 메서드를 활용합니다.
        holder.bind(getItem(position))
    }

    class HomeBannerViewHolder(private val binding: ItemHomeBannerBinding) : RecyclerView.ViewHolder(binding.root) {

//        private val bannerImageView = view.findViewById<ImageView>(R.id.iv_banner_image)
//        private val bannerBadgeTextView = view.findViewById<TextView>(R.id.tv_banner_badge)
//        private val bannerTitleTextView = view.findViewById<TextView>(R.id.tv_banner_title)
//        private val bannerDetailThumbnailImageView = view.findViewById<ImageView>(R.id.iv_banner_detail_thumbnail)
//        private val bannerDetailBrandLabelTextView = view.findViewById<TextView>(R.id.tv_banner_detail_brand_label)
//        private val bannerDetailProductLabelTextView = view.findViewById<TextView>(R.id.tv_banner_detail_product_label)
//        private val bannerDetailProductDiscountRateTextView = view.findViewById<TextView>(R.id.tv_banner_detail_product_discount_rate)
//        private val bannerDetailProductDiscountPriceTextView = view.findViewById<TextView>(R.id.tv_banner_detail_product_discount_price)
//        private val bannerDetailProductPriceTextView = view.findViewById<TextView>(R.id.tv_banner_detail_product_price)

        // 데이터 바인딩 메서드
        fun bind(banner: Banner) {
//            loadImage(banner.backgroundImageUrl, bannerImageView)

//            bannerBadgeTextView.text = banner.badge.label
            /**
             * Color.parseColor(banner.badge.backgroundColor): 컬러 객체로 변경
             * ColorDrawable(Color.parseColor(banner.badge.backgroundColor)): Drawable 객체로 변경
             */
//            bannerBadgeTextView.background = ColorDrawable(Color.parseColor(banner.badge.backgroundColor))
//            bannerTitleTextView.text = banner.label
//            loadImage(banner.productDetail.thumbnailImageUrl, bannerDetailThumbnailImageView)
//            bannerDetailBrandLabelTextView.text = banner.productDetail.brandName
//            bannerDetailProductLabelTextView.text = banner.productDetail.label
//            bannerDetailProductDiscountRateTextView.text = "${banner.productDetail.discountRate}%"
//            calculateDiscountAmount(bannerDetailProductDiscountPriceTextView, banner.productDetail.discountRate, banner.productDetail.price)
//            applyPriceFormat(bannerDetailProductPriceTextView, banner.productDetail.price)
            binding.banner = banner
            // 바로 데이터를 바인딩 하기 위해서 호출합니다.
            binding.executePendingBindings()
        }

//        private fun calculateDiscountAmount(view: TextView, discountRate: Int, price: Int) {
        // roundToInt(): 반올림
//            val discountPrice = (((100 - discountRate) / 100.0) * price).roundToInt()
//            applyPriceFormat(view, discountPrice)
//        }

//        private fun applyPriceFormat(view: TextView, price: Int) {
//            val decimalFormat = DecimalFormat("#,###")
//            view.text = decimalFormat.format(price) + "원"
//        }
        /**
         * itemView로 View 참조 가능
         */
//        private fun loadImage(urlString: String, imageView: ImageView) {
//            GlideApp.with(itemView)
//                .load(urlString)
//                .into(imageView)
//        }
    }
}

class BannerDiffCallback : DiffUtil.ItemCallback<Banner>() {
    override fun areItemsTheSame(oldItem: Banner, newItem: Banner): Boolean {
        return oldItem.productDetail.productId == newItem.productDetail.productId
    }

    // areItemsTheSame에서 oldItem.productDetail.productId == newItem.productDetail.productId 동일하면 호출됩니다.
    override fun areContentsTheSame(oldItem: Banner, newItem: Banner): Boolean {
        return oldItem == newItem
    }
}