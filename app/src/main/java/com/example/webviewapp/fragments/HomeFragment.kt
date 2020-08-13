package com.example.webviewapp.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.webviewapp.R
import com.example.webviewapp.webviewActivity.*

class HomeFragment : Fragment(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v :View = inflater.inflate(R.layout.fragment_home, container, false)

        val img_movies = v.findViewById<ImageView>(R.id.img_movies)
        img_movies.setOnClickListener(this)

        val img_trending = v.findViewById<ImageView>(R.id.img_trending)
        img_trending.setOnClickListener(this)

        val img_viral_news = v.findViewById<ImageView>(R.id.img_viral_news)
        img_viral_news.setOnClickListener(this)

        val img_pilupu_tv = v.findViewById<ImageView>(R.id.img_pilupu_tv)
        img_pilupu_tv.setOnClickListener(this)

        val img_breaking_news = v.findViewById<ImageView>(R.id.img_breaking_news)
        img_breaking_news.setOnClickListener(this)

        val img_life_style = v.findViewById<ImageView>(R.id.img_life_style)
        img_life_style.setOnClickListener(this)

        val img_interview = v.findViewById<ImageView>(R.id.img_interview)
        img_interview.setOnClickListener(this)

        val img_web_series = v.findViewById<ImageView>(R.id.img_web_series)
        img_web_series.setOnClickListener(this)

        val img_live_24 = v.findViewById<ImageView>(R.id.img_live_24)
        img_live_24.setOnClickListener(this)

        return v

    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.img_movies ->{
                activity?.let {
                    startActivity(Intent(it, MoviesActivity::class.java))
                }
            }
            R.id.img_trending ->{
                activity?.let {
                    startActivity(Intent(it, TrendingActivity::class.java))
                }
            }
            R.id.img_viral_news ->{
                activity?.let {
                    startActivity(Intent(it, ViralNewsActivity::class.java))
                }
            }
            R.id.img_pilupu_tv ->{
                activity?.let {
                    startActivity(Intent(it, PilupuTvActivity::class.java))
                }
            }
            R.id.img_breaking_news ->{
                activity?.let {
                    startActivity(Intent(it, BreakingnewsActivity::class.java))
                }
            }
            R.id.img_life_style ->{
                activity?.let {
                    startActivity(Intent(it, LifeStyleActivity::class.java))
                }
            }
            R.id.img_interview ->{
                activity?.let {
                    startActivity(Intent(it, InterviewActivity::class.java))
                }
            }
            R.id.img_web_series ->{
                activity?.let {
                    startActivity(Intent(it, WebSeriesActivity::class.java))
                }
            }
            R.id.img_live_24 ->{
                activity?.let {
                    startActivity(Intent(it, Live24Activity::class.java))
                }
            }
        }
    }

}