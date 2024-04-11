package com.chusdevil.ejerciciosemifinal

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.squareup.picasso.Picasso

class ElementoListaViewHolder(itemView: View) : ViewHolder(itemView) {
    private val texto = itemView.findViewById<TextView>(R.id.tvTexto)
    private val texto3 = itemView.findViewById<TextView>(R.id.tvTexto3)
    private val imagen2 = itemView.findViewById<ImageView>(R.id.ivImagen)




    fun ingresarDatos (titulo: String, imagen: String, precio: String,  ){
        Picasso.get().load(imagen).into(imagen2)
        texto.text = titulo
        texto3.text = precio.toString()



    }
}