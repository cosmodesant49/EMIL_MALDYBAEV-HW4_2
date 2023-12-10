package com.geeks.emil_maldybaev_hw4_2.ui.auth.accept

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.geeks.emil_maldybaev_hw4_2.R
import com.geeks.emil_maldybaev_hw4_2.databinding.FragmentAcceptBinding
import com.geeks.emil_maldybaev_hw4_2.ui.auth.phone.PhoneFragment
import com.geeks.emil_maldybaev_hw4_2.utils.showToast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider


class AcceptFragment : Fragment() {

    private lateinit var binding: FragmentAcceptBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAcceptBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val verId=arguments?.getString(PhoneFragment.VER_KEY)
        binding.btnConfirm.setOnClickListener {
            val credential = PhoneAuthProvider.getCredential(verId!!, binding.etCode.text.toString())
            signInWithPhoneAuthCredential(credential)
        }

    }
    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        FirebaseAuth.getInstance().signInWithCredential(credential)
            .addOnSuccessListener {
                showToast("Успех")
                findNavController().navigate(R.id.navigation_home)
            }
            .addOnFailureListener{
                showToast(it.message.toString())
            }
    }
}