package com.example.art_photo.data.network.models

import com.squareup.moshi.Json

data class ArtAlbum(
    @Json(name = "userId") val userId: Int = -1,
    @Json(name = "id") val id: Int = -1,
    @Json(name = "title") val title: String = "undefined",
)