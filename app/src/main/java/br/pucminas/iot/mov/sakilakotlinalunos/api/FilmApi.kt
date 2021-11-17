package br.pucminas.iot.mov.sakilakotlinalunos.api

import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header

interface FilmRetrofitService {

    @GET("/api/Films")
    fun listall(
        @Header("Authorization")
        token: String
    ) : Call<List<FilmApi_ListAllOutputItem>>
}

class FilmApi : IFilmApi {
    override suspend fun listAll(token: String): List<FilmApi_ListAllOutputItem> {
        val retrofit = Retrofit
            .Builder()
            .baseUrl("http://jonathanbispo.me:7000/")
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create()
                ))
            .build()

        return retrofit.create(
            FilmRetrofitService::class.java
        ).listall(token).execute().body()!!
    }
}