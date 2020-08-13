package com.example.webviewapp.webviewActivity

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import com.example.webviewapp.R
import kotlinx.android.synthetic.main.activity_trending.*
import kotlinx.android.synthetic.main.activity_viral_news.*

class ViralNewsActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viral_news)

        openWebView()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetJavaScriptEnabled")
    private fun openWebView() {
        webView_ViralNews.webViewClient = WebViewClient()
        webView_ViralNews.apply {
            loadUrl("https://hyflix.com/live-news")
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
        }
    }

    override fun onBackPressed() {
        if (webView_ViralNews.canGoBack())webView_ViralNews.goBack()else super.onBackPressed()
    }
}