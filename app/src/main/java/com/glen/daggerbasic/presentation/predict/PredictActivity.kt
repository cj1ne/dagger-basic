package com.glen.daggerbasic.presentation.predict

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import com.glen.daggerbasic.R
import com.glen.daggerbasic.databinding.ActivityPredictBinding
import com.glen.daggerbasic.presentation.MyApplication
import javax.inject.Inject

class PredictActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var binding: ActivityPredictBinding
    private val viewModel: PredictViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).appComponent.inject(this)
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
}