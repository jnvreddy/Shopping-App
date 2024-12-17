package com.example.shopping

import ImageSliderAdapter
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager2.widget.ViewPager2
import com.example.shopping.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit  var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navigationView: NavigationView = findViewById(R.id.nav_view)

        binding.toolbar.ivBurgerMenu.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    // Handle Home button click
                    Toast.makeText(this, "Home clicked", Toast.LENGTH_SHORT).show()
                }

                R.id.nav_settings -> {
                    // Handle Settings button click
                    Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show()
                }

                R.id.nav_share -> {
                    // Handle Share button click
                    Toast.makeText(this, "Share clicked", Toast.LENGTH_SHORT).show()
                }

                R.id.nav_logout -> {
                    // Handle Logout button click
                    Toast.makeText(this, "Logged out successfully", Toast.LENGTH_SHORT).show()

                }
            }

            // Close the navigation drawer after an item is selected
            drawerLayout.closeDrawers()
            true
        }


        val images = listOf(
            R.drawable.homeapp,
            R.drawable.grocery,
            R.drawable.electronic,
            R.drawable.clothing
        )

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val adapter = ImageSliderAdapter(images)

        viewPager.adapter = adapter

    }
}