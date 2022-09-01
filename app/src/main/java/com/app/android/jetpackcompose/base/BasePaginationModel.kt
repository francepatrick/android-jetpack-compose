package com.app.android.jetpackcompose.base

data class BasePaginationModel(
    val count: Int? = 0,
    val next: String,
    val previous: String? = null
)

