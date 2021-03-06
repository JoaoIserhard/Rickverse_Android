package com.example.rickverse.model

data class CharacterResponse(
    val id: Int,
    val name: String,
    val status: Status,
    val species: String,
    val Gender: Gender,
    val origin: Origin,
    val image: String
)