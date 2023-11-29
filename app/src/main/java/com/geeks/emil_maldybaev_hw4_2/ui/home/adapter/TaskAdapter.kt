package com.geeks.emil_maldybaev_hw4_2.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.geeks.emil_maldybaev_hw4_2.databinding.ActivityMainBinding
import com.geeks.emil_maldybaev_hw4_2.databinding.ItemTaskBinding
import com.geeks.emil_maldybaev_hw4_2.model.Task

class TaskAdapter(
    val onLongClickItem: (task: Task) -> Unit,
    val onClickItem: (task: Task) -> Unit
) : Adapter<TaskAdapter.TaskViewHolder>() {

    private val list = arrayListOf<Task>(
    )

    fun addTask(tasks: List<Task>) {
        list.clear()
        list.addAll(tasks)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        return holder.bind(list[position])
    }

    inner class TaskViewHolder(private val binding: ItemTaskBinding) : ViewHolder(binding.root) {

        fun bind(task: Task) {
            binding.tvTitle.text = task.title
            binding.tvDesc.text = task.desc

            itemView.setOnLongClickListener {
                onLongClickItem(task)
                true
            }
            itemView.setOnClickListener {
                onClickItem(task)
            }
        }
    }
}