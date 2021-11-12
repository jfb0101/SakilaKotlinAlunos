package br.pucminas.iot.mov.sakilakotlinalunos.use_cases.security

enum class LoginStatus {
    SUCCESS, ERROR
}
data class LoginUseCaseInput (
    val Username:String,
    val Password:String
)

data class LoginUseCaseOutput (
    val Status: LoginStatus,
    val Token: String
)

interface ILoginUseCase {
    suspend operator fun invoke(input: LoginUseCaseInput) : LoginUseCaseOutput
}