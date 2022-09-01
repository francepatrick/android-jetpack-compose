package com.app.android.jetpackcompose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.app.android.jetpackcompose.model.PokedexResultModel
import com.app.android.jetpackcompose.navigation.DetailRoute

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ListViewItem(
    pokemon: PokedexResultModel,
    navHostController: NavHostController
) {

    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(125.dp), shape = RoundedCornerShape(2.dp),
        elevation = 0.dp,
        onClick = { navHostController.navigate(DetailRoute) }
    ) {
        Surface() {

            Row(
                Modifier
                    .padding(4.dp)
                    .fillMaxSize()
            ) {


                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(4.dp, 4.dp, 4.dp, 8.dp)
                        .fillMaxHeight()
                        .weight(0.7f)

                ) {
                    Text(
                        text = pokemon.name!!,
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }

}