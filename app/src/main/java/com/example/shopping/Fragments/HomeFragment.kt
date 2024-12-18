package com.example.shopping.Fragments

import ImageSliderAdapter
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.shopping.R

class HomeFragment : Fragment() {

    private lateinit var viewPager: ViewPager2
    private val handler = Handler(Looper.getMainLooper())
    private var currentPage = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Setup ViewPager for images
        val images = listOf(
            R.drawable.homeapp,
            R.drawable.grocery,
            R.drawable.electronic,
            R.drawable.clothing
        )
        viewPager = view.findViewById(R.id.viewPager)
        val adapter = ImageSliderAdapter(images)
        viewPager.adapter = adapter

        startAutoSlide(images.size)

        return view
    }

    private fun startAutoSlide(totalPages: Int) {
        val slideRunnable = object : Runnable {
            override fun run() {
                if (currentPage == totalPages) {
                    currentPage = 0 // Reset to the first page when reaching the end
                }
                viewPager.setCurrentItem(currentPage++, true) // Animate to the next page
                handler.postDelayed(this, 3000) // Schedule the next slide
            }
        }
        handler.post(slideRunnable)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        handler.removeCallbacksAndMessages(null) // Stop auto-sliding when the fragment is destroyed
    }
}
