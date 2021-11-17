package br.pucminas.iot.mov.sakilakotlinalunos.use_cases.security

class LoginUseCaseFake : ILoginUseCase {
    override suspend fun invoke(input: LoginUseCaseInput): LoginUseCaseOutput {
        return LoginUseCaseOutput(Token = "2I5uLcBnghe8Be3Q4efbXlRHwrX4p3UK0nVBcwrCN8edBB0NKSPWjvJmmat225Z5", Status = LoginStatus.SUCCESS)
    }
}