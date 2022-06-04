package com.example.practicacalificada3pm.vistas.book

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practicacalificada3pm.R
import com.example.practicacalificada3pm.model.Libro

class BookViewHolder(inflater: LayoutInflater, parent: ViewGroup):
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_book, parent, false)){

        private var textTitle: TextView? = null
        private var textAutor: TextView? = null
        private var textGenero: TextView? = null
        private var textEditorial: TextView? = null
        private var textResumen: TextView? = null

        init{
            textTitle = itemView.findViewById(R.id.textTitle)
            textAutor = itemView.findViewById(R.id.textAutor)
            textGenero = itemView.findViewById(R.id.textCategoria)
            textEditorial = itemView.findViewById(R.id.textEditorial)
            textResumen = itemView.findViewById(R.id.textDescription)
        }

        fun bind(libro: Libro){
            textTitle?.text = libro.title
            textAutor?.text = "Autor: " + libro.autor
            textGenero?.text = "Categoría: " + libro.genero
            textEditorial?.text = "Editorial: " + libro.editorial
            textResumen?.text = libro.resumen
        }
    }

