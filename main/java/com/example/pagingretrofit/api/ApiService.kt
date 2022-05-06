package com.example.pagingretrofit.api

import com.example.pagingretrofit.models.ResponseApi
import com.example.pagingretrofit.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getAllCharacters(
        @Query("page") page: Int
    ):Response<ResponseApi>


}