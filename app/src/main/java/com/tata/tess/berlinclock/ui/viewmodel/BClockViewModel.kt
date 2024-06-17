package com.tata.tess.berlinclock.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.tata.tess.berlinclock.model.BClock
import com.tata.tess.berlinclock.repository.BClockRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BClockViewModel @Inject constructor(
    private val bClockRepository: BClockRepository
) : ViewModel() {

    val bClockModel: LiveData<BClock> = bClockRepository.getBClockModelLiveData()
}