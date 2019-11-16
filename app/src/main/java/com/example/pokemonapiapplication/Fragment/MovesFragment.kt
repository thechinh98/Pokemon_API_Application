package com.example.pokemonapiapplication.Fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokemonapiapplication.Activity.InformationActivity
import com.example.pokemonapiapplication.Adapter.MovesListAdapter
import com.example.pokemonapiapplication.Items.PokemonInfomation.PokemonMoves

import com.example.pokemonapiapplication.R
import com.example.pokemonapiapplication.ViewModel.InformationViewModel
import kotlinx.android.synthetic.main.activity_description.*
import kotlinx.android.synthetic.main.fragment_moves.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [MovesFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [MovesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MovesFragment : Fragment() {
    lateinit var informationViewModel: InformationViewModel
    var movesList = ArrayList<PokemonMoves>()
    var currentKey = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_moves, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        dataBinding()

    }

    private fun init() {
        informationViewModel = ViewModelProviders.of(this).get(InformationViewModel :: class.java)
        var movesListAdapter = MovesListAdapter(movesList)
        rcc_moves.adapter = movesListAdapter
        rcc_moves.layoutManager = LinearLayoutManager(activity)

        if(activity is InformationActivity){
            var activity = activity as InformationActivity
            currentKey = activity.searchKey
        }

        informationViewModel.getPokemon(currentKey)
    }

    private fun dataBinding() {
        informationViewModel.pokemon.observe(this, Observer { pokemon ->
            movesList = pokemon.moves
        })
    }


}
