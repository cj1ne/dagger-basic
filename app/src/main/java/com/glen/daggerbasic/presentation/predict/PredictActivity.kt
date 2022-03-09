package com.glen.daggerbasic.presentation.predict

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.glen.daggerbasic.R
import com.glen.daggerbasic.data.datasource.local.AppDatabase
import com.glen.daggerbasic.data.datasource.local.LogLocalDataSourceImpl
import com.glen.daggerbasic.data.repository.LogRepositoryImpl
import com.glen.daggerbasic.databinding.ActivityPredictBinding
import com.glen.daggerbasic.domain.usecase.AddLogUseCase
import com.glen.daggerbasic.presentation.Logger

class PredictActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPredictBinding
    private val viewModel: PredictViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val database = AppDatabase.getInstance(this@PredictActivity)
                val dataSource = LogLocalDataSourceImpl(database.logDao())
                val repository = LogRepositoryImpl(dataSource)
                val addLogUseCase = AddLogUseCase(repository)
                val logger = Logger(addLogUseCase)
                return PredictViewModel(logger) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_predict)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace(R.id.fragment_container, PredictAgeFragment())
            }
        }
    }

    fun getLogger(): Logger {
        return viewModel.logger
    }
}