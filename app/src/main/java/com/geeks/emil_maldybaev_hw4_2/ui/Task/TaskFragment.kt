package com.geeks.emil_maldybaev_hw4_2.ui.Task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.geeks.emil_maldybaev_hw4_2.R
import com.geeks.emil_maldybaev_hw4_2.databinding.FragmentTaskBinding
import com.geeks.emil_maldybaev_hw4_2.databinding.ItemTaskBinding
import com.geeks.emil_maldybaev_hw4_2.model.Task

class TaskFragment : Fragment() {

private lateinit var binding: FragmentTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaskBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {
            val data =Task(
                title = binding.etTitle.text.toString(),
                desc = binding.etDesc.text.toString()
            )
            setFragmentResult(TASK_RESULT_KEY, bundleOf(TASK_KEY to data))

            findNavController().navigateUp()
        }
    }
    companion object{
        const val TASK_RESULT_KEY = "task.result.key"
        const val TASK_KEY = "task.key"
    }
}