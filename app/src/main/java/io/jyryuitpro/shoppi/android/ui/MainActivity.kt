package io.jyryuitpro.shoppi.android.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.jyryuitpro.shoppi.android.R

class MainActivity : AppCompatActivity() {

    // 액티비티 생성 후, 최초 한번만 호출: LayoutInflate, 데이터 초기화
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // LayoutInflate
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate")

        // Theme color 초기화
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navigation_main)
        bottomNavigationView.itemIconTintList = null

        // navController: NavHostFragment에서 destination의 이동을 관리하는 객체 (화면이동을 관리하는 navController 객체를 bottomNavigationView에 할당하는 것을 지원함으로써
        // bottomNavigationView에 아이템을 클릭했을 때, 화면이동이 이루어질 수 있도록 처리가 가능합니다.
        val navController = supportFragmentManager.findFragmentById(R.id.container_main)?.findNavController()
        navController?.let {
            // FragmentContainerView와 BottomNavigationView 연결
            // app:startDestination="@id/navigation_home"
            bottomNavigationView.setupWithNavController(it)
        }
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }

    // 액티비티가 화면에서 벗어났다가 다시 되돌아 왔을 때 한번 더 호출될 수 있음: 애니메이션 실행, 데이터 갱신
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    // 액티비티가 화면에서 보여지고 있는 상태, 액티비티가 focus를 얻었다고 표현함: 자주 호출 될 수 있기 때문에 너무 오래 걸리는 연산을 여기서 처리하는 것은 옳지 않음
    // Activity running
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    // 액티비티가 focus를 잃었을 때 호출: 자주 호출 될 수 있기 때문에 너무 오래 걸리는 연산을 여기dp서 처리하는 것은 옳지 않음
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    // 홈 버튼을 누르고 액티비티를 종료하고 다른 앱을 사용하고 있는 경우 호출: 애니메이션 종료, 데이터 갱신 처리 중단
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    // 사용 중인 앱 목록에서도 완전이 제거될 때 호출: 이전 단계인 onStop에서 마저 정리하지 않은 작업이 있다면... 리소스를 해제하는 작업
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    companion object {
        const val TAG = "MainActivity"
    }
}