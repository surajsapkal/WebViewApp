package com.example.webviewapp.webviewActivity

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import com.example.webviewapp.R
import kotlinx.android.synthetic.main.activity_breakingnews.*
import kotlinx.android.synthetic.main.activity_movies.*

class MoviesActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        openWebView()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetJavaScriptEnabled")
    private fun openWebView() {
        webView_Movies.webViewClient = WebViewClient()
        webView_Movies.apply {
            loadUrl("https://hyflix.com/movies")
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
        }
    }

    override fun onBackPressed() {
        if (webView_Movies.canGoBack())webView_Movies.goBack()else super.onBackPressed()
    }


}