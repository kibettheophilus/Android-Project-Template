package com.example.data.remote

import com.example.data.remote.models.DummyDataDto
import retrofit2.http.GET

interface ApiService {

    @GET("")
    suspend fun getDummyData(): List<DummyDataDto>
}