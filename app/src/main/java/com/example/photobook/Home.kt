package com.example.photobook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.photobook.fragments.BookingFragment
import com.example.photobook.fragments.HomeFragment
import com.example.photobook.fragments.ProfileFragment
import com.example.photobook.fragments.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class Home : AppCompatActivity() {

    private val homeFragment = HomeFragment()
    private val searchFragment = SearchFragment()
    private val bookingFragment = BookingFragment()
    private val profileFragment = ProfileFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        replaceFragment(homeFragment)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navigation_home -> replaceFragment(homeFragment)
                R.id.navigation_search -> replaceFragment(searchFragment)
                R.id.navigation_bookings -> replaceFragment(bookingFragment)
                R.id.navigation_profile -> replaceFragment(profileFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        if(fragment != null){
            val transection = supportFragmentManager.beginTransaction()
            transection.replace(R.id.fragment_container,fragment)
            transection.commit()
        }
    }
}


