package com.example.catbreeds.model

import android.content.ClipData
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
@Entity(tableName = "liked_cats_table")
data class Breed(
    @ColumnInfo(name = "name")
    @SerializedName("name")
    val name : String? = "",
    @ColumnInfo(name = "image")
    @SerializedName("image")
    val image : Items,
    @ColumnInfo(name = "description")
    @SerializedName("description")
    val description : String? ="",
    @ColumnInfo(name = "origin")
    @SerializedName("origin")
    val origin : String? ="",
    @ColumnInfo(name = "wikipedia_url")
    @SerializedName("wikipedia_url")
    val wikipediaUrl : String? ="",
    @ColumnInfo(name = "life_span")
    @SerializedName("life_span")
    val lifeSpan : String? = "",
    @ColumnInfo(name = "dog_friendly")
    @SerializedName("dog_friendly")
    val dogFriendly : Int? = Int.MIN_VALUE,
    @ColumnInfo(name = "isLiked")
    var IsCatliked: Boolean?,
                 ) : Parcelable{
    @PrimaryKey(autoGenerate = true)
    var catId : Int = 0
}

@Parcelize
data class Items( val url : String) : Parcelable {


}