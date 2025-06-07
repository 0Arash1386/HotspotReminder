
package com.example.hotspotreminder

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (RootUtils.isDeviceRooted()) {
            RootUtils.enableHotspot()
        } else {
            Toast.makeText(context, context.getString(R.string.alarm_saved), Toast.LENGTH_LONG).show()
        }
    }
}
