package com.chichi289.launchmodes.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chichi289.launchmodes.databinding.ItemTaskBinding
import com.chichi289.launchmodes.model.Result

class TaskAdapter(
    private val mList: ArrayList<Result>
) : RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun update(taskList:ArrayList<Result>){
        mList.clear()
        mList.addAll(taskList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun getItemCount(): Int = mList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    inner class ViewHolder(
        private val binding: ItemTaskBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(dataBean: Result) {
            binding.tvTaskNo.text = "Task Id ${dataBean.id}"
            binding.rvActivity.adapter = ActivityAdapter(dataBean.activities)
        }
    }

}