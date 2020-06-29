package com.example.textviewflowlayout

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.textviewflowlayout.databinding.ItemChatTextReceivedBinding

class MessageAdapter : ListAdapter<ChatModel, MessageViewHolder>(ChatDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MessageViewHolder(
            DataBindingUtil.inflate(
                inflater,
                R.layout.item_chat_text_received,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class MessageViewHolder(var binding: ItemChatTextReceivedBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(chatModel: ChatModel) = with(binding) {
        item = chatModel
        executePendingBindings()
    }
}