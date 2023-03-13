package com.example.art_photo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.moshi.Json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path

class MainActivity : AppCompatActivity() {
    private lateinit var photoList: List<ArtPhoto>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Henter RecyclerView fra XML-filen
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        // Oppretter LayoutManager og setter den på RecyclerView
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Oppretter Adapter og setter den på RecyclerView
        val adapter = PhotoAdapter { artPhoto ->
            // Do something when item is clicked
        }
        recyclerView.adapter = adapter

        // Henter data fra API og legger dem til i adapteret
        GlobalScope.launch(Dispatchers.Main) {
            val photos = ArtPhotoApiService.getPhotos()
            adapter.submitList(photos)
        }

        // setter opp retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com ")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // Kobler retrofit opp mot interfacet
        val jsonPlaceholderApi = retrofit.create(JsonPlaceholderApi::class.java)
    }
}

class PhotoAdapter(private val onItemClicked: (ArtPhoto) -> Unit):
    ListAdapter<ArtPhoto, PhotoAdapter.ArtPhotoViewHolder>(DiffCallback) {

    class ArtPhotoViewHolder(private var binding:
                             GridViewItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(artPhoto: ArtPhoto) {
            binding.photo = artPhoto
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ArtPhotoViewHolder {
        return ArtPhotoViewHolder(GridViewItemBinding.inflate(
            LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder:
                                  ArtPhotoViewHolder, position: Int) {
        val artPhoto = getItem(position)
        holder.itemView.setOnClickListener {
            onItemClicked(artPhoto)
        }
        holder.bind(artPhoto)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<ArtPhoto>() {
        override fun areItemsTheSame(oldItem: ArtPhoto, newItem: ArtPhoto):
                Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ArtPhoto, newItem:
        ArtPhoto): Boolean {
            return oldItem.thumbnailUrl == newItem.thumbnailUrl
        }
    }
}



interface JsonPlaceholderApi {
    @GET("/users")
    suspend fun getUsers(): List<User>

    @GET("/albums")
    suspend fun getAlbums(): List<Album>

    @GET("/photos")
    suspend fun getPhotos(): List<Photo>
}

data class ArtPhoto(
    @Json(name = "albumId") val albumId: Int=-1,
    @Json(name = "id") val id: Int=-1,
    @Json(name = "title") val title: String="undefined",
    @Json(name = "url") val url: String="undefined",
    @Json(name = "thumbnailUrl") val thumbnailUrl: String="undefined",
)

data class ArtArtist(
    @Json(name = "id") val id: Int=-1,
    @Json(name = "name") val name: String="undefined",
    @Json(name = "email") val email: String="undefined",
    @Json(name = "phone") val phone: String="undefined",
    @Json(name = "website") val website: String="undefined",
)

data class ArtAlbum(
    @Json(name = "userId") val userId: Int = -1,
    @Json(name = "id") val id: Int = -1,
    @Json(name = "title") val title: String = "undefined",
)

interface ArtPhotoApiService {
    @GET("photos")
    suspend fun getPhotos(): List<ArtPhoto>

    @GET("albums/{id}")
    suspend fun getAlbum(@Path("id") id: Int): ArtAlbum

    @GET("users/{id}")
    suspend fun getArtist(@Path("id") id: Int): ArtArtist
}
