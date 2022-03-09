package com.glen.daggerbasic.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.glen.daggerbasic.R
import com.glen.daggerbasic.databinding.ActivityMainBinding
import com.glen.daggerbasic.presentation.loghistory.LogHistoryActivity
import kotlinx.coroutines.flow.collect

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        observeViewModel(viewModel)
    }

    private fun observeViewModel(viewModel: MainViewModel) {
        lifecycleScope.launchWhenStarted {
            viewModel.event.collect { event ->
                when (event) {
                    MainViewModel.Event.OpenPredictAge -> {

                    }
                    MainViewModel.Event.OpenLogHistory -> {
                        val intent = Intent(this@MainActivity, LogHistoryActivity::class.java)
                        startActivity(intent)
                    }
                }
            }
        }
    }
}