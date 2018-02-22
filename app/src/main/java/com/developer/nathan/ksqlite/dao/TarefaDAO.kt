package com.developer.nathan.ksqlite.dao

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.developer.nathan.ksqlite.modelo.Tarefa
import java.util.ArrayList

/**
 * Created by natha on 22/02/2018.
 */
class TarefaDAO(context: Context) : SQLiteOpenHelper(context, "Tarefa", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        val sql = "CREATE TABLE Tarefas(id INTEGER PRIMARY KEY," +
                " problema TEXT NOT NULL," +
                " cod_parceiro TEXT," +
                " prioridade TEXT," +
                " solucao TEXT," +
                " agendamento TEXT NOT NULL," +
                " executante TEXT NOT NULL," +
                " dt_execucao TEXT NOT NULL," +
                " hora_inicial TEXT NOT NULL," +
                " hora_final TEXT NOT NULL," +
                " produto TEXT NOT NULL," +
                " servico TEXT NOT NULL," +
                " status TEXT NOT NULL," +
                " classificacao TEXT NOT NULL," +
                " motivo TEXT NOT NULL," +
                " intervalo TEXT NOT NULL," +
                " data_hora_pausa_aplicativo TEXT NOT NULL)"

        db.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        val sql = "DROP TABLE IF EXISTS Tarefas"
        db.execSQL(sql)
        onCreate(db)
    }

    fun insere(tarefa: Tarefa) {
        val db = writableDatabase

        val dados = pegaDadosDaTarefa(tarefa)

        db.insert("Tarefas", null, dados)
    }

    private fun pegaDadosDaTarefa(tarefa: Tarefa): ContentValues {
        val dados = ContentValues()
        dados.put("problema", tarefa.problema)
        dados.put("cod_parceiro", tarefa.cod_parceiro)
        dados.put("prioridade", tarefa.prioridade)
        dados.put("solucao", tarefa.solucao)
        dados.put("agendamento", tarefa.agendamento)
        dados.put("executante", tarefa.executante)
        dados.put("dt_execucao", tarefa.dt_execucao)
        dados.put("hora_inicial", tarefa.hora_inicial)
        dados.put("hora_final", tarefa.hora_final)
        dados.put("produto", tarefa.produto)
        dados.put("servico", tarefa.servico)
        dados.put("status", tarefa.status)
        dados.put("classificacao", tarefa.classificacao)
        dados.put("motivo", tarefa.motivo)
        dados.put("intervalo", tarefa.intervalo)
        dados.put("data_hora_pausa_aplicativo", tarefa.data_hora_pausa_aplicativo)

        return dados
    }

    fun buscaTarefas(): ArrayList<Tarefa> {
        val sql = "SELECT * from Tarefas;"
        val db = readableDatabase
        val c = db.rawQuery(sql, null)

        val tarefas = ArrayList<Tarefa>()
        while (c.moveToNext()) {
            val tarefa = Tarefa()
            tarefa.id = (c.getLong(c.getColumnIndex("id")))
            tarefa.problema = (c.getString(c.getColumnIndex("problema")))
            tarefa.cod_parceiro = (c.getString(c.getColumnIndex("cod_parceiro")))
            tarefa.prioridade = (c.getString(c.getColumnIndex("prioridade")))
            tarefa.solucao = (c.getString(c.getColumnIndex("solucao")))
            tarefa.agendamento = (c.getString(c.getColumnIndex("agendamento")))
            tarefa.executante = (c.getString(c.getColumnIndex("executante")))
            tarefa.dt_execucao = (c.getString(c.getColumnIndex("dt_execucao")))
            tarefa.hora_inicial = (c.getString(c.getColumnIndex("hora_inicial")))
            tarefa.hora_final = (c.getString(c.getColumnIndex("hora_final")))
            tarefa.produto = (c.getString(c.getColumnIndex("produto")))
            tarefa.servico = (c.getString(c.getColumnIndex("servico")))
            tarefa.status = (c.getString(c.getColumnIndex("status")))
            tarefa.classificacao = (c.getString(c.getColumnIndex("classificacao")))
            tarefa.motivo = (c.getString(c.getColumnIndex("motivo")))
            tarefa.intervalo = (c.getString(c.getColumnIndex("intervalo")))
            tarefa.data_hora_pausa_aplicativo = (c.getString(c.getColumnIndex("data_hora_pausa_aplicativo")))



            tarefas.add(tarefa)
        }
        c.close()
        return tarefas
    }

    fun deleta(tarefa: Tarefa) {
        val db = writableDatabase
        val params = arrayOf<String>(tarefa.id.toString())
        db.delete("Tarefas", "id = ?", params)
    }

    fun altera(tarefa: Tarefa) {
        val db = writableDatabase

        val dados = pegaDadosDaTarefa(tarefa)

        val params = arrayOf<String>(tarefa.id.toString())
        db.update("Tarefas", dados, "id = ?", params)
    }
}
