package dev.kibet.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dummytable")
data class DummyDataEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String
)
