package com.killasites.loginretrofit.network


import com.google.gson.annotations.SerializedName

data class ListingsResponse(
    val error: Boolean,
    val listings: List<Listings>
)