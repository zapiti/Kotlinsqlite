package com.developer.nathan.ksqlite.dao

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.developer.nathan.ksqlite.modelo.Aluno
import java.util.ArrayList

/**
 * Created by natha on 22/02/2018.
 */
class AlunoDAO(context: Context) : SQLiteOpenHelper(context, "Agenda", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        val sql = "CREATE TABLE Alunos (id INTEGER PRIMARY KEY, nome TEXT NOT NULL, endereco TEXT, telefone TEXT, site TEXT, nota REAL)"
        db.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        val sql = "DROP TABLE IF EXISTS Alunos"
        db.execSQL(sql)
        onCreate(db)
    }

    fun insere(aluno: Aluno) {
        val db = writableDatabase

        val dados = pegaDadosDoAluno(aluno)

        db.insert("Alunos", null, dados)
    }

    private fun pegaDadosDoAluno(aluno: Aluno): ContentValues {
        val dados = ContentValues()
        dados.put("nome", aluno.nome)
        dados.put("endereco", aluno.endereco)
        dados.put("telefone", aluno.telefone)
        dados.put("site", aluno.site)
        dados.put("nota", aluno.nota)
        return dados
    }

    fun buscaAlunos(): List<Aluno> {
        val sql = "SELECT * from Alunos;"
        val db = readableDatabase
        val c = db.rawQuery(sql, null)

        val alunos = ArrayList<Aluno>()
        while (c.moveToNext()) {
            val aluno = Aluno()
            aluno.id = (c.getLong(c.getColumnIndex("id")))
            aluno.nome = (c.getString(c.getColumnIndex("nome")))
            aluno.endereco = (c.getString(c.getColumnIndex("endereco")))
            aluno.telefone = (c.getString(c.getColumnIndex("telefone")))
            aluno.site = (c.getString(c.getColumnIndex("site")))
            aluno.nota = (c.getDouble(c.getColumnIndex("nota")))
            alunos.add(aluno)
        }
        c.close()
        return alunos
    }

    fun deleta(aluno: Aluno) {
        val db = writableDatabase
        val params = arrayOf<String>(aluno.id.toString())
        db.delete("Alunos", "id = ?", params)
    }

    fun altera(aluno: Aluno) {
        val db = writableDatabase

        val dados = pegaDadosDoAluno(aluno)

        val params = arrayOf<String>(aluno.id.toString())
        db.update("Alunos", dados, "id = ?", params)
    }
}
