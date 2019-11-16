package com.example.pokemonapiapplication.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapiapplication.Items.PokemonInfomation.PokemonMoves
import com.example.pokemonapiapplication.R
import kotlinx.android.synthetic.main.item_moves.view.*

class MovesListAdapter(private var movesDataset : ArrayList<PokemonMoves>) : RecyclerView.Adapter<MovesListAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_moves, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount() = movesDataset.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.initView(movesDataset[position])
    }

    class MyViewHolder(var view : View) : RecyclerView.ViewHolder(view) {
        fun initView(item: PokemonMoves){
            view.txt_move_name.text= item.move.movesNames
        }
    }
}