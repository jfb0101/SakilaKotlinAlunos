package br.pucminas.iot.mov.sakilakotlinalunos.api

import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface UserRetrofitService {

    @POST("/api/Users/login")
    fun login(
        @Body
        input: UserApi_LoginInput
    ) : Call<UserApi_LoginOutput>
}

class UserApi : IUserApi {
    override suspend fun login(input: UserApi_LoginInput): UserApi_LoginOutput {
        val retrofit = Retrofit
            .Builder()
            .baseUrl("http://jonathanbispo.me:7000/")
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create()
                ))
            .build()

        val response = retrofit.create(
            UserRetrofitService::class.java
        ).login(input).execute()

        return if (response.code() != 200) {
            UserApi_LoginOutput(id = "", ttl = 0)
        } else {
            response.body()!!
        }
    }
}