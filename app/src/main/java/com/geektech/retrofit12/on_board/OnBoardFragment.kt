package com.geektech.retrofit12.on_board

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.geektech.retrofit12.Preferences
import com.geektech.retrofit12.R
import com.geektech.retrofit12.databinding.FragmentOnBoardBinding


class OnBoardFragment : Fragment(), OnBoardPageFragment.OnBoardListeners {

    private var binding: FragmentOnBoardBinding? = null
    private var boardAdapter: OnBoardAdapter? = null
    private var boardModels = listOf(

        BoardModel(
            imageRes = R.drawable.on_board2,
            title = "Have a good time",
            description = "You should take the time to help those who need you"
        ),
        BoardModel(
            imageRes = R.drawable.on_board3,
            title = "Cherishing love",
            description = "It is now no longer possible for you to cherish love"
        ),
        BoardModel(
            imageRes = R.drawable.on_board3,
            title = "Have a breakup?",
            description = "We have made the correction for you \ndon't worry. \nMay be someone is waiting for you"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentOnBoardBinding.inflate(LayoutInflater.from(context),container,false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        boardAdapter = OnBoardAdapter(
            childFragmentManager, lifecycle, boardModels
        )

        binding?.viewpager?.adapter = boardAdapter
    }


    override fun getViewPager(): ViewPager2 {
        return binding?.viewpager!!
    }


}

