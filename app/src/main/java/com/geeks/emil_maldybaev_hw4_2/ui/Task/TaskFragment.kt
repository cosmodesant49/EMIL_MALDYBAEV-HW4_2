package com.geeks.emil_maldybaev_hw4_2.ui.Task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.geeks.emil_maldybaev_hw4_2.App
import com.geeks.emil_maldybaev_hw4_2.databinding.FragmentTaskBinding
import com.geeks.emil_maldybaev_hw4_2.model.Task

class TaskFragment : Fragment() {

    private lateinit var binding: FragmentTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaskBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.btnSave.setOnClickListener {
            if (binding.etTitle.text.isNotEmpty()) {
                save()
            } else binding.etTitle.error = "Cannot be empty"

        }
    }

    private fun save() {
        val data = Task(
            title = binding.etTitle.text.toString(),
            desc = binding.etDesc.text.toString()
        )
        App.db.taskDao().insert(data)
        findNavController().navigateUp()
    }

    companion object {
        const val TASK_RESULT_KEY = "task.result.key"
        const val TASK_KEY = "task.key"
    }
}