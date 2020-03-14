package com.killasites.loginretrofit.services

import com.killasites.loginretrofit.constants.Constants
import com.killasites.loginretrofit.network.ListingsResponse
import com.killasites.loginretrofit.network.LoginResponse
import retrofit2.Call
import retrofit2.http.*

interface Api{
    @FormUrlEncoded
    @POST(Constants.LOGIN_URL)
    fun userLogin(
        @Field("email") email:String,
        @Field("password") password: String
    ):Call<LoginResponse>


    @POST("listings")
    fun getListings(@Header("Authorization") token: String)

            :Call<ListingsResponse>
}