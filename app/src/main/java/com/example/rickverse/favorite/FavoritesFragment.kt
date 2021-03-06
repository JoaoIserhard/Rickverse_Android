package com.example.rickverse.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.rickverse.R
import kotlinx.android.synthetic.main.fragment_favorites.*

class FavoritesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lvFavorites.adapter = ArrayAdapter<Int>(
            requireContext(),
            android.R.layout.simple_expandable_list_item_1,
            arrayListOf(1, 2, 3)
        )

        lvFavorites.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(requireContext(), position.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}