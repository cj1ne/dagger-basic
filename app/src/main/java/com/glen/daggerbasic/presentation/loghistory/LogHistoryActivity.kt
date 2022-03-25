package com.glen.daggerbasic.presentation.loghistory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.glen.daggerbasic.R
import com.glen.daggerbasic.databinding.ActivityLogHistoryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LogHistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLogHistoryBinding
    private val viewModel: LogHistoryViewModel by viewModels()

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