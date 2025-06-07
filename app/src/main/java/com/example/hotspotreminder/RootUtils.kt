
package com.example.hotspotreminder

import java.io.BufferedReader
import java.io.InputStreamReader

object RootUtils {
    fun isDeviceRooted(): Boolean {
        val paths = arrayOf("/system/bin/su", "/system/xbin/su")
        return paths.any { path ->
            try {
                val process = Runtime.getRuntime().exec(arrayOf("sh", "-c", "ls $path"))
                val reader = BufferedReader(InputStreamReader(process.inputStream))
                val output = reader.readLine()
                output != null
            } catch (e: Exception) {
                false
            }
        }
    }

    fun enableHotspot() {
        try {
            Runtime.getRuntime().exec("su -c svc wifi disable && su -c svc wifi enable && su -c svc tether start")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
