package com.meta.capstoneproject.littlelemonapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase
import java.io.Serializable

@Entity
data class MenuItemRoom(
    @PrimaryKey
    var id: Int = 0,
    var title: String = "",
    var description: String = "",
    var price: Double = 0.0,
    var category: String = "",
    var image: String = ""
) : Serializable

@Dao
interface MenuItemDao {
    @Query("SELECT * FROM MenuItemRoom")
    fun getAll(): LiveData<List<MenuItemRoom>>

    @Insert
    fun insertAll(vararg menuItems: MenuItemRoom)

    @Query("SELECT (SELECT COUNT(*) FROM MenuItemRoom) == 0")
    fun isEmpty(): Boolean
}

@Database(entities = [MenuItemRoom::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun menuItemDao(): MenuItemDao
}
