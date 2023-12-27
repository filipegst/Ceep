package br.com.alura.ceep.repository

import androidx.room.Dao
import br.com.alura.ceep.database.dao.NotaDao
import br.com.alura.ceep.model.Nota
import br.com.alura.ceep.webclient.services.NotaWebClient
import kotlinx.coroutines.flow.Flow

class NotaRepository(private val dao: NotaDao, private val werbClient: NotaWebClient) {

    fun buscaTodas (): Flow<List<Nota>> {
       return dao.buscaTodas()

    }
   suspend fun atualizaTodas (){
        werbClient.buscaTodas()?.let {
            notas -> dao.salva(notas)
        }
    }

}