package br.pucminas.iot.mov.sakilakotlinalunos.api

interface IUserApi {
    suspend fun login(input: UserApi_LoginInput) : UserApi_LoginOutput
}

data class UserApi_LoginInput (
    val username: String,
    val password: String
)

data class UserApi_LoginOutput (
    val id: String,
    val ttl: Int
)