package com.example.practicacalificada3pm.vistas.book

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practicacalificada3pm.model.Libro

class BookAdapter : RecyclerView.Adapter<BookViewHolder>(){

    private var bookList = emptyList<Libro>()

    fun setBook(libros: List<Libro>){
        this.bookList = libros
        this.notifyDataSetChanged()
    }

    override fun getItemCount(): Int = bookList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return BookViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book: Libro = bookList[position]
        holder.bind(book)
    }
}

