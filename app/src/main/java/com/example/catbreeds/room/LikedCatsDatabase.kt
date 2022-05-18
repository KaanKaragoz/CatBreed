package com.example.catbreeds.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.catbreeds.model.Breed
import com.example.catbreeds.model.Likes
import com.example.catbreeds.model.TypeConverter

@Database(entities = [Likes::class], version =1, exportSchema = false)
@TypeConverters(TypeConverter::class)
abstract class LikedCatsDatabase :RoomDatabase() {

    abstract fun catsDao() : LikedCatsDao

    companion object {
        @Volatile
        private var INSTANCE: LikedCatsDatabase? = null

        fun getDatabase(context: Context) : LikedCatsDatabase {
            val tempInstance = INSTANCE
            if (tempInstance !=null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LikedCatsDatabase::class.java,
                    "cats_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

}