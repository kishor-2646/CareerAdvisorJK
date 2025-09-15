package com.example.careeradvisorjk.ui.main.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.careeradvisorjk.entities.College
import com.example.careeradvisorjk.databinding.ItemCollegeBinding

class CollegeAdapter : ListAdapter<College, CollegeAdapter.CollegeVH>(DIFF) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollegeVH {
        val binding = ItemCollegeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CollegeVH(binding)
    }

    override fun onBindViewHolder(holder: CollegeVH, position: Int) {
        holder.bind(getItem(position))
    }

    class CollegeVH(private val b: ItemCollegeBinding) : RecyclerView.ViewHolder(b.root) {
        fun bind(item: College) {
            b.name.text = item.name
            b.district.text = item.district
            b.courses.text = item.courses
            b.facilities.text = item.facilities
        }
    }

    companion object {
        val DIFF = object : DiffUtil.ItemCallback<College>() {
            override fun areItemsTheSame(old: College, new: College) = old.id == new.id
            override fun areContentsTheSame(old: College, new: College) = old == new
        }
    }
}