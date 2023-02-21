package com.chichi289.launchmodes

import android.os.Bundle
import android.util.Log
import com.chichi289.launchmodes.databinding.ActivityThreeBinding

class ActivityThree : BaseActivity() {

    private lateinit var binding: ActivityThreeBinding

    private var currentInstanceValue = 0

    init {
        instanceCounter++
        currentInstanceValue = instanceCounter
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThreeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            textViewInstanceValue.append(",Current instance: $currentInstanceValue")

            buttonStartActivityA.setOnClickListener {
                startActivity(this@ActivityThree, ActivityOne::class.java)
            }
            buttonStartActivityB.setOnClickListener {
                startActivity(this@ActivityThree, ActivityTwo::class.java)
            }
            buttonStartActivityC.setOnClickListener {
                startActivity(this@ActivityThree, ActivityThree::class.java)
            }
            buttonStartActivityD.setOnClickListener {
                startActivity(this@ActivityThree, ActivityFour::class.java)
            }
        }

    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "Instances: $currentInstanceValue")
        binding.textViewTaskInfo.text = getAppTaskState()
    }

    companion object {
        private val TAG = ActivityThree::class.java.simpleName
        private var instanceCounter = 0
    }
}