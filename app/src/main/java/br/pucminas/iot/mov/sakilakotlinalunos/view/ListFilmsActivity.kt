package br.pucminas.iot.mov.sakilakotlinalunos.view

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import br.pucminas.iot.mov.sakilakotlinalunos.R
import br.pucminas.iot.mov.sakilakotlinalunos.models.Film
import br.pucminas.iot.mov.sakilakotlinalunos.use_cases.films.IListFilmsUseCase
import br.pucminas.iot.mov.sakilakotlinalunos.use_cases.films.ListFilmsUseCase
import br.pucminas.iot.mov.sakilakotlinalunos.use_cases.films.ListFilmsUseCaseFake
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ListFilmsAdapter (
    private val filmsList: List<Film>,
    private val activity: Activity
) : BaseAdapter() {
    override fun getCount(): Int {
        return filmsList.size
    }

    override fun getItem(position: Int): Any {
        return filmsList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(activity).inflate(R.layout.list_films_item, null)
        val txtTitle = view.findViewById<TextView>(R.id.txtTitle)

        txtTitle.text = filmsList.get(position).title

        return view
    }

}

class ListFilmsActivity : AppCompatActivity() {
    lateinit var listFilmsUseCase: IListFilmsUseCase
    lateinit var scope:CoroutineScope
    lateinit var lvFilms: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_films)

        listFilmsUseCase = ListFilmsUseCase()

        scope = CoroutineScope(Job() + Dispatchers.Main)

        lvFilms = findViewById(R.id.lvFilms)

        scope.launch {
            lvFilms.adapter = ListFilmsAdapter(listFilmsUseCase(token = ""), this@ListFilmsActivity)
        }

    }
}