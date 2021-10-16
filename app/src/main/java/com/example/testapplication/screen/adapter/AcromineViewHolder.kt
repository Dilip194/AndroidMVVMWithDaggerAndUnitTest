package com.example.testapplication.screen.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.testapplication.databinding.ContentItemBinding
import com.example.testapplication.network.model.Acromine
import com.example.testapplication.network.model.AcromineData
import com.example.testapplication.network.model.AcromineViewModel

/**
 * @Author: Dilip
 * @Date: 16/10/21
 */
class AcromineViewHolder(private var binder : ContentItemBinding) : RecyclerView.ViewHolder(binder.root){

    private val viewModel = AcromineViewModel()

    fun bind(acromine: Acromine?){
        viewModel.bind(acromine)
        binder.viewModel = viewModel
    }

}