package com.example.androidprojecttemplate.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.DummyData
import com.example.domain.usecases.MainUseCase
import com.example.domain.utils.Resource
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.io.IOException

class MainViewModel(private val mainUseCase: MainUseCase) : ViewModel() {

    private val _getDummyDataStatus = MutableLiveData<Resource<List<DummyData>>>()
    val getDummyDataStatus: LiveData<Resource<List<DummyData>>> = _getDummyDataStatus

    init {
        getDummyData()
    }

    private fun getDummyData() {
        viewModelScope.launch {
            try {
                mainUseCase().collect {
                    _getDummyDataStatus.value = Resource.success(it)
                }
            } catch (e: Exception) {
                _getDummyDataStatus.value = Resource.error(e.localizedMessage, null)
            } catch (e: IOException) {
                _getDummyDataStatus.value = Resource.error(e.localizedMessage, null)
            }
        }
    }
}