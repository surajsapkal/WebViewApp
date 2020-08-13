package com.example.webviewapp.webviewActivity

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import com.example.webviewapp.R
import kotlinx.android.synthetic.main.activity_movies.*
import kotlinx.android.synthetic.main.activity_trending.*

class TrendingActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trending)

        openWebView()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetJavaScriptEnabled")
    private fun openWebView() {
        webView_Trending.webViewClient = WebViewClient()
        webView_Trending.apply {
            loadUrl("http://live24.network/category/trending/")
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
        }
    }

    override fun onBackPressed() {
        if (webView_Trending.canGoBack())webView_Trending.goBack()else super.onBackPressed()
    }
}