package br.pucminas.iot.mov.sakilakotlinalunos.use_cases.films

import br.pucminas.iot.mov.sakilakotlinalunos.models.Film

class ListFilmsUseCaseFake : IListFilmsUseCase {
    override suspend fun invoke(token: String): List<Film> {
        return listOf(
            Film(id = 1, title = "Filme 1"),
            Film(id = 2, title = "Filme 2")
        )
    }
}