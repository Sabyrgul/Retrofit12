package com.geektech.retrofit12.on_board

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.geektech.retrofit12.Preferences
import com.geektech.retrofit12.R
import com.geektech.retrofit12.databinding.FragmentOnBoardPageBinding

class OnBoardPageFragment : Fragment() {

    companion object {
        const val IS_LAST_ARG = "is _last"
    }

    private var binding:FragmentOnBoardPageBinding?=null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentOnBoardPageBinding.inflate(LayoutInflater.from(context),container,false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        binding?.btnStart?.setOnClickListener {
            findNavController().navigate(R.id.requestFragment)
            Preferences(requireContext()).apply {
                setHaveSeenOnBoarding(true)
            }
        }
    }

    private fun initViews() {

        val isLast = arguments?.getBoolean(IS_LAST_ARG)
            binding?.springDotsIndicator?.attachTo((parentFragment as OnBoardListeners).getViewPager())
            val data = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                arguments?.getSerializable(BoardModel.ARG_KEY, BoardModel::class.java)
            } else {
                arguments?.getSerializable(BoardModel.ARG_KEY) as BoardModel
            }

            if (data != null) {
                binding?.apply {
                    ivOnBoardPicture.setImageResource(data.imageRes)
                    tvBig.text = data.title
                    tvSmall.text = data.description

                }

                if (isLast == true) {
                    binding?.btnStart?.visibility = View.VISIBLE
                }
            }
    }

    interface OnBoardListeners {
        fun getViewPager(): ViewPager2
    }
}