package com.chichi289.launchmodes

import android.os.Bundle
import android.util.Log
import com.chichi289.launchmodes.databinding.ActivityTwoBinding

class ActivityTwo : BaseActivity() {

    private lateinit var binding: ActivityTwoBinding

    private var currentInstanceValue = 0

    init {
        instanceCounter++
        currentInstanceValue = instanceCounter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            textViewInstanceValue.append(",Current instance: $currentInstanceValue")

            buttonStartActivityA.setOnClickListener {
                startActivity(this@ActivityTwo, ActivityOne::class.java)
            }
            buttonStartActivityB.setOnClickListener {
                startActivity(this@ActivityTwo, ActivityTwo::class.java)
            }
            buttonStartActivityC.setOnClickListener {
                startActivity(this@ActivityTwo, ActivityThree::class.java)
            }
            buttonStartActivityD.setOnClickListener {
                startActivity(this@ActivityTwo, ActivityFour::class.java)
            }
        }

    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "Instances: $currentInstanceValue")
        binding.textViewTaskInfo.text = getAppTaskState()
    }

    companion object {
        private val TAG = ActivityTwo::class.java.simpleName
        private var instanceCounter = 0
    }
}