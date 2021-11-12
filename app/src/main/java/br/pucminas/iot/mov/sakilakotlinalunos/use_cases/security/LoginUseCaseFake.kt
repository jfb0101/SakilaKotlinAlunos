package br.pucminas.iot.mov.sakilakotlinalunos.use_cases.security

class LoginUseCaseFake : ILoginUseCase {
    override suspend fun invoke(input: LoginUseCaseInput): LoginUseCaseOutput {
        return LoginUseCaseOutput(Token = "123", Status = LoginStatus.SUCCESS)
    }
}