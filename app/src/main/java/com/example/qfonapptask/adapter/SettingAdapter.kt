package com.example.qfonapptask.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.qfonapptask.model.Setting
import com.example.qfonapptask.databinding.SettingRowItemBinding

class SettingAdapter(val list : ArrayList<Setting>) : RecyclerView.Adapter<SettingAdapter.SettingViewHolder>() {

    class SettingViewHolder(val binding: SettingRowItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingViewHolder {
        val binding = SettingRowItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SettingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SettingViewHolder, position: Int) {
        val setting = list[position]
        holder.binding.imageView.setImageResource(setting.icon)
        holder.binding.text.text = setting.name
    }

    override fun getItemCount() = list.size
}