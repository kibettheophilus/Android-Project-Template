package dev.kibet.data.mappers

import dev.kibet.data.remote.models.DummyDataDto
import dev.kibet.domain.models.DummyData

fun DummyDataDto.toDomain(): DummyData {
    return DummyData(
        id, name, image
    )
}