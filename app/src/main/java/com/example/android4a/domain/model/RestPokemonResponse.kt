package com.example.android4a.domain.model

class RestPokemonResponse{
    private val count: Int? = null
    private val next: String? = null
    private val results: MutableList<Pokemon>? = null

    fun getCount(): Int? {
        return count
    }

    fun getNext(): String? {
        return next
    }

    fun getResults(): MutableList<Pokemon>? {
        return results
    }
}