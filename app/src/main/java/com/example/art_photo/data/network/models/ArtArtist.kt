package com.example.art_photo.data.network.models

import com.squareup.moshi.Json

data class ArtArtist(
    @Json(name = "id") val id: Int=-1,
    @Json(name = "name") val name: String="undefined",
    @Json(name = "email") val email: String="undefined",
    @Json(name = "phone") val phone: String="undefined",
    @Json(name = "website") val website: String="undefined",
)