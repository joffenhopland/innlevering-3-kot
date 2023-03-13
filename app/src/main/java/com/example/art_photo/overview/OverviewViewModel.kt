package com.example.art_photo.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.art_photo.data.network.ArtPhotoApi
import androidx.lifecycle.viewModelScope
import com.example.art_photo.data.network.models.ArtPhoto
import kotlinx.coroutines.launch

enum class ArtPhotoApiStatus { LOADING, ERROR, DONE }

/**
 * The [ViewModel] that is attached to the [OverviewFragment].
 */
class OverviewViewModel : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<ArtPhotoApiStatus>()

    // The external immutable LiveData for the request status
    val status: LiveData<ArtPhotoApiStatus> = _status

    // Internally, we use a MutableLiveData, because we will be updating the List of ArtPhoto
    // with new values
    private val _photos = MutableLiveData<List<ArtPhoto>>()

    // The external LiveData interface to the property is immutable, so only this class can modify
    val photos: LiveData<List<ArtPhoto>> = _photos

    /**
     * Call getArtPhotos() on init so we can display status immediately.
     */
    init {
        getArtPhotos()
    }

    /**
     * Gets ArtPhotos information from the ArtPhoto API Retrofit service and updates the
     * [ArtPhotoPhoto] [List] [LiveData].
     */
    private fun getArtPhotos() {

        viewModelScope.launch {
            _status.value = ArtPhotoApiStatus.LOADING
            try {
                _photos.value = ArtPhotoApi.retrofitService.getPhotos()
                _status.value = ArtPhotoApiStatus.DONE
            } catch (e: Exception) {
                _status.value = ArtPhotoApiStatus.ERROR
                _photos.value = listOf()
            }
        }
    }
}
