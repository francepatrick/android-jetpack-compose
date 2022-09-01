package com.app.android.jetpackcompose.viewmodel.pokemon

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.app.android.jetpackcompose.api.Api
import com.app.android.jetpackcompose.base.BaseViewModel
import com.app.android.jetpackcompose.model.PokedexModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(private val apiService: Api) : BaseViewModel() {

    var pokedexList: PokedexModel by mutableStateOf(
        PokedexModel(
            count = 0,
            next = null,
            previous = null,
            results = arrayListOf()
        )
    )

    fun getPokedex() {
        viewModelScope.launch {
            try {
                pokedexList = apiService.pokedex()
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}