package com.example.rickverse.character

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rickverse.R

const val CHARACTER_ID = "characterId"

class CharacterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character)
        setUI()
    }

    private fun setUI() {}

}