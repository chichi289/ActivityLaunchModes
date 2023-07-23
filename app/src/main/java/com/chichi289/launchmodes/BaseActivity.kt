package com.chichi289.launchmodes

import android.app.Activity
import android.app.ActivityManager
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chichi289.launchmodes.model.Result

abstract class BaseActivity : AppCompatActivity() {

    private lateinit var activityManager: ActivityManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityManager = getSystemService(ACTIVITY_SERVICE) as ActivityManager
    }

    protected fun startActivity(activity: Activity, targetActivityClass: Class<*>) {
        val intent = Intent(activity, targetActivityClass)
        /*if(targetActivityClass == ActivityB::class.java){
            intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        }*/
        startActivity(intent)
    }

    @Suppress("DEPRECATION")
    protected open fun getAppTaskState(): Pair<String,ArrayList<Result>> {
        val stringBuilder = StringBuilder()

        val mList = ArrayList<Result>()

        val totalNumberOfTasks = activityManager.getRunningTasks(10).size
        stringBuilder.append("\nTotal Number of Tasks: $totalNumberOfTasks\n\n")
        val taskInfo = activityManager.getRunningTasks(10)
        for (info in taskInfo) {
            val activityList = ArrayList<String>()
            stringBuilder.append(
                """
                Task Id: ${info.id}, Number of Activities : ${info.numActivities}
                
                """.trimIndent()
            )
            // TOP
            val topActivityName = info.topActivity!!.className.replace(
                "com.chichi289.launchmodes.", ""
            )
            stringBuilder.append(
                """
                TopActivity: $topActivityName
                
                """.trimIndent()
            )
            activityList.add(
                "TOP:$topActivityName"
            )

            // BASE
            val baseActivityName = info.baseActivity!!.className.replace(
                "com.chichi289.launchmodes.", ""
            )
            stringBuilder.append(
                """
                BaseActivity: $baseActivityName
                
                """.trimIndent()
            )
            stringBuilder.append("\n\n")

            activityList.add(
                "BASE:$baseActivityName"
            )
            val result = Result(id = info.id, activities = activityList)
            mList.add(result)

        }
        return Pair(stringBuilder.toString(),mList)
    }
}