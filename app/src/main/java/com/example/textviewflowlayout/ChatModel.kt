package com.example.textviewflowlayout

import androidx.recyclerview.widget.DiffUtil

data class ChatModel(var id: Int, var name: String, var message: String)

class ChatDiffUtil : DiffUtil.ItemCallback<ChatModel>() {
    override fun areItemsTheSame(oldItem: ChatModel, newItem: ChatModel) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: ChatModel, newItem: ChatModel) = oldItem == newItem
}
