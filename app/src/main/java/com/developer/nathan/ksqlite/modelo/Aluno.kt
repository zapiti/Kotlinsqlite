package com.developer.nathan.ksqlite.modelo

import java.io.Serializable

/**
 * Created by natha on 22/02/2018.
 */
class Aluno(
           var id: Long = 0,
           var nome: String = "",
           var endereco: String = "",
           var telefone: String = "",
           var site: String = "",
           var nota: Double = 0.0
) : Serializable {





    override fun toString(): String {
        return id.toString() + " - " + nome +  " - " + endereco + " - " + site+ " - " + nota
    }
}
