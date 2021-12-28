package dev.kibet.data.mappers

import dev.kibet.data.local.entities.DummyDataEntity
import dev.kibet.domain.models.DummyData

fun DummyDataEntity.toDomain(): DummyData {
    return DummyData(
        id, name, image
    )
}