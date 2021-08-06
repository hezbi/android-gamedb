package com.islamistudio.gamedb.core.data.source.remote

import android.util.Log
import com.islamistudio.gamedb.BuildConfig
import com.islamistudio.gamedb.core.data.source.remote.network.ApiResponse
import com.islamistudio.gamedb.core.data.source.remote.network.ApiService
import com.islamistudio.gamedb.core.data.source.remote.response.GameResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {

    suspend fun getAllGame(): Flow<ApiResponse<List<GameResponse>>> {
        return flow {
            try {
                val response = apiService.getGameList(BuildConfig.API_KEY)
                val dataArray = response.results
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getGame(id: Int): Flow<ApiResponse<GameResponse>> {
        return flow {
            try {
                val response = apiService.getGame(id, BuildConfig.API_KEY)
                val data = response.
            } catch (e: Exception) {

            }
        }
    }
}