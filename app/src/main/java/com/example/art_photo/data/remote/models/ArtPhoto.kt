package com.example.art_photo.data.remote.models

data class ArtPhoto(
    @Json(name = "albumId") val albumId: Int=-1,
    @Json(name = "id") val id: Int=-1,
    @Json(name = "title") val title: String="undefined",
    @Json(name = "url") val url: String="undefined",
    @Json(name = "thumbnailUrl") val thumbnailUrl: String="undefined",
)