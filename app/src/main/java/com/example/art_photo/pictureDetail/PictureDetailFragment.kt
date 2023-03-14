package com.example.art_photo.pictureDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.art_photo.R
import com.example.art_photo.databinding.FragmentPictureDetailBinding
import com.example.art_photo.startScreen.StartScreenFragmentDirections

/**
 * This fragment shows the detail of each picture.
 */

class PictureDetailFragment: Fragment(R.layout.fragment_picture_detail) {
    private var _binding: FragmentPictureDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPictureDetailBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.pictureToStartBtn.setOnClickListener {
            val action = PictureDetailFragmentDirections.actionPictureDetailFragmentToStartScreenFragment()
            view.findNavController().navigate(action)
        }
        binding.pictureToOverviewBtn.setOnClickListener {
            val action = PictureDetailFragmentDirections.actionPictureDetailFragmentToOverviewFragment()
            view.findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        _binding = null

        super.onDestroyView()
    }

}