package com.chichi289.launchmodes

import android.os.Bundle
import android.util.Log
import com.chichi289.launchmodes.databinding.ActivityFourBinding

class ActivityFour : BaseActivity() {

    private lateinit var binding: ActivityFourBinding

    private var currentInstanceValue = 0

    init {
        instanceCounter++
        currentInstanceValue = instanceCounter
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            textViewInstanceValue.append(",Current instance: $currentInstanceValue")

            buttonStartActivityA.setOnClickListener {
                startActivity(this@ActivityFour, ActivityOne::class.java)
            }
            buttonStartActivityB.setOnClickListener {
                startActivity(this@ActivityFour, ActivityTwo::class.java)
            }
            buttonStartActivityC.setOnClickListener {
                startActivity(this@ActivityFour, ActivityThree::class.java)
            }
            buttonStartActivityD.setOnClickListener {
                startActivity(this@ActivityFour, ActivityFour::class.java)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "Instances: $currentInstanceValue")
        binding.textViewTaskInfo.text = getAppTaskState()
    }

    companion object {
        private val TAG = ActivityFour::class.java.simpleName
        private var instanceCounter = 0
    }
}