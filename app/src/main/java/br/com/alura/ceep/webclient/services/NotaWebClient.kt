package br.com.alura.ceep.webclient.services

import android.util.Log
import br.com.alura.ceep.model.Nota
import br.com.alura.ceep.webclient.RetrofitInicializador
import br.com.alura.ceep.webclient.model.NotaRequisicao


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

    suspend fun salvar(nota: Nota) {
        try {
            val resposta =
                notaService.salva(nota.id, NotaRequisicao(
                nota.titulo,
                nota.descricao,
                nota.imagem,
            ))
            if (resposta.isSuccessful){
                Log.i(TAG,"salva: nota salva com suceso")
            }
            else {
                Log.i(TAG,"salva: nota não foi salva")
            }
        } catch (e: Exception) {
                Log.e(TAG,"salva: falha ao tentar salvar)",e)
        }

    }

}