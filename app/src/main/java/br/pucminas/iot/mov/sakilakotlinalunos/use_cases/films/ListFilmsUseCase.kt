package br.pucminas.iot.mov.sakilakotlinalunos.use_cases.films

import br.pucminas.iot.mov.sakilakotlinalunos.api.FilmApi
import br.pucminas.iot.mov.sakilakotlinalunos.models.Film
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ListFilmsUseCase : IListFilmsUseCase {
    override suspend fun invoke(token: String): List<Film> = withContext(Dispatchers.Default){
        val filmApi = FilmApi()

        return@withContext filmApi.listAll(token).map {
            Film(id = it.filmId, title = it.title)
        }
    }
}