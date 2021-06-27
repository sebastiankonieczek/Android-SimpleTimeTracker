package com.example.util.simpletimetracker.core.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

interface RecyclerAdapterDelegate {
    fun isForValidType(check: ViewHolderType): Boolean

    fun onCreateViewHolder(parent: ViewGroup): BaseRecyclerViewHolder

    fun getViewHolderTypeName(): String
}

abstract class BaseRecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun bind(item: ViewHolderType, payloads: List<Any>)
}

inline fun <reified T : ViewHolderType> createRecyclerAdapterDelegate(
    layoutId: Int,
    noinline onBind: (View, ViewHolderType, List<Any>) -> Unit
) = object : RecyclerAdapterDelegate {

    override fun isForValidType(check: ViewHolderType): Boolean {
        return check is T
    }

    override fun onCreateViewHolder(parent: ViewGroup): BaseRecyclerViewHolder =
        BaseRecyclerViewHolderImpl(parent, layoutId, onBind)

    override fun getViewHolderTypeName(): String = T::class.java.simpleName
}

class BaseRecyclerViewHolderImpl(
    parent: ViewGroup,
    @LayoutRes layoutId: Int,
    private val onBind: (View, ViewHolderType, List<Any>) -> Unit
) : BaseRecyclerViewHolder(
    LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
) {

    override fun bind(item: ViewHolderType, payloads: List<Any>) =
        onBind(itemView, item, payloads)
}