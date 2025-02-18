package com.example.flashcard

sealed class DashboardItem {
    data class StatItem(val value: String, val label: String) : DashboardItem()
    data class ActionItem(val title: String) : DashboardItem()
}