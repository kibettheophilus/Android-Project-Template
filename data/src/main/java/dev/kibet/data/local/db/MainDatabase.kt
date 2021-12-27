package dev.kibet.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.kibet.data.local.dao.DummyDataDao
import dev.kibet.data.local.entities.DummyDataEntity

@Database(entities = [DummyDataEntity::class], version = 1, exportSchema = false)
abstract class MainDatabase : RoomDatabase() {
    abstract fun dummyDataDao(): DummyDataDao
}