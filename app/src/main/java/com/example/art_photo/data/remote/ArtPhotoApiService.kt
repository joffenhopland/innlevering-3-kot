package com.example.art_photo.data.remote

import com.example.art_photo.data.remote.models.ArtAlbum
import com.example.art_photo.data.remote.models.ArtArtist
import com.example.art_photo.data.remote.models.ArtPhoto

interface ArtPhotoApiService {
    @GET("photos")
    suspend fun getPhotos(): List<ArtPhoto>

    @GET("albums/{id}")
    suspend fun getAlbum(@Path("id") id: Int): ArtAlbum

    @GET("users/{id}")
    suspend fun getArtist(@Path("id") id: Int): ArtArtist
}