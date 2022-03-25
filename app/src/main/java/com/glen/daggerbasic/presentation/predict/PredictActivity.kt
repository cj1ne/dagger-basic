package com.glen.daggerbasic.presentation.predict

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.commit
import com.glen.daggerbasic.R
import com.glen.daggerbasic.databinding.ActivityPredictBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PredictActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPredictBinding
    private val viewModel: PredictViewModel by viewModels()

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
}