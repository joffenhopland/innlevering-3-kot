package com.example.art_photo.startScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.art_photo.R
import com.example.art_photo.databinding.FragmentStartScreenBinding



/**
 * This fragment is transaction overview and start screen for the app
 */

class StartScreenFragment : Fragment(R.layout.fragment_start_screen) {
    private var _binding: FragmentStartScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartScreenBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.startToOverviewBtn.setOnClickListener {
            val action = StartScreenFragmentDirections.actionStartScreenFragmentToOverviewFragment()
            view.findNavController().navigate(action)
        }
        //binding.startToEmailBtn.setOnClickListener {
        //      Create an e-mail with completed order etc.
        //}


        // UNDER:MIDLERTIDIG FOR Å KUNNE TESTE NAV
        binding.startToEmailBtn.setOnClickListener {
            val action = StartScreenFragmentDirections.actionStartScreenFragmentToPictureDetailFragment()
            view.findNavController().navigate(action)
        }
        //HUSKE Å SLETT MIDLERTIDIG KODE _HER_ OG FORBINDELSEN I NAV-GRAPH

    }

    override fun onDestroyView() {
        _binding = null

        super.onDestroyView()
    }
}