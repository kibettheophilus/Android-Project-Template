package com.example.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.local.dao.DummyDataDao
import com.example.data.local.entities.DummyDataEntity

@Database(entities = [DummyDataEntity::class], version = 1, exportSchema = false)
abstract class MainDatabase : RoomDatabase() {
    abstract fun dummyDataDao(): DummyDataDao
}