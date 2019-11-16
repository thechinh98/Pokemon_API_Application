package com.example.pokemonapiapplication.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.pokemonapiapplication.R
import com.example.pokemonapiapplication.ViewModel.InformationViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_search.setOnClickListener {
            var search = etxt_search.text.toString()
            var informationIntent = Intent(this, InformationActivity::class.java)
            var informationViewModel = ViewModelProviders.of(this).get(InformationViewModel :: class.java)
            if(informationViewModel.getPokemon(search) != null ){
                informationIntent.putExtra("pokemon_key", search)
                startActivity(informationIntent)
            } else {
                Toast.makeText(this, "Not Found", Toast.LENGTH_SHORT).show()
            }

        }


    }
}
