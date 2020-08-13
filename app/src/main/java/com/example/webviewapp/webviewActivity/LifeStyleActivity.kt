package com.example.webviewapp.webviewActivity

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import com.example.webviewapp.R
import kotlinx.android.synthetic.main.activity_life_style.*
import kotlinx.android.synthetic.main.activity_pilupu_tv.*

class LifeStyleActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_style)

        openWebView()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetJavaScriptEnabled")
    private fun openWebView() {
        webView_LifeStyle.webViewClient = WebViewClient()
        webView_LifeStyle.apply {
            loadUrl("https://www.youtube.com/channel/UCJyGuwnY9tL4EXGGj7bmkjQ")
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
        }
    }

    override fun onBackPressed() {
        if (webView_LifeStyle.canGoBack())webView_LifeStyle.goBack()else super.onBackPressed()
    }
}