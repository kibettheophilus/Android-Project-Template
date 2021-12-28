package dev.kibet.data.remote

import dev.kibet.data.remote.models.DummyDataDto
import retrofit2.http.GET

interface ApiService {

    @GET("")
    suspend fun getDummyData(): List<DummyDataDto>
}