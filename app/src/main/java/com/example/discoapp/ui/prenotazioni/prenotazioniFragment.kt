package com.example.discoapp.ui.prenotazioni

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.discoapp.R




class prenotazioniFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // val root: View = binding.root
        val root =inflater.inflate(R.layout.fragment_prenotazioni,container,false )

        return root
    }


}