package com.example.practicacalificada3pm.vistas.book

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.practicacalificada3pm.database.TecsupRoomDatabase
import com.example.practicacalificada3pm.model.Libro
import com.example.practicacalificada3pm.model.dao.LibroDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BookRepository(application: Application) {

    private val bookDao: LibroDao? = TecsupRoomDatabase.getInstance(application)?.libroDao()

    fun getBooks(): LiveData<List<Libro>>{
        return bookDao?.getListBook()!!
    }

    suspend fun insertBookWithCorouties(book: Libro){
        processInsertBook(book)
    }

    private suspend fun processInsertBook(book: Libro){
        withContext(Dispatchers.Default){
            bookDao?.insert(book)
        }
    }
}

