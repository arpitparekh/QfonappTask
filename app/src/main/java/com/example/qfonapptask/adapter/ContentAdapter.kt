package com.example.qfonapptask.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.qfonapptask.model.Content
import com.example.qfonapptask.databinding.ContentRowItemBinding
import com.example.qfonapptask.listener.OnImageClickListener
import com.example.qfonapptask.model.DataItem

class ContentAdapter(val list : ArrayList<DataItem>,val context: Context,val listener :OnImageClickListener) : RecyclerView.Adapter<ContentAdapter.ContentViewHolder>() {
    class ContentViewHolder(val binding: ContentRowItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        val binding = ContentRowItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ContentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        val item = list[position]
        holder.binding.obj = item

        if(item.posttype==1){
            Glide.with(context).load(item.content).into(holder.binding.imageView11)
        }else{
            Glide.with(context).load(item.thumb).into(holder.binding.imageView11)
        }

        holder.binding.imageView11.setOnClickListener {
            listener.onClick(position)
        }
    }

    override fun getItemCount(): Int = list.size
}