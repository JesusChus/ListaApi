package com.chusdevil.ejerciciosemifinal

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    private val textos = mutableListOf<ElementoDeLista>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//          ****INICIALIZA LA LISTA VISUAL*****
        val lista = findViewById<RecyclerView>(R.id.rvLista)
        val adapter = ListaAdaptador(textos)
        lista.layoutManager = LinearLayoutManager(this)
        lista.adapter = adapter

//      ***TRAER LA LISTA DE DATOS DE LA API***
        val retroFit = inicializarRetroFit()
        val miApi = retroFit.create(Api::class.java)
        miApi.traerLibro().enqueue(object : Callback<RespuestaApiTodosProductos> {
            override fun onResponse(
                p0: Call<RespuestaApiTodosProductos>,
                p1: Response<RespuestaApiTodosProductos>
            ) {
                val productos = p1.body()!!


                productos.products.forEach {
                    textos.add(ElementoDeLista(it.title, it.thumbnail, it.description))

                }


                adapter.notifyDataSetChanged()
            }

            override fun onFailure(p0: Call<RespuestaApiTodosProductos>, p1: Throwable) {
                toast()
            }

        })
    }

    private fun inicializarRetroFit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    private fun toast() {
        Toast.makeText(this, "NO FUNCIONA", Toast.LENGTH_SHORT).show()
    }
}


//                textos.add(ElementoDeLista(productos.products[0].title,productos.products[0].thumbnail))
//                var lol = 0
//                repeat(nombre.characters.size){
//                    textos.add(nombre.characters[lol])
//                    lol++
//                }