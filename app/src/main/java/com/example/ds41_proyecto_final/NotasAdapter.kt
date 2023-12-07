package com.example.ds41_proyecto_final

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotasAdapter(private var noteList: MutableList<Notas>) : RecyclerView.Adapter<NotasAdapter.NotasViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotasViewHolder {
        val inflador = LayoutInflater.from(parent.context)
        val view = inflador.inflate(R.layout.item_notas, parent, false)
        return NotasViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotasViewHolder, position: Int) {
        val nota = noteList[position]
        holder.render(nota)
    }

    override fun getItemCount(): Int {
        return noteList.size
    }
    fun addNewItem(item: Notas) {
        noteList.add(item)
        notifyItemInserted(noteList.size - 1)
    }

    class NotasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titulo: TextView = itemView.findViewById(R.id.tituloTextView)
        private val desc: TextView = itemView.findViewById(R.id.descTextView)

        fun render(nota: Notas) {
            titulo.text = nota.titulo
            desc.text = nota.desc
        }
    }
}