package com.example.ds41_proyecto_final

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment() {

    private var notalist : MutableList<Notas> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        initData()
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val fab = view.findViewById<FloatingActionButton>(R.id.fab_new)
        val adapter = NotasAdapter(notalist)

        val recyclerView =
            view.findViewById<RecyclerView>(
                R.id.NotesRecycler
            )





        var _id: Int = 0
        var _titulo : String
        var _desc : String

        fab.setOnClickListener{


            val bottomSheetFragment = BottomSheetDialog(view.context)
            val parentView: View = layoutInflater.inflate(R.layout.bsd_create_note, null)
            bottomSheetFragment.setContentView(parentView)
            bottomSheetFragment.show()

            val newId = parentView.findViewById<EditText>(R.id.bsd_id)
            val newTitulo = parentView.findViewById<EditText>(R.id.bsd_titulo)
            val newDesc = parentView.findViewById<EditText>(R.id.bsd_desc)


            val button = parentView.findViewById<Button>(R.id.bsd_submit)

            button.setOnClickListener{
                _id = newId.text.toString().toInt()
                _titulo = newTitulo.text.toString()
                _desc = newDesc.text.toString()


                val newProductAdd = Notas(
                    _id,
                    _titulo,
                    _desc
                )

                notalist.add(newProductAdd)

                recyclerView.adapter?.notifyDataSetChanged()

                bottomSheetFragment.dismiss()
            }

        }

        //Lista anchura completa
        val layoutManager = LinearLayoutManager(container?.context)
        //Cuadricula 2X2
        //val gridLayoutManager = GridLayoutManager(container?.context, 2)

        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = adapter

        return view
    }


    private fun initData() {

        notalist = mutableListOf(
            Notas(1, "comida","Hogar"),
            Notas(2, "lista","hkashd"),
            Notas(3, "nota 1","asda"),
            Notas(4, "nota 2","dasdasdasdasdasd"),
            Notas(5, "lista 1","hkashd"),
            Notas(6, "nota 6","asda"),
            Notas(7, "nota 7","dorale"),
            Notas(8, "lista 10","hkashd"),
            Notas(9, "nota 111","ahelllooa"),
            Notas(10, "nota 25","notassss")



        )
    }
}