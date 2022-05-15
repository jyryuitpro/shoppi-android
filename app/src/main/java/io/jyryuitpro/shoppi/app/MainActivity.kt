package io.jyryuitpro.shoppi.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    // layout inflate, 데이터 초기화
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navigation_main)
        bottomNavigationView.itemIconTintList = null

        val navController = supportFragmentManager.findFragmentById(R.id.container_main)?.findNavController()
        navController?.let {
            bottomNavigationView.setupWithNavController(it)
        }
        Log.d(TAG, "onCreate")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }

    // 애니메이션의 실행, 데이터의 갱신
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    // focus on
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    // focus out
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    // 홈
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    // 종료
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }
}