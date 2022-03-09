package com.glen.daggerbasic.presentation.loghistory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.glen.daggerbasic.R
import com.glen.daggerbasic.data.datasource.local.AppDatabase
import com.glen.daggerbasic.data.datasource.local.LogLocalDataSourceImpl
import com.glen.daggerbasic.data.repository.LogRepositoryImpl
import com.glen.daggerbasic.databinding.ActivityLogHistoryBinding
import com.glen.daggerbasic.domain.usecase.ClearLogUseCase
import com.glen.daggerbasic.domain.usecase.GetLogFlowUseCase

class LogHistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLogHistoryBinding
    private val viewModel: LogHistoryViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                val database = AppDatabase.getInstance(this@LogHistoryActivity)
                val dataSource = LogLocalDataSourceImpl(database.logDao())
                val repository = LogRepositoryImpl(dataSource)
                val getLogFlowUseCase = GetLogFlowUseCase(repository)
                val clearLogUseCase = ClearLogUseCase(repository)
                return LogHistoryViewModel(getLogFlowUseCase, clearLogUseCase) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_log_history)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        initView()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menu.add(Menu.NONE, Menu.FIRST, 1, R.string.delete).setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_ALWAYS)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == Menu.FIRST) {
            viewModel.onClearLogClicked()
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }

    private fun initView() {
        with(binding.logList) {
            layoutManager = LinearLayoutManager(this@LogHistoryActivity)
            addItemDecoration(DividerItemDecoration(this@LogHistoryActivity, DividerItemDecoration.VERTICAL))
            adapter = LogAdapter()
        }
    }
}