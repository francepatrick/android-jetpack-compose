package com.app.android.jetpackcompose.model

data class PokedexModel(
    val count: Int? = 0,
    val next: String? = "",
    val previous: String? = null,
    val results: ArrayList<PokedexResultModel>? = ArrayList()
)

data class PokedexResultModel(
    val name: String? = "",
    val url: String? = "",
)