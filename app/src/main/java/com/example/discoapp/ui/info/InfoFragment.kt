package com.example.discoapp.ui.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.discoapp.R
import com.example.discoapp.databinding.FragmentHomeBinding
import com.example.discoapp.databinding.FragmentInfoBinding

class InfoFragment : Fragment() {

    private var _binding: FragmentInfoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // val root: View = binding.root
        val root =inflater.inflate(R.layout.fragment_info,container,false )


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}