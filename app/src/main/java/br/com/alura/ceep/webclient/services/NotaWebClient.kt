package br.com.alura.ceep.webclient.services

import android.util.Log
import br.com.alura.ceep.model.Nota
import br.com.alura.ceep.webclient.RetrofitInicializador




private const val TAG = "NotaWebClient"


class NotaWebClient {

  private val notaService: NotaService =
      RetrofitInicializador().notaService

    suspend fun buscaTodas(): List<Nota>? {
         return try {

             val notasResposta = notaService.buscaTodas()

             notasResposta.map { notaResposta -> notaResposta.nota }
        }
         catch (e: Exception) {
             Log.e(TAG,"buscaTodas: ",e)
             null
        }

    }

}