package dev.kibet.domain.repository

import dev.kibet.domain.models.DummyData
import dev.kibet.domain.utils.Resource

interface MainRepository {
    suspend fun getDummyData(): List<DummyData>
}