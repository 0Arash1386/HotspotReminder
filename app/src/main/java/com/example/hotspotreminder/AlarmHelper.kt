
package com.example.hotspotreminder

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.widget.Toast
import java.util.*

object AlarmHelper {
    fun setAlarm(context: Context, hour: Int, minute: Int) {
        val calendar = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, hour)
            set(Calendar.MINUTE, minute)
            set(Calendar.SECOND, 0)
        }

        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, AlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pendingIntent)

        context.getSharedPreferences("hotspot_prefs", Context.MODE_PRIVATE)
            .edit().putLong("alarm_time", calendar.timeInMillis).apply()

        Toast.makeText(context, context.getString(R.string.alarm_saved), Toast.LENGTH_SHORT).show()
    }
}
