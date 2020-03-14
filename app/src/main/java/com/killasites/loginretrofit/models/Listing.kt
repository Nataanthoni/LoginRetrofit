package com.killasites.loginretrofit.models

import com.google.gson.annotations.SerializedName

data class Listing (
        val id: Int,
        @SerializedName("property_id")
        val propertyId: String,
        val title: String,
        @SerializedName("property_category")
        val propertyCategory: String,
        @SerializedName("property_type")
        val propertyType: String,
        @SerializedName("listing_status")
        val listingStatus: String,
        val amount: Int,
        val currency: String,
        val description: String,
        @SerializedName("year_built")
        val yearBuilt: String,
        val locality: String,
        val address: String,
        val city: String,
        @SerializedName("room_numbers")
        val roomNumbers: String,
        @SerializedName("bed_numbers")
        val bedNumbers: String,
        @SerializedName("bathroom_numbers")
        val bathroomNumbers: String,
        val furnishing: String,
        @SerializedName("available_by")
        val availableBy: String,
        @SerializedName("suitable_for")
        val suitableFor: String,
        val gated: String,
        @SerializedName("min_stay")
        val minStay: String,
        val features: String,
        @SerializedName("smoking_allowed")
        val smokingAllowed: String,
        @SerializedName("parties_allowed")
        val partiesAllowed: String,
        @SerializedName("listing_image")
        val listingImage: String,
        @SerializedName("listing_image2")
        val listingImage2: String,
        @SerializedName("listing_image3")
        val listingImage3: String,
        @SerializedName("listing_image4")
        val listingImage4: String,
        @SerializedName("listing_image5")
        val listingImage5: String,
        val negotiable: Any)
