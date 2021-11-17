package br.pucminas.iot.mov.sakilakotlinalunos.api

interface IFilmApi {
    suspend fun listAll(token: String) : List<FilmApi_ListAllOutputItem>
}

data class FilmApi_ListAllOutputItem (
    val filmId: Int,
    val title: String
)