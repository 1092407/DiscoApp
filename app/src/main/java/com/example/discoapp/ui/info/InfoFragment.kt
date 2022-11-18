package com.example.discoapp.ui.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.discoapp.R

class InfoFragment : Fragment() {





    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // val root: View = binding.root
        val root =inflater.inflate(R.layout.fragment_info,container,false )

        return root
    }


}