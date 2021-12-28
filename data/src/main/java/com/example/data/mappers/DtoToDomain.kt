package com.example.data.mappers

import com.example.data.remote.models.DummyDataDto
import com.example.domain.models.DummyData

fun DummyDataDto.toDomain(): DummyData {
    return DummyData(
        id, name, image
    )
}