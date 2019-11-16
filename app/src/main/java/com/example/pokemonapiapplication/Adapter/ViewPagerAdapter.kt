package com.example.pokemonapiapplication.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.pokemonapiapplication.Fragment.BlankFragment
import com.example.pokemonapiapplication.Fragment.MovesFragment
import com.example.pokemonapiapplication.Fragment.StatsFragment

class ViewPagerAdapter(fragmentManager : FragmentManager, var statsFragment: StatsFragment, var movesFragment: MovesFragment) : FragmentPagerAdapter(fragmentManager){
    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> {
                return statsFragment
            }
            2 -> {
                return movesFragment
            }
        }
        return BlankFragment()
    }

    override fun getCount() = 3

}