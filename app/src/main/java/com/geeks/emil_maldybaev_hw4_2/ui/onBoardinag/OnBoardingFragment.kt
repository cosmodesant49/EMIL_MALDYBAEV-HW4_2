package com.geeks.emil_maldybaev_hw4_2.ui.onBoardinag

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.geeks.emil_maldybaev_hw4_2.R
import com.geeks.emil_maldybaev_hw4_2.databinding.FragmentOnBoardingBinding
import com.geeks.emil_maldybaev_hw4_2.ui.onBoardinag.adapter.OnBoardingAdapter
import me.relex.circleindicator.CircleIndicator3


class OnBoardingFragment : Fragment() {
    private lateinit var binding: FragmentOnBoardingBinding
    private val adapter = OnBoardingAdapter(this::onClick)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardingBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewPager2: ViewPager2 = binding.viewpager2

        viewPager2.adapter = adapter

        val indicator: CircleIndicator3 = binding.indicator

        indicator.setViewPager(viewPager2)

    }
    private fun onClick(){
        findNavController().navigate(R.id.navigation_home)

    }
}