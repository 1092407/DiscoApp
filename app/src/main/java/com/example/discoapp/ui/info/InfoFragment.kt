package com.example.discoapp.ui.info






import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
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


        _binding = FragmentInfoBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*  commentata perche ho tolto il texthome dal layout predefinito
        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        */



        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

//questo era prima per vedere se camniando andava

/*
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


 */