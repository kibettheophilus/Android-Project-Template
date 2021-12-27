package dev.kibet.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.kibet.data.local.entities.DummyDataEntity

@Dao
interface DummyDataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveData(dummyData: List<DummyDataEntity>)

    @Query("SELECT * FROM dummytable")
    suspend fun getAllDummy(): List<DummyDataEntity>
}