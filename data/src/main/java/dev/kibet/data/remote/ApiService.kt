package dev.kibet.data.remote

import dev.kibet.domain.models.DummyData
import retrofit2.http.GET

interface ApiService {

    @GET("")
    suspend fun getDummyData(): List<DummyData>
}