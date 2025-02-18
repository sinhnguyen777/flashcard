package com.example.flashcard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DashboardAdapter(private val items: List<DashboardItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_STAT = 0
        private const val TYPE_ACTION = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_STAT -> StatViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_stat_card, parent, false)
            )
            else -> ActionViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_action_card, parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = items[position]) {
            is DashboardItem.StatItem -> (holder as StatViewHolder).bind(item)
            is DashboardItem.ActionItem -> (holder as ActionViewHolder).bind(item)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is DashboardItem.StatItem -> TYPE_STAT
            is DashboardItem.ActionItem -> TYPE_ACTION
        }
    }

    override fun getItemCount() = items.size

    inner class StatViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvValue: TextView = view.findViewById(R.id.tvValue)
        private val tvLabel: TextView = view.findViewById(R.id.tvLabel)

        fun bind(item: DashboardItem.StatItem) {
            tvValue.text = item.value
            tvLabel.text = item.label
        }
    }

    inner class ActionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvAction: TextView = view.findViewById(R.id.tvAction)

        fun bind(item: DashboardItem.ActionItem) {
            tvAction.text = item.title
        }
    }
}