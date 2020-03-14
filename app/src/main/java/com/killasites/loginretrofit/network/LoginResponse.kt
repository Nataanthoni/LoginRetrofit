package com.killasites.loginretrofit.network

import com.google.gson.annotations.SerializedName
import com.killasites.loginretrofit.models.User

data class LoginResponse(val error:Boolean,
                         @SerializedName("token")
                         val authToken: String,
                         val message:String,
                         val user: User
)