package dev.kibet.data.mappers

import dev.kibet.data.local.entities.DummyDataEntity
import dev.kibet.data.remote.models.DummyDataDto

fun DummyDataDto.toEntity(): DummyDataEntity {
    return DummyDataEntity(
        id, name, image
    )
}