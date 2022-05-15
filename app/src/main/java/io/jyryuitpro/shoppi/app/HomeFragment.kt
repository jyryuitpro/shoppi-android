package io.jyryuitpro.shoppi.app

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.json.JSONObject

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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

        val assetLoader = AssetLoader()
        val homeData = assetLoader.getJsonString(requireContext(), "home.json")
        Log.d("homeData", homeData ?: "")

        if (!homeData.isNullOrEmpty()) {
            val jsonObject = JSONObject(homeData)
            val title = jsonObject.getJSONObject("title")
            val text = title.getString("text")
            val iconUrl = title.getString("icon_url")
//            val titleValue = Title(text, iconUrl)
            toolbarTitle.text = text
            GlideApp.with(this)
                .load(iconUrl)
                .into(toolbarIcon)
//            val topBanners = jsonObject.getJSONArray("top_banners")
//            val firstBanner = topBanners.getJSONObject(0)
//            val label = firstBanner.getString("label")
//            val productDetail = firstBanner.getJSONObject("product_detail")
//            val price = productDetail.getInt("price")

//            Log.d("title", "text=${text}, iconUrl=${iconUrl}")
//            Log.d("firstBanner", "label=${label}, price=${price}")
        }
    }
}