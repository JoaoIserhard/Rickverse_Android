package com.example.rickverse.character

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rickverse.R
import com.example.rickverse.character.adapter.CharacterAdapter
import com.example.rickverse.extension.showToast
import com.example.rickverse.model.CharacterPreview
import com.example.rickverse.model.CharactersResponse
import com.example.rickverse.service.RetrofitClient
import com.example.rickverse.util.GridSpacingItemDecoration
import kotlinx.android.synthetic.main.fragment_characters.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CharactersFragment : Fragment() {

    private lateinit var charactersAdapter: CharacterAdapter

    private var hasNextPage: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_characters, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUI()
        getCharacters()
    }

    private fun setUI() {
        with(rvCharacter) {
            charactersAdapter = CharacterAdapter(
                mutableListOf(),
                this@CharactersFragment::onClick
            )

            adapter = charactersAdapter

            addItemDecoration(
                GridSpacingItemDecoration(
                    resources.getDimensionPixelSize(
                        R.dimen.margin_inside
                    )
                )
            )
        }

    }

    private fun getCharacters(page: Int? = null) {
        activity?.showToast(messageId = R.string.loading)

        RetrofitClient
            .getCharactersService()
            .getAll(page)
            .enqueue(object : Callback<CharactersResponse> {

                override fun onResponse(
                    call: Call<CharactersResponse>?,
                    response: Response<CharactersResponse>?
                ) {
                    response?.takeIf { it.isSuccessful }?.run {
                        body()?.run {
                            hasNextPage = info.next.isNullOrEmpty().not()
                            charactersAdapter.addItems(characters)
                        }
                    } ?: activity?.showToast()
                }

                override fun onFailure(call: Call<CharactersResponse>?, t: Throwable?) {
                    activity?.showToast()
                }
            })
    }

    private fun onClick(id: Int) {
        startActivity(Intent(requireContext(), CharacterActivity::class.java).apply {
            putExtra(CHARACTER_ID, id)
        })
    }
}