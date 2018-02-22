package com.developer.nathan.ksqlite.modelo

import java.io.Serializable

/**
 * Created by natha on 22/02/2018.
 */
class Tarefa(
        var id: Long = 0,
        var problema: String = "",
        var cod_parceiro: String = "",
        var prioridade: String = "",
        var solucao: String = "",
        var agendamento : String = "",
        var executante : String = "",
        var dt_execucao : String = "",
        var hora_inicial : String = "",
        var hora_final : String = "",
        var produto : String = "",
        var servico : String = "",
        var status : String = "",
        var classificacao : String = "",
        var motivo : String = "",
        var intervalo : String = "",
        var data_hora_pausa_aplicativo : String = ""

) : Serializable
