package com.geeks.emil_maldybaev_hw4_2.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.persistableBundleOf
import androidx.core.widget.addTextChangedListener
import com.geeks.emil_maldybaev_hw4_2.R
import com.geeks.emil_maldybaev_hw4_2.data.local.Pref
import com.geeks.emil_maldybaev_hw4_2.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private val pref: Pref by lazy {
        Pref(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.etName.setText(pref.getName())
        binding.etName.addTextChangedListener {
            pref.rememberName(binding.etName.text.toString())
        }
    }
}