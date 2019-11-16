package com.example.pokemonapiapplication.Activity

import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ScrollView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.example.pokemonapiapplication.Adapter.ViewPagerAdapter
import com.example.pokemonapiapplication.Fragment.MovesFragment
import com.example.pokemonapiapplication.Fragment.StatsFragment
import com.example.pokemonapiapplication.R
import com.example.pokemonapiapplication.ViewModel.InformationViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_description.*
import kotlinx.android.synthetic.main.fragment_moves.*

class InformationActivity : AppCompatActivity() {

    private lateinit var informationViewModel: InformationViewModel
    var statsFragment = StatsFragment()
    var movesFragment = MovesFragment()
    var searchKey = "0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)
        init()
        dataBinding()

    }

    private fun dataBinding() {
        informationViewModel.pokemon.observe(this, Observer { pokemon ->
            txt_name.text = pokemon.name

            Picasso.with(this).load(pokemon.sprites.imgUrl).into(img_ava)
            layout_loading.visibility = View.GONE
        })
        informationViewModel.pokemonDescription.observe(this, Observer { pokemonDescription ->
            txt_description.text = pokemonDescription.flavorTextList[1].description
        })
    }

    private fun init() {
        informationViewModel = ViewModelProviders.of(this).get(InformationViewModel::class.java)

        searchKey = intent.getStringExtra("pokemon_key")
        layout_loading.visibility = View.VISIBLE

        var pagerAdapter = ViewPagerAdapter(supportFragmentManager, statsFragment, movesFragment)
        view_pager.adapter = pagerAdapter

        btn_close.setOnClickListener {
            finish()
        }

        btn_stats.setOnClickListener {
            view_pager.currentItem = 0
        }

        btn_moves.setOnClickListener {
            view_pager.currentItem = 2
            scroll_view.fullScroll(ScrollView.FOCUS_UP)
        }

        view_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            @TargetApi(Build.VERSION_CODES.M)
            @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
            override fun onPageSelected(position: Int) {
                when (position){
                    0 ->{
                        btn_stats.setTextAppearance(R.style.button_style)
                        btn_stats.setBackgroundResource(R.drawable.button_box)
                        btn_moves.setTextAppearance(R.style.button_style_unselected)
                        btn_moves.setBackgroundResource(R.drawable.button_box_unselected)
                    }
                    1 ->{

                    }
                    2 -> {
                        btn_stats.setTextAppearance(R.style.button_style_unselected)
                        btn_stats.setBackgroundResource(R.drawable.button_box_unselected)
                        btn_moves.setTextAppearance(R.style.button_style)
                        btn_moves.setBackgroundResource(R.drawable.button_box)
                    }
                }
            }


        })
    }

    override fun onResume() {
        super.onResume()
        informationViewModel.getPokemon(searchKey)
        informationViewModel.getPokemonDescription(searchKey)
    }

}
