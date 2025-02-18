package com.example.flashcard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val dashboardItems = listOf(
            DashboardItem.StatItem("80.39%", "Attendance"),
            DashboardItem.StatItem("₹6400", "Fees Due"),
            DashboardItem.ActionItem("Play Quiz"),
            DashboardItem.ActionItem("Assignment"),
            DashboardItem.ActionItem("School Holiday"),
            DashboardItem.ActionItem("Time Table"),
            DashboardItem.ActionItem("Result"),
            DashboardItem.ActionItem("Date Sheet"),
            DashboardItem.ActionItem("Ask Doubts"),
            DashboardItem.ActionItem("School Gallery"),
            DashboardItem.ActionItem("Leave Application"),
            DashboardItem.ActionItem("Change Password"),
            DashboardItem.ActionItem("Events"),
            DashboardItem.ActionItem("Logout")
        )

        val adapter = DashboardAdapter(dashboardItems)
        findViewById<RecyclerView>(R.id.rvDashboard).adapter = adapter
    }
}
