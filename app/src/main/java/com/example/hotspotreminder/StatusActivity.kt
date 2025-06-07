
package com.example.hotspotreminder

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class StatusActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_status)

        val statusText = findViewById<TextView>(R.id.statusText)
        val rootText = findViewById<TextView>(R.id.rootStatus)

        val prefs = getSharedPreferences("hotspot_prefs", MODE_PRIVATE)
        val timeMillis = prefs.getLong("alarm_time", 0L)

        if (timeMillis > 0L) {
            val date = Date(timeMillis)
            val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
            statusText.text = getString(R.string.alarm_saved) + ": ${sdf.format(date)}"
        } else {
            statusText.text = getString(R.string.no_time_set)
        }

        rootText.text = if (RootUtils.isDeviceRooted()) {
            getString(R.string.root_status_yes)
        } else {
            getString(R.string.root_status_no)
        }
    }
}
