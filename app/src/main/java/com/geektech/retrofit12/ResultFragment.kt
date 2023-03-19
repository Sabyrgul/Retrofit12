package com.geektech.retrofit12

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.geektech.retrofit12.databinding.FragmentResultBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultFragment : Fragment() {
    private var binding: FragmentResultBinding? = null
    private var firstName = ""
    private var secondName = ""
    private val viewModel: ActivityViewModel by viewModels()

    //lateinit var slovo:java.lang.StringBuilder

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("Result tag","onViewCreated ")

        setFragmentResultListener("names") { _, bundle ->
            firstName = bundle.getString("first name").toString()
            secondName = bundle.getString("second name").toString()
            binding?.tvYou?.text = firstName
            binding?.tvMe?.text = secondName
            viewModel.makeRequest(firstName, secondName)
                .observe(viewLifecycleOwner) {
                    App.db.getCalculateDao().getAllFromHistory()
                    App.db.getCalculateDao().addCalculateModel(it)
                    binding?.tvPercentage?.text = (it.percentage+"%")
                    viewModel.livedata.postValue(it)
                }
        }

        binding?.btnTryAgain?.setOnClickListener {
            findNavController().navigate(R.id.requestFragment)
        }
    }

}