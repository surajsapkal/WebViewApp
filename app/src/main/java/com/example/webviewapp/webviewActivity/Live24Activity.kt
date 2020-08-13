package com.example.webviewapp.webviewActivity

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import com.example.webviewapp.R
import kotlinx.android.synthetic.main.activity_live24.*
import kotlinx.android.synthetic.main.activity_web_series.*

class Live24Activity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live24)

        openWebView()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetJavaScriptEnabled")
    private fun openWebView() {
        webView_Live24.webViewClient = WebViewClient()
        webView_Live24.apply {
            loadUrl("http://live24.network/")
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
        }
    }

    override fun onBackPressed() {
        if (webView_Live24.canGoBack())webView_Live24.goBack()else super.onBackPressed()
    }
}