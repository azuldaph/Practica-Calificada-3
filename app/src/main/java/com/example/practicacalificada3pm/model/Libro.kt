package com.example.practicacalificada3pm.model

import androidx.room.Entity
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

@Entity(tableName = "book_table")
data class Libro(
    @ColumnInfo(name = "title_book")
    val title: String,

    @ColumnInfo(name = "autor_book")
    val autor: String,

    @ColumnInfo(name = "genero_book")
    val genero: String,

    @ColumnInfo(name = "editorial_book")
    val editorial: String,

    @ColumnInfo(name = "resumen_book")
    val resumen: String){

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "book_id")
    var bookID: Int = 0

}


