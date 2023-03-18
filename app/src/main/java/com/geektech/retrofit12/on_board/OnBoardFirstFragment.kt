package com.geektech.retrofit12.on_board

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.geektech.retrofit12.Preferences
import com.geektech.retrofit12.R
import com.geektech.retrofit12.databinding.FragmentOnBoardFirstBinding


class OnBoardFirstFragment : Fragment() {
     private var binding:FragmentOnBoardFirstBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentOnBoardFirstBinding.inflate(LayoutInflater.from(context),container,false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.btnStart?.setOnClickListener {
            findNavController().navigate(R.id.onBoardFragment)
        }
    }
}