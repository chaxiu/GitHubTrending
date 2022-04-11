package com.boycoder.githubtrending.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.boycoder.githubtrending.R
import com.boycoder.githubtrending.data.RepoList

/**
 * @Author: zhutao
 * @desc:
 */
class RepoAdapter(private val repoList: RepoList): RecyclerView.Adapter<RepoHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoHolder {
        return RepoHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_repo, parent, false))
    }

    override fun onBindViewHolder(holder: RepoHolder, position: Int) {
        holder.text.text = repoList.items.getOrNull(position)?.repo
    }

    override fun getItemCount(): Int = repoList.count
}

class RepoHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val text : TextView = itemView.findViewById(R.id.text)
}