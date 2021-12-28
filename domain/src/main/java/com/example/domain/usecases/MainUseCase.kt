package com.example.domain.usecases

import com.example.domain.models.DummyData
import com.example.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class MainUseCase(private val repository: MainRepository) {
    suspend operator fun invoke(): Flow<List<DummyData>> {
        return flowOf(repository.getDummyData())
    }
}