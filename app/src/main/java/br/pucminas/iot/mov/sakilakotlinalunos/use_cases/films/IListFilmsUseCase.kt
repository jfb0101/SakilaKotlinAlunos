package br.pucminas.iot.mov.sakilakotlinalunos.use_cases.films

import br.pucminas.iot.mov.sakilakotlinalunos.models.Film

interface IListFilmsUseCase {
    suspend operator fun invoke(token: String) : List<Film>
}