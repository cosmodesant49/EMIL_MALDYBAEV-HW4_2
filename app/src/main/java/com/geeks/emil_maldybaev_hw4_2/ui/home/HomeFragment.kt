package com.geeks.emil_maldybaev_hw4_2.ui.home

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.geeks.emil_maldybaev_hw4_2.App
import com.geeks.emil_maldybaev_hw4_2.R
import com.geeks.emil_maldybaev_hw4_2.databinding.FragmentHomeBinding
import com.geeks.emil_maldybaev_hw4_2.model.Task
import com.geeks.emil_maldybaev_hw4_2.ui.Task.TaskFragment
import com.geeks.emil_maldybaev_hw4_2.ui.Task.TaskFragment.Companion.TASK_KEY
import com.geeks.emil_maldybaev_hw4_2.ui.Task.TaskFragment.Companion.TASK_RESULT_KEY
import com.geeks.emil_maldybaev_hw4_2.ui.home.adapter.TaskAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val adapter = TaskAdapter(this::onLongClickItem,this::onClickItem)

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
        val data = App.db.taskDao().getAll()
        adapter.addTask(data)
        Log.e("ololo", "onViewCreated" + data)
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)
        }
    }

    private fun onLongClickItem(task: Task) {
        showAlertDialog(task)
    }
    private fun onClickItem(task: Task) {
        showAlertDialog2(task)
    }

    private fun showAlertDialog(task: Task) {
        val alertDialog = AlertDialog.Builder(requireContext())
        alertDialog.setTitle(task.title)
            .setMessage("You really want to delete this text?")
            .setCancelable(true)
            .setPositiveButton("Delete") { _, _ ->
                App.db.taskDao().delete(task)
                val data = App.db.taskDao().getAll()
                adapter.addTask(data)
            }
            .setNegativeButton("Save") { _, _ -> }
            .show()

    }
    private fun showAlertDialog2(task: Task) {
        val alertDialog = AlertDialog.Builder(requireContext())
        alertDialog.setTitle(task.title)
            .setMessage("You really want to change this text?")
            .setCancelable(true)
            .setPositiveButton("Yes") { _, _ ->
                findNavController().navigate(R.id.taskFragment, bundleOf(TASK_KEY to task))
                App.db.taskDao().delete(task)
                val data = App.db.taskDao().getAll()
                adapter.addTask(data)
            }
            .setNegativeButton("No") { _, _ -> }
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}