package com.tata.tess.berlinclock.repository

import androidx.lifecycle.LiveData
import com.tata.tess.berlinclock.model.BClock

interface BClockRepository {
    fun getBClockModelLiveData(): LiveData<BClock>
}