package com.geektech.retrofit12

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.geektech.retrofit12.databinding.FragmentResultBinding
import retrofit2.Call
import retrofit2.Response

class ResultFragment : Fragment() {
   private var binding: FragmentResultBinding?=null
    private var firstName=""
    private var secondName=""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding=FragmentResultBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener("names"){ _, bundle ->
            firstName= bundle.getString("first name").toString()
            secondName= bundle.getString("second name").toString()
            binding?.tvYou?.text=firstName
            binding?.tvMe?.text=secondName
            makeRequest()
        }
        binding?.btnTryAgain?.setOnClickListener {
            findNavController().navigate(R.id.requestFragment)
        }
    }
    private fun makeRequest() {

        App.api.getPercentage(firstName, secondName).enqueue(

            object: retrofit2.Callback<CalculateModel>{
                override fun onResponse(
                    call: Call<CalculateModel>,
                    response: Response<CalculateModel>,
                ) {
                     binding?.tvPercentage?.text=(response.body()?.percentage+"%")
                }

                override fun onFailure(call: Call<CalculateModel>, t: Throwable) {
                    Toast.makeText(requireContext(), "${t.stackTrace}", Toast.LENGTH_SHORT).show()
                }

            }
        )

    }

}