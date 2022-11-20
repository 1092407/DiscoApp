package com.example.discoapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.discoapp.databinding.FragmentHomeBinding


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.discoapp.authentication.LoginActivity
import com.example.discoapp.authentication.RegisterActivity
import com.example.discoapp.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    //per funzioni di auth
    private lateinit var user: FirebaseAuth

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*  commentata perche ho tolto il texthome dal layout predefinito
        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        */





        return root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.logoutbutton.setOnClickListener {

            Firebase.auth.signOut()
            val login = Intent(activity?.applicationContext, LoginActivity::class.java)

            ///////////
            activity?.finish()
            /////////
            activity?.startActivity(login)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}