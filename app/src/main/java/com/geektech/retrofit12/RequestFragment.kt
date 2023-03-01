package com.geektech.retrofit12

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.geektech.retrofit12.databinding.FragmentRequestBinding
import retrofit2.Call
import retrofit2.Response

class RequestFragment : Fragment() {

    private var binding:FragmentRequestBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding=FragmentRequestBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClick()
    }
    private fun onClick() {
        binding?.btnRequest?.setOnClickListener {
            val bundle=Bundle().apply {
            putString("first name",binding?.etFirstName?.text.toString())
            putString("second name",binding?.etSecondName?.text.toString())
        }
            setFragmentResult("names",bundle)
            
            findNavController().navigate(R.id.resultFragment)
        }
    }

}