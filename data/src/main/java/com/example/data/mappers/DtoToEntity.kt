package com.example.data.mappers

import com.example.data.local.entities.DummyDataEntity
import com.example.data.remote.models.DummyDataDto

fun DummyDataDto.toEntity(): DummyDataEntity {
    return DummyDataEntity(
        id, name, image
    )
}