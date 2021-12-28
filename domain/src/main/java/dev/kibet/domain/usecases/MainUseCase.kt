package dev.kibet.domain.usecases

import dev.kibet.domain.models.DummyData
import dev.kibet.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class MainUseCase(private val repository: MainRepository) {
    suspend operator fun invoke(): Flow<List<DummyData>> {
        return flowOf(repository.getDummyData())
    }
}