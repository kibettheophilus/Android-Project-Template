package com.example.data.mappers

import com.example.data.local.entities.DummyDataEntity
import com.example.domain.models.DummyData

fun DummyDataEntity.toDomain(): DummyData {
    return DummyData(
        id, name, image
    )
}