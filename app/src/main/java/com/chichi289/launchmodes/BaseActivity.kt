package com.chichi289.launchmodes

import android.app.Activity
import android.app.ActivityManager
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    private lateinit var activityManager: ActivityManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityManager = getSystemService(ACTIVITY_SERVICE) as ActivityManager
    }

    protected fun startActivity(activity: Activity, targetActivityClass: Class<*>) {
        val intent = Intent(activity, targetActivityClass)
        startActivity(intent)
    }

    protected fun getNumberOfTasks(): Int = activityManager.appTasks.size

    @Suppress("DEPRECATION")
    protected open fun getAppTaskState(): String {
        val stringBuilder = StringBuilder()
        val totalNumberOfTasks = activityManager.getRunningTasks(10).size
        stringBuilder.append("\nTotal Number of Tasks: $totalNumberOfTasks\n\n")
        val taskInfo = activityManager.getRunningTasks(10)
        for (info in taskInfo) {
            stringBuilder.append(
                """
                Task Id: ${info.id}, Number of Activities : ${info.numActivities}
                
                """.trimIndent()
            )
            stringBuilder.append(
                """
                TopActivity: ${
                    info.topActivity!!.className.replace(
                        "com.chichi289.launchmodes.", ""
                    )
                }
                
                """.trimIndent()
            )
            stringBuilder.append(
                """
                BaseActivity: ${
                    info.baseActivity!!.className.replace(
                        "com.chichi289.launchmodes.", ""
                    )
                }
                
                """.trimIndent()
            )
            stringBuilder.append("\n\n")
        }
        return stringBuilder.toString()
    }

}