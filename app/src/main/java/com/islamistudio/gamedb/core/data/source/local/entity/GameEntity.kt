package com.islamistudio.gamedb.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.*
import com.islamistudio.gamedb.core.domain.model.Developer
import com.islamistudio.gamedb.core.domain.model.Platform
import com.islamistudio.gamedb.core.domain.model.Publisher
import com.islamistudio.gamedb.core.utils.DataConverter

@Entity(tableName = "game")
data class GameEntity(

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "metacritic")
    val metacritic: Int,

    @ColumnInfo(name = "released")
    val released: String,

    @ColumnInfo(name = "backgroundImage")
    val backgroundImage: String,

    @ColumnInfo(name = "rating")
    val rating: Double,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false

)
