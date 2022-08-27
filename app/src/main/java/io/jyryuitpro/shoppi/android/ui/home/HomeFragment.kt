package io.jyryuitpro.shoppi.android.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import io.jyryuitpro.shoppi.android.R
import io.jyryuitpro.shoppi.android.common.KEY_CATEGORY_ID
import io.jyryuitpro.shoppi.android.common.KEY_PRODUCT_ID
import io.jyryuitpro.shoppi.android.databinding.FragmentHomeBinding
import io.jyryuitpro.shoppi.android.ui.common.EventObserver
import io.jyryuitpro.shoppi.android.ui.common.ViewModelFactory

class HomeFragment : Fragment() {

    // private val viewModel: HomeViewModel by viewModels()
    private val viewModel: HomeViewModel by viewModels { ViewModelFactory(requireContext()) }
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /**
         * attachToRoot: 바로 RootView에 추가할 것인가? 프래그먼트는 Host가 되는 액티비티 위에 layout을 inflate하는 것이기 때문에
         * 액티비티가 모두 구성된 이후에 layout이 inflate되어야 한다. 생성되는 시점을 늦추기 위해 false를 전달한다.
         */
        // return inflater.inflate(R.layout.fragment_home, container, false)
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    // view: View: onCreateView에서 생성된 View가 전달됩니다.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /**
         * Fragment간에 이동했던 이력은 백스택에서 관리하며, Activity도 마찬가지입니다.
         * Transaction: Fragment에 추가, 삭제, 교체를 요청합니다.
         * Transaction.commit(): Transaction 실행
         *
         * navController를 이용한 화면 이동: findNavController().navigate(R.id.action_home_to_product_detail)
          */
//        val button = view.findViewById<Button>(R.id.btn_enter_product_detail)
//        button.setOnClickListener {
//            val transaction = parentFragmentManager.beginTransaction()
//            transaction.add(R.id.container_main, ProductDetailFragment())
//            transaction.commit()
//
//            findNavController().navigate(R.id.action_home_to_product_detail)
//        }

//        class AssetLoader loadAsset 함수로 이동시킴.
//        context?.assets?.open("home.json")?.use { inputStream ->
//            val size = inputStream.available()
//            val bytes = ByteArray(size)
//            inputStream.read(bytes)
//            val homeData = String(bytes)
//            Log.d("homeData", homeData)
//        }

//        val toolbarTitle = view.findViewById<TextView>(R.id.toolbar_home_title)
//        val toolbarIcon = view.findViewById<ImageView>(R.id.toolbar_home_icon)
//        val viewpager = view.findViewById<ViewPager2>(R.id.viewpager_home_banner)
//        val viewpagerIndicator = view.findViewById<TabLayout>(R.id.viewpager_home_banner_indicator)

        /**
         * HomeFragement에서 View가 생성된 시점에는 Context가 존재하는 시점이므로,
         * non-null type의 context를 반환하는 requireContext() 메서드를 통해서 context 전달이 가능합니다.
         */

        /**
         * 1차 작업
         */
//        val assetLoader = AssetLoader()
//        assetLoader.getJsonString(context, "home.json")
//        val homeData = assetLoader.getJsonString(requireContext(), "home.json")
//        Log.d("homeData", homeData ?: "")

        /**
         * gson
         */
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

        /**
         * 1차 작업
         */
//            val jsonObject = JSONObject(homeJsonString)
//            val title = jsonObject.getJSONObject("title")
//            val text = title.getString("text")
//            val iconUrl = title.getString("icon_url")
        /**
         * data class Title 사용
         */
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

        /**
         * 1차 작업
         */
//            val topBanners = jsonObject.getJSONArray("top_banners")
//            val firstBanner = topBanners.getJSONObject(0)
//            val label = firstBanner.getString("label")
//            val productDetail = firstBanner.getJSONObject("product_detail")
//            val price = productDetail.getInt("price")

//            Log.d("text", "text=${text}, iconUrl=${iconUrl}")
//            Log.d("firstBanner", "label=${label}, price=${price}")

        /**
         * gson
         */
//            viewpager.adapter = HomeBannerAdapter().apply {
//                submitList(homeData.topBanners)
//            }

        /**
         * 디바이스의 가로 길이 - 한 페이지의 가로 길이 - 페이지 간의 간격 길이 = 다음 페이지가 이동해야하는 길이
         *
         * getDimension : dp to pixel
          */
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

        binding.lifecycleOwner = viewLifecycleOwner
        setToolbar()
        setTopBanners()
        setNavigation()
    }

    private fun setToolbar() {
        viewModel.title.observe(viewLifecycleOwner) { title ->
    //            toolbarTitle.text = title.text
    //            GlideApp.with(this)
    //                .load(title.iconUrl)
    //                .into(toolbarIcon)
            binding.title = title
        }
    }

    private fun setNavigation() {
        viewModel.openProductEvent.observe(viewLifecycleOwner, EventObserver { productId ->
            findNavController().navigate(R.id.action_home_to_product_detail, bundleOf(
                KEY_PRODUCT_ID to productId
            ))
        })
    }

    private fun setTopBanners() {

//        viewModel.topBanners.observe(viewLifecycleOwner, { banners ->
//            viewpager.adapter = HomeBannerAdapter().apply {
//                submitList(banners)
//            }
//        })

        with(binding.viewpagerHomeBanner) {
            adapter = HomeBannerAdapter(viewModel).apply {
                viewModel.topBanners.observe(viewLifecycleOwner) { banners ->
                    submitList(banners)
                }
            }
            /**
             * getDimension : dp tp px
             */
            val pageWidth = resources.getDimension(R.dimen.viewpager_item_width)
            val pageMargin = resources.getDimension(R.dimen.viewpager_item_margin)
            val screenWidth = resources.displayMetrics.widthPixels
            val offset = screenWidth - pageWidth - pageMargin

            Log.d("HomeFragment", "$pageWidth")
            Log.d("HomeFragment", "$pageMargin")
            Log.d("HomeFragment", "$screenWidth")
            Log.d("HomeFragment", "$offset")

            offscreenPageLimit = 3
            setPageTransformer { page, position ->
                // position: 위치에 대한 값을 비율적으로 전달
                page.translationX = position * -offset
                Log.d("HomeFragment", "$position")
                Log.d("HomeFragment", "${-offset}")
                Log.d("HomeFragment", "${page.translationX}")
            }
            TabLayoutMediator(binding.viewpagerHomeBannerIndicator, this) { tab, position ->

            }.attach()
        }
    }
}