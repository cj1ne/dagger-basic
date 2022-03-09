package com.glen.daggerbasic.presentation.predict

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.glen.daggerbasic.data.datasource.remote.PredictAgeRemoteSourceImpl
import com.glen.daggerbasic.data.datasource.remote.providePredictAgeService
import com.glen.daggerbasic.data.repository.PredictAgeRepositoryImpl
import com.glen.daggerbasic.databinding.FragmentPredictAgeBinding
import com.glen.daggerbasic.domain.usecase.GetPredictAgeUseCase
import kotlinx.coroutines.flow.collect

class PredictAgeFragment : Fragment() {

    private lateinit var binding: FragmentPredictAgeBinding
    private val viewModel: PredictAgeViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                val service = providePredictAgeService()
                val remoteSource = PredictAgeRemoteSourceImpl(service)
                val repository = PredictAgeRepositoryImpl(remoteSource)
                val getPredictAgeUseCase = GetPredictAgeUseCase(repository)
                val logger = (activity as PredictActivity).getLogger()
                // DO NOT USE LIKE THIS : This is just for understanding dagger scope
                return PredictAgeViewModel(getPredictAgeUseCase, logger) as T
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPredictAgeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        observeViewModel(viewModel)
    }

    private fun observeViewModel(viewModel: PredictAgeViewModel) {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.event.collect { event ->
                when (event) {
                    is PredictAgeViewModel.Event.ShowToast -> {
                        Toast.makeText(requireContext(), event.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}