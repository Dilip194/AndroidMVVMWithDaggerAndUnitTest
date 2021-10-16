package com.example.testapplication.screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.testapplication.R
import com.example.testapplication.databinding.ContentItemBinding
import com.example.testapplication.network.ResponseModel

/**
 * @Author: Dilip
 * @Date: 16/10/21
 */
class AcromineAdapter : RecyclerView.Adapter<AcromineViewHolder>() {

    lateinit var listItem : List<ResponseModel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AcromineViewHolder {
        val binding: ContentItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.content_item, parent, false)
        return AcromineViewHolder(binding)    }

    override fun onBindViewHolder(holder: AcromineViewHolder, position: Int) {
        holder.bind(listItem.get(0).lfs?.let { listItem.get(0).lfs?.get(position)})
    }

    override fun getItemCount(): Int {
        if (::listItem.isInitialized) {
            return if (!listItem.isNullOrEmpty() && !listItem[0].lfs.isNullOrEmpty()) listItem.get(0).lfs!!.size else 0
        }
        return 0
    }

    fun updatePostList(listItem:List<ResponseModel>){
        this.listItem = listItem
        notifyDataSetChanged()
    }
}