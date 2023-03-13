package com.example.art_photo.data.network

import com.example.art_photo.data.network.models.ArtAlbum
import com.example.art_photo.data.network.models.ArtArtist
import com.example.art_photo.data.network.models.ArtPhoto
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


private const val BASE_URL =
    "https://jsonplaceholder.typicode.com"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface ArtPhotoApiService {
    @GET("photos")
    suspend fun getPhotos(): List<ArtPhoto>

    @GET("albums/{id}")
    suspend fun getAlbum(@Path("id") id: Int): ArtAlbum

    @GET("users/{id}")
    suspend fun getArtist(@Path("id") id: Int): ArtArtist
}

// This is the public singleton object that can be accessed from the rest of the app.
// A public Api object that exposes the lazy-initialized Retrofit service
object ArtPhotoApi {
    val retrofitService : ArtPhotoApiService by lazy {
        retrofit.create(ArtPhotoApiService::class.java) }
}
