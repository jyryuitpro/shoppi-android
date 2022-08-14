package io.jyryuitpro.shoppi.android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class HomeFragment : Fragment() {

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

        val button = view.findViewById<Button>(R.id.btn_enter_product_detail)
        button.setOnClickListener {
            val transaction = parentFragmentManager.beginTransaction()
            transaction.add(R.id.container_main, ProductDetailFragment())
            transaction.commit()
        }
    }
}