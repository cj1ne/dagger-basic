package com.glen.daggerbasic.presentation.loghistory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.glen.daggerbasic.R
import com.glen.daggerbasic.databinding.ActivityLogHistoryBinding
import com.glen.daggerbasic.presentation.MyApplication
import javax.inject.Inject

class LogHistoryActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var binding: ActivityLogHistoryBinding
    private val viewModel: LogHistoryViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).appComponent.logHistoryComponent().create().inject(this)
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