package com.geektech.retrofit12.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.geektech.retrofit12.ActivityViewModel
import com.geektech.retrofit12.App
import com.geektech.retrofit12.CalculateModel
import com.geektech.retrofit12.databinding.FragmentHistoryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment : Fragment(),IItemClick {

    private val viewModel: ActivityViewModel by viewModels()
    private var binding:FragmentHistoryBinding?=null
    private val historyAdapter = HistoryAdapter(mutableListOf(),this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentHistoryBinding.inflate(LayoutInflater.from(context),container,false)
        return binding!!.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.rvList?.adapter=historyAdapter
        newList()
    }

    private fun newList() {
        val tasks =App?.db?.getCalculateDao()?.getAllFromHistory()
        val calculateModels = tasks?.map {
            CalculateModel(
                firstName = it.firstName,
                secondName = it.secondName,
                percentage = it.percentage,
                result = it.result
            )
        }
        calculateModels?.let {
            historyAdapter.renew(it)
        }
    }

    override fun delete(position: Int) {
        Toast.makeText(requireContext(), "Successful position:$position", Toast.LENGTH_LONG).show()
        historyAdapter.delete(position)
       newList()
    }


}