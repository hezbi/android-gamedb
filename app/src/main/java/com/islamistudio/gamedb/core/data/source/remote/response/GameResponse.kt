package com.islamistudio.gamedb.core.data.source.remote.response

import com.google.gson.annotations.SerializedName
import com.islamistudio.gamedb.core.domain.model.Developer
import com.islamistudio.gamedb.core.domain.model.Platform
import com.islamistudio.gamedb.core.domain.model.Publisher

data class GameResponse(

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("metacritic")
    val metacritic: Int,

    @field:SerializedName("released")
    val released: String,

    @field:SerializedName("background_image")
    val backgroundImage: String,

    @field:SerializedName("rating")
    val rating: Double
)
