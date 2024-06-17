package com.tata.tess.berlinclock.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.tata.tess.berlinclock.model.BClock
import com.tata.tess.berlinclock.model.LightColor
import com.tata.tess.berlinclock.repository.BClockRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.kotlin.mock

@ExperimentalCoroutinesApi
class BClockViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: BClockViewModel
    private val repository: BClockRepository = mock()
    @Mock
    private val bClockLiveData = MutableLiveData<BClock>()

    @Before
    fun setUp() {
        Mockito.`when`(repository.getBClockModelLiveData()).thenReturn(mock())
        viewModel = BClockViewModel(repository)
    }

    @Test
    fun testClockModelLiveDataFromRepository() {
        val observer = mock<Observer<BClock>>()
        viewModel.bClockModel.observeForever(observer)

        verify(repository).getBClockModelLiveData()
        verify(viewModel.bClockModel).observeForever(observer)

        // Simulate ViewModel init
        val mockClockModel = BClock(
            secondsLight = true,
            fiveHoursLights = listOf(true, true, false, false),
            singleHoursLights = listOf(true, true, false, false),
            fiveMinutesLights = listOf(LightColor.YELLOW, LightColor.YELLOW, LightColor.RED, LightColor.YELLOW, LightColor.YELLOW, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF),
            singleMinutesLights = listOf(true, false, false, false),
            currentTimeString = "12:26:56"
        )
        bClockLiveData.postValue(mockClockModel)
        bClockLiveData.observeForever(observer)

        verify(observer).onChanged(mockClockModel)
    }
}