package com.example.androidexercise

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter (fragment: FragmentActivity): FragmentStateAdapter(fragment){

    private val fragmentList = mutableListOf<Fragment>()
    private val fragmentTitle = mutableListOf<String>()

    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
    fun addFragment(fragment: Fragment, title: String){
        fragmentList.add(fragment)
        fragmentTitle.add(title)
    }
    fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitle[position]
    }

}