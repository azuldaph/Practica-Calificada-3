package com.example.practicacalificada3pm.vistas.book

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicacalificada3pm.R
import com.example.practicacalificada3pm.model.Libro
import kotlinx.android.synthetic.main.dialog_book.*
import kotlinx.android.synthetic.main.dialog_book.view.*
import kotlinx.android.synthetic.main.fragment_book.*

class BookFragment: Fragment() {

    private lateinit var bookViewModel: BookViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_book, container, false)
    }

    companion object{
        fun newInstance(): BookFragment = BookFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bookViewModel = run{
            ViewModelProviders.of(this).get(BookViewModel::class.java)
        }

        fabRegisterBook.setOnClickListener{
            registerAlertBook()
        }

        loadData()
    }

    private fun loadData(){
        val adapter = BookAdapter()
        recyclerBooks.adapter = adapter
        recyclerBooks.layoutManager = LinearLayoutManager(activity)

        bookViewModel.books.observe(viewLifecycleOwner){books ->
            if (books.isNotEmpty()){
                books?.let{
                    adapter.setBook(books)
                }
            }
        }
    }

    private fun registerAlertBook(){

        val mDialogView = LayoutInflater.from(context).inflate(R.layout.dialog_book,null)

        val mBuilder = AlertDialog.Builder(context)
            .setView(mDialogView)

        val mAlertDialog = mBuilder.show()

        mAlertDialog.btnRegisterBook.setOnClickListener{

            mAlertDialog.dismiss()
            
            val titleBook = mDialogView.edtTitleBook.text.toString()
            val autorBook = mDialogView.edtAutorBook.text.toString()
            val generoBook = mDialogView.edtGeneroBook.text.toString()
            val editorialBook = mDialogView.edtEditorialBook.text.toString()
            val resumenBook = mDialogView.edtResumenBook.text.toString()

            val book = Libro(titleBook, autorBook, generoBook, editorialBook, resumenBook)

            bookViewModel.saveBook(book)

        }
    }
}