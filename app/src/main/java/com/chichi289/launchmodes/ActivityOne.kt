package com.chichi289.launchmodes

import android.os.Bundle
import android.util.Log
import com.chichi289.launchmodes.databinding.ActivityOneBinding


class ActivityOne : BaseActivity() {

    private lateinit var binding: ActivityOneBinding

    private var currentInstanceValue = 0

    init {
        instanceCounter++
        currentInstanceValue = instanceCounter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            textViewInstanceValue.append(",Current instance: $currentInstanceValue")

            buttonStartActivityA.setOnClickListener {
                startActivity(this@ActivityOne, ActivityOne::class.java)
            }
            buttonStartActivityB.setOnClickListener {
                startActivity(this@ActivityOne, ActivityTwo::class.java)
            }
            buttonStartActivityC.setOnClickListener {
                startActivity(this@ActivityOne, ActivityThree::class.java)
            }
            buttonStartActivityD.setOnClickListener {
                startActivity(this@ActivityOne, ActivityFour::class.java)
            }
        }

    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "Instances: $currentInstanceValue")
        binding.textViewTaskInfo.text = getAppTaskState()
    }

    companion object {
        private val TAG = ActivityOne::class.java.simpleName
        private var instanceCounter = 0
    }
}