package com.example.art_photo

import OverviewFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.art_photo.data.network.ArtPhotoApi
import com.example.art_photo.data.network.models.ArtPhoto
import com.example.art_photo.databinding.ActivityMainBinding
import com.example.art_photo.overview.PhotoGridAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.http.GET


class MainActivity : AppCompatActivity() {
//    private lateinit var photoList: List<ArtPhoto>

//    lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        setupActionBarWithNavController(navController)

//        // Henter RecyclerView fra XML-filen
//        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
//
//        // Oppretter LayoutManager og setter den på RecyclerView
//        val layoutManager = LinearLayoutManager(this)
//        recyclerView.layoutManager = layoutManager
//
//        // Oppretter Adapter og setter den på RecyclerView
//        val adapter = PhotoGridAdapter { artPhoto ->
//            // Do something when item is clicked
//        }
//        recyclerView.adapter = adapter
//
//        // Henter data fra API og legger dem til i adapteret
//        GlobalScope.launch(Dispatchers.Main) {
//            val photos = ArtPhotoApi.retrofitService.getPhotos()
//            adapter.submitList(photos)
//        }

    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
