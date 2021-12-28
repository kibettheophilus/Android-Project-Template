package com.example.data.repository

import com.example.data.local.dao.DummyDataDao
import com.example.data.mappers.toDomain
import com.example.data.mappers.toEntity
import com.example.data.remote.ApiService
import com.example.domain.models.DummyData
import com.example.domain.repository.MainRepository

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