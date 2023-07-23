package com.chichi289.launchmodes

import android.os.Bundle
import android.util.Log
import com.chichi289.launchmodes.adapter.TaskAdapter
import com.chichi289.launchmodes.databinding.ActivityOneBinding
import com.chichi289.launchmodes.model.Result

class ActivityA : BaseActivity() {

    private lateinit var binding: ActivityOneBinding

    private var currentInstanceValue = 0

    private var mTaskList = ArrayList<Result>()

    private val mTaskAdapter: TaskAdapter by lazy { TaskAdapter(mTaskList) }

    init {
        instanceCounter++
        currentInstanceValue = instanceCounter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOneBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupTaskAdapter()
        binding.apply {
            textViewInstanceValue.append(",Current instance: $currentInstanceValue")

            buttonStartActivityA.setOnClickListener {
                startActivity(this@ActivityA, ActivityA::class.java)
            }
            buttonStartActivityB.setOnClickListener {
                startActivity(this@ActivityA, ActivityB::class.java)
            }
            buttonStartActivityC.setOnClickListener {
                startActivity(this@ActivityA, ActivityC::class.java)
            }
            buttonStartActivityD.setOnClickListener {
                startActivity(this@ActivityA, ActivityD::class.java)
            }
        }

    }

    private fun setupTaskAdapter() {
        binding.rvTask.adapter = mTaskAdapter
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "Instances: $currentInstanceValue")
        val pair = getAppTaskState()
        binding.textViewTaskInfo.text = pair.first

        mTaskAdapter.update(pair.second)
    }

    companion object {
        private val TAG = ActivityA::class.java.simpleName
        private var instanceCounter = 0
    }
}