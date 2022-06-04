package com.example.practicacalificada3pm.model.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.practicacalificada3pm.model.Libro

@Dao
interface LibroDao {

    @Insert
    fun insert(libro: Libro)

    @Update
    fun update(libro: Libro)

    @Delete
    fun delete(libro: Libro)

    @Query("SELECT * FROM book_table ORDER BY title_book DESC")
    fun getListBook(): LiveData<List<Libro>>

    @Query("UPDATE book_table SET title_book=:title, autor_book=:autor, genero_book=:genero, editorial_book=:editorial, resumen_book=:resumen WHERE book_id=:id")
    fun update(title: String, autor: String, genero: String, editorial: String, resumen: String, id: Int)

}