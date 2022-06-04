package com.example.practicacalificada3pm.vistas.book

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.practicacalificada3pm.model.Libro
import kotlinx.coroutines.launch

class BookViewModel(application: Application): AndroidViewModel(application){

    private val repository = BookRepository(application)

    val books = repository.getBooks()

    fun saveBook(libro: Libro){
        viewModelScope.launch{
            repository.insertBookWithCorouties(libro)
        }
    }
}

