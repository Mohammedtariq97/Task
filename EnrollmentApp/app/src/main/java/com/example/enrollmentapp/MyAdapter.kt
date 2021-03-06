package com.example.enrollmentapp

import android.content.Context
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter

@Suppress("DEPRECATION")
class MyAdapter(var context: Context, private val fm:FragmentManager, private var totalTabs:Int)
    : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        Log.d("MyAdapter","getCount called")
        return totalTabs
    }

    override fun getItem(position: Int): Fragment {
        Log.d("MyAdapter","getItem called")
        return when (position) {
            0 -> {
                UsersFragment()
            }
            1 -> {
                EnrollFragment()
            }
            else ->{
                getItem(position)
            }
        }
    }

}