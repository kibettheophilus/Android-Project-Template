package dev.kibet.data.repository

import dev.kibet.data.local.dao.DummyDataDao
import dev.kibet.data.mappers.toDomain
import dev.kibet.data.mappers.toEntity
import dev.kibet.data.remote.ApiService
import dev.kibet.domain.models.DummyData
import dev.kibet.domain.repository.MainRepository

class MainRepositoryImpl(private val api: ApiService, private val dao: DummyDataDao) :
    MainRepository {
    override suspend fun getDummyData(): List<DummyData> {
        val localData = dao.getAllDummy()
        return if (localData.isNotEmpty()) {
            localData.map { it.toDomain() }
        } else {
            val data = api.getDummyData()
            dao.saveData(data.map { it.toEntity() })
            data.map { it.toDomain() }
        }
    }
}