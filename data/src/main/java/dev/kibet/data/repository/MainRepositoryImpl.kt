package dev.kibet.data.repository

import dev.kibet.data.local.dao.DummyDataDao
import dev.kibet.data.remote.ApiService
import dev.kibet.domain.models.DummyData
import dev.kibet.domain.repository.MainRepository
import dev.kibet.domain.utils.Resource
import retrofit2.HttpException

class MainRepositoryImpl(private val api: ApiService, private val dao: DummyDataDao): MainRepository {
    override suspend fun getDummyData(): Resource<List<DummyData>> {
        return try {
            val data = api.getDummyData()
            Resource.success(data)
        }catch (e: Exception){
            return if (e is HttpException){
                Resource.error("$e",null)
            }else {
                Resource.error("Couldn't connect to server, $e",null)
            }
        }
    }
}