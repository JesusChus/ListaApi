package com.chusdevil.ejerciciosemifinal

import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("products")
    fun traerLibro() : Call<RespuestaApiTodosProductos>
}