package com.example.domain.repository

import com.example.domain.models.DummyData

interface MainRepository {
    suspend fun getDummyData(): List<DummyData>
}