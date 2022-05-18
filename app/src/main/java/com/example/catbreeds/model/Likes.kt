package com.example.catbreeds.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "liked_cats_table")
data class Likes(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val name : String) {
}