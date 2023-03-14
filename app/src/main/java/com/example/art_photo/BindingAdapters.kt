package com.example.art_photo

import android.widget.ImageView
import androidx.core.net.toUri
import coil.load
import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.art_photo.data.network.models.ArtPhoto
import com.example.art_photo.overview.ArtPhotoApiStatus
import com.example.art_photo.overview.PhotoGridAdapter


/**
 * Updates the data shown in the [RecyclerView].
 */
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<ArtPhoto>?) {
    val adapter = recyclerView.adapter as PhotoGridAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}

/**
 * This binding adapter displays the [ArtPhotoApiStatus] of the network request in an image view.  When
 * the request is loading, it displays a loading_animation.  If the request has an error, it
 * displays a broken image to reflect the connection error.  When the request is finished, it
 * hides the image view.
 */
@BindingAdapter("artPhotoApiStatus")
fun bindStatus(statusImageView: ImageView, status: ArtPhotoApiStatus) {
    when (status) {
        ArtPhotoApiStatus.LOADING -> {
            print("B001: LOADING")
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        ArtPhotoApiStatus.ERROR -> {
            print("B002: ERROR")
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        ArtPhotoApiStatus.DONE -> {
            print("B003: DONE")
            statusImageView.visibility = View.GONE
        }
    }
}