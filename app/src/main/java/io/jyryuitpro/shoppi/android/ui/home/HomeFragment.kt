package io.jyryuitpro.shoppi.android.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import io.jyryuitpro.shoppi.android.*
import io.jyryuitpro.shoppi.android.ui.common.ViewModelFactory

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels { ViewModelFactory(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // attachToRoot: 바로 RootView에 추가할 것인가? 프래그먼트는 Host가 되는 액티비티 위에 layout을 inflate하는 것이기 때문에
        // 액티비티가 모두 구성된 이후에 layout이 inflate되어야 한다. 생성되는 시점을 늦추기 위해 false를 전달한다.
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val button = view.findViewById<Button>(R.id.btn_enter_product_detail)
//        button.setOnClickListener {
//            val transaction = parentFragmentManager.beginTransaction()
//            transaction.add(R.id.container_main, ProductDetailFragment())
//            transaction.commit()
//            findNavController().navigate(R.id.action_home_to_product_detail)
//        }

        val toolbarTitle = view.findViewById<TextView>(R.id.toolbar_home_title)
        val toolbarIcon = view.findViewById<ImageView>(R.id.toolbar_home_icon)
        val viewpager = view.findViewById<ViewPager2>(R.id.viewpager_home_banner)
        val viewpagerIndicator = view.findViewById<TabLayout>(R.id.viewpager_home_banner_indicator)

//        val assetLoader = AssetLoader()
//        assetLoader.getJsonString(context, "home.json")
//        val homeData = assetLoader.getJsonString(requireContext(), "home.json")
//        Log.d("homeData", homeData ?: "")
//        val homeJsonString = assetLoader.getJsonString(requireContext(), "home.json")

//        if (!homeJsonString.isNullOrEmpty()) {
//            val gson = Gson()
//            val homeData = gson.fromJson(homeJsonString, HomeData::class.java)

//            viewModel.title.observe(viewLifecycleOwner) { title ->
//                toolbarTitle.text = title.text
//                GlideApp.with(this)
//                    .load(title.iconUrl)
//                    .into(toolbarIcon)
//            }

//            viewModel.topBanners.observe(viewLifecycleOwner) { banners ->
//                viewpager.adapter = HomeBannerAdapter().apply {
//                    submitList(banners)
//                }
//            }

//            val jsonObject = JSONObject(homeJsonString)
//            val title = jsonObject.getJSONObject("title")
//            val text = title.getString("text")
//            val iconUrl = title.getString("icon_url")
//            val titleValue = Title(text, iconUrl)
//            toolbarTitle.text = titleValue.text
//            toolbarTitle.text = text
//            toolbarTitle.text = homeData.title.text

//            GlideApp.with(this)
//                .load(titleValue.iconUrl)
//                .into(toolbarIcon)

//            GlideApp.with(this)
//                .load(iconUrl)
//                .into(toolbarIcon)

//            GlideApp.with(this)
//                .load(homeData.title.iconUrl)
//                .into(toolbarIcon)

//            val firstBanner = topBanners.getJSONObject(0)
//            val label = firstBanner.getString("label")
//            val productDetail = firstBanner.getJSONObject("product_detail")
//            val price = productDetail.getInt("price")

//            Log.d("text", "text=${text}, iconUrl=${iconUrl}")
//            Log.d("firstBanner", "label=${label}, price=${price}")

//            viewpager.adapter = HomeBannerAdapter().apply {
//                submitList(homeData.topBanners)
//            }

//            val pageWidth = resources.getDimension(R.dimen.viewpager_item_width)
//            val pageMargin = resources.getDimension(R.dimen.viewpager_item_margin)
//            val screenWidth = resources.displayMetrics.widthPixels
//            val offset = screenWidth - pageWidth - pageMargin

//            viewpager.offscreenPageLimit = 3
//            viewpager.setPageTransformer { page, position ->
//                page.translationX = position * -offset
//            }
//            TabLayoutMediator(viewpagerIndicator, viewpager) { tab, position ->

//            }.attach()
//        }

        viewModel.title.observe(viewLifecycleOwner) { title ->
            toolbarTitle.text = title.text
            GlideApp.with(this)
                .load(title.iconUrl)
                .into(toolbarIcon)
        }

        viewpager.adapter = HomeBannerAdapter().apply {
            viewModel.topBanners.observe(viewLifecycleOwner) { banners ->
                submitList(banners)
            }
        }

        val pageWidth = resources.getDimension(R.dimen.viewpager_item_width)
        val pageMargin = resources.getDimension(R.dimen.viewpager_item_margin)
        val screenWidth = resources.displayMetrics.widthPixels
        val offset = screenWidth - pageWidth - pageMargin

        viewpager.offscreenPageLimit = 3
        viewpager.setPageTransformer { page, position ->
            page.translationX = position * -offset
        }
        TabLayoutMediator(viewpagerIndicator, viewpager) { tab, position ->

        }.attach()
    }
}