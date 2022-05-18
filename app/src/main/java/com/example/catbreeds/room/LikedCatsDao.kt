package com.example.catbreeds.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.catbreeds.model.Breed
import com.example.catbreeds.model.Likes
import com.example.catbreeds.model.TypeConverter

@Dao
@TypeConverters(TypeConverter::class)
interface LikedCatsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addCat(cat: Likes)
    @Query("SELECT * FROM liked_cats_table ORDER BY id")
    fun readAllData(): LiveData<List<Likes>>
}