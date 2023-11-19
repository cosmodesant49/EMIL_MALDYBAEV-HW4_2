package com.geeks.emil_maldybaev_hw4_2.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.geeks.emil_maldybaev_hw4_2.R
import com.geeks.emil_maldybaev_hw4_2.databinding.FragmentHomeBinding
import com.geeks.emil_maldybaev_hw4_2.model.Task
import com.geeks.emil_maldybaev_hw4_2.ui.Task.TaskFragment
import com.geeks.emil_maldybaev_hw4_2.ui.Task.TaskFragment.Companion.TASK_KEY
import com.geeks.emil_maldybaev_hw4_2.ui.Task.TaskFragment.Companion.TASK_RESULT_KEY
import com.geeks.emil_maldybaev_hw4_2.ui.home.adapter.TaskAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val adapter = TaskAdapter()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        setFragmentResultListener(TASK_RESULT_KEY) { _, bundle ->
            val data = bundle.getSerializable(TASK_KEY) as Task
            adapter.addTask(data)
        }
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}