package com.app.android.arkboilerplate.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.app.android.jetpackcompose.components.ListViewItem
import com.app.android.jetpackcompose.model.PokedexResultModel
import com.app.android.jetpackcompose.viewmodel.pokemon.PokemonViewModel


@Composable
fun HomeScreen(navHostController: NavHostController) {
    val pokemonViewModel: PokemonViewModel = hiltViewModel();

    LaunchedEffect(Unit) {
        pokemonViewModel.getPokedex()
    }
    Scaffold {
        LazyColumn {
            itemsIndexed(
                items = pokemonViewModel.pokedexList.results as List<PokedexResultModel>
            )
            { _, item ->
                ListViewItem(pokemon = item, navHostController)
                Divider(color = Color.LightGray)
            }


        }

    }
}

