package io.jyryuitpro.shoppi.android.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// The application should not provide its own launch screen (Android 12, API Level 31 이후 적용)
class SplashActivity : AppCompatActivity() {
    // LayoutInflate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Activity 이동
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}