package com.example.catbreeds.model

data class Breed(val name : String? = "",

                 val description : String? ="",
                 val origin : String? ="",
                 val wikipediaUrl : String?="",
                 val lifeSpan : String? = "",
                 val dogFriendly : Int? = Int.MIN_VALUE){


}

data class Items(val height : Int , val id : String, val url : String, val width : Int) {


}