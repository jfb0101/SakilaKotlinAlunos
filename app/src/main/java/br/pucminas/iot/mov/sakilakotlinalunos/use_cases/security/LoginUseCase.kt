package br.pucminas.iot.mov.sakilakotlinalunos.use_cases.security

import br.pucminas.iot.mov.sakilakotlinalunos.api.UserApi
import br.pucminas.iot.mov.sakilakotlinalunos.api.UserApi_LoginInput
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginUseCase : ILoginUseCase {
    override suspend fun invoke(input: LoginUseCaseInput): LoginUseCaseOutput = withContext(Dispatchers.Default) {
        val userApi = UserApi()

        val loginResponse = userApi.login(UserApi_LoginInput(
            username = input.Username,
            password = input.Password
        ))

        return@withContext LoginUseCaseOutput(Status = LoginStatus.SUCCESS, Token = loginResponse.id)
    }
}