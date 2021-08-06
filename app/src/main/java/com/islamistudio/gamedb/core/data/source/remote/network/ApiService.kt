package com.islamistudio.gamedb.core.data.source.remote.network

import com.islamistudio.gamedb.core.data.source.remote.response.GameListResponse
import com.islamistudio.gamedb.core.data.source.remote.response.GameResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("games")
    suspend fun getGameList(@Query("key") key: String): GameListResponse

    @GET("games/{id}")
    suspend fun getGame(
        @Path("id") id: Int,
        @Query("key") key: String
    ): GameResponse

}