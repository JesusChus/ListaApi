package com.chusdevil.ejerciciosemifinal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter

class ListaAdaptador(val textos: MutableList<ElementoDeLista>) : Adapter<ElementoListaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElementoListaViewHolder {
        val elementoXml =
            LayoutInflater.from(parent.context).inflate(R.layout.elemento_lista, parent, false)
        val elemento = ElementoListaViewHolder(elementoXml)
        return elemento
    }

    override fun getItemCount(): Int {
        return textos.size
    }

    override fun onBindViewHolder(holder: ElementoListaViewHolder, position: Int) {
        val valor : ElementoDeLista = textos[position]
        holder.ingresarDatos(valor.titulo, valor.imagen, valor.descripcion)

    }
}