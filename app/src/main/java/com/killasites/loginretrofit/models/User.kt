package com.killasites.loginretrofit.models


import com.google.gson.annotations.SerializedName

data class User(
        val id: Int,
        val fname: String,
        val lname: String,
        val phone: String,
        val locality: String,
        val address: String,
        val city: String,
        @SerializedName("profile_pic")
        val profilePic: String,
        val company: String,
        val about: String,
        @SerializedName("preferred_comm")
        val preferredComm: String,
        val email: String,
        @SerializedName("email_verified_at")
        val emailVerifiedAt: Any,
        @SerializedName("created_at")
        val createdAt: String,
        @SerializedName("updated_at")
        val updatedAt: String,
        val password: String
)