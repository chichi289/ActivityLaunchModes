package com.chichi289.launchmodes

import android.os.Bundle
import android.util.Log
import com.chichi289.launchmodes.adapter.TaskAdapter
import com.chichi289.launchmodes.databinding.ActivityFourBinding

class ActivityD : BaseActivity() {

    private lateinit var binding: ActivityFourBinding

    private var currentInstanceValue = 0

    private var mTaskList = ArrayList<Result>()

    private val mTaskAdapter: TaskAdapter by lazy { TaskAdapter(mTaskList) }

    init {
        instanceCounter++
        currentInstanceValue = instanceCounter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupTaskAdapter()
        binding.apply {
            textViewInstanceValue.append(",Current instance: $currentInstanceValue")

            buttonStartActivityA.setOnClickListener {
                startActivity(this@ActivityD, ActivityA::class.java)
            }
            buttonStartActivityB.setOnClickListener {
                startActivity(this@ActivityD, ActivityB::class.java)
            }
            buttonStartActivityC.setOnClickListener {
                startActivity(this@ActivityD, ActivityC::class.java)
            }
            buttonStartActivityD.setOnClickListener {
                startActivity(this@ActivityD, ActivityD::class.java)
            }
        }
    }

    private fun setupTaskAdapter() {
        binding.rvTask.adapter = mTaskAdapter
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "Instances: $currentInstanceValue")
        binding.textViewTaskInfo.text = getAppTaskState()

        mTaskList.clear()
        mTaskList.addAll(getAppTasks())
    }

    companion object {
        private val TAG = ActivityD::class.java.simpleName
        private var instanceCounter = 0
    }
}