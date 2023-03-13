package com.example.art_photo.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.art_photo.data.network.models.ArtPhoto
import com.example.art_photo.databinding.GridViewItemBinding

class PhotoGridAdapter
//    (private val onItemClicked: (ArtPhoto) -> Unit)
    :
    ListAdapter<ArtPhoto, PhotoGridAdapter.ArtPhotoViewHolder>(DiffCallback) {

    class ArtPhotoViewHolder(private var binding:
                             GridViewItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(artPhoto: ArtPhoto) {
            binding.photo = artPhoto
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ArtPhotoViewHolder {
        return ArtPhotoViewHolder(
            GridViewItemBinding.inflate(
            LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder:
                                  ArtPhotoViewHolder, position: Int) {
        val artPhoto = getItem(position)
        holder.itemView.setOnClickListener {
//            onItemClicked(artPhoto)
        }
        holder.bind(artPhoto)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<ArtPhoto>() {
        override fun areItemsTheSame(oldItem: ArtPhoto, newItem: ArtPhoto):
                Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ArtPhoto, newItem:
        ArtPhoto
        ): Boolean {
            return oldItem.thumbnailUrl == newItem.thumbnailUrl
        }
    }



}