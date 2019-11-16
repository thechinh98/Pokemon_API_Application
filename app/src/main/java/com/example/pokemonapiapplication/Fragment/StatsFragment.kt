package com.example.pokemonapiapplication.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.pokemonapiapplication.Activity.InformationActivity
import com.example.pokemonapiapplication.R
import com.example.pokemonapiapplication.ViewModel.InformationViewModel
import kotlinx.android.synthetic.main.fragment_stats.*


class StatsFragment : Fragment() {
    lateinit var informationViewModel: InformationViewModel
    var currentKey = ""
    var total = 200
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_stats, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity is InformationActivity) {
            var activity = activity as InformationActivity
            currentKey = activity.searchKey
        }

        informationViewModel = ViewModelProviders.of(this).get(InformationViewModel::class.java)

        dataBinding()
    }

    private fun dataBinding() {
        //stats[0] : SPD
        //stats[1] : SDEF
        //stats[2] : SATK
        //stats[3] : DEF
        //stats[4] : ATK
        //stats[5] : HP
        informationViewModel.pokemon.observe(this, Observer { pokemon ->
            txt_spd.text = pokemon.stats[0].baseStats.toString()
            txt_sdef.text = pokemon.stats[1].baseStats.toString()
            txt_satk.text = pokemon.stats[2].baseStats.toString()
            txt_def.text = pokemon.stats[3].baseStats.toString()
            txt_atk.text = pokemon.stats[4].baseStats.toString()
            txt_hp.text = pokemon.stats[5].baseStats.toString()

            prgssB_spd.progress = pokemon.stats[0].baseStats
            prgssB_sdef.progress = pokemon.stats[1].baseStats
            prgssB_satk.progress = pokemon.stats[2].baseStats
            prgssB_def.progress = pokemon.stats[3].baseStats
            prgssB_atk.progress = pokemon.stats[4].baseStats
            prgssB_hp.progress = pokemon.stats[5].baseStats
        })
    }

    override fun onResume() {
        super.onResume()
        informationViewModel.getPokemon(currentKey)
    }
}
