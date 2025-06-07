
package com.example.hotspotreminder

import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val timeButton = findViewById<Button>(R.id.timeButton)
        val statusButton = findViewById<Button>(R.id.statusButton)
        val aboutButton = findViewById<Button>(R.id.aboutButton)

        timeButton.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)
            val dialog = TimePickerDialog(this, { _: TimePicker, h: Int, m: Int ->
                AlarmHelper.setAlarm(this, h, m)
            }, hour, minute, true)
            dialog.show()
        }

        statusButton.setOnClickListener {
            startActivity(Intent(this, StatusActivity::class.java))
        }

        aboutButton.setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }
    }
}
