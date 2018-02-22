package com.developer.nathan.ksqlite

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.*
import com.developer.nathan.ksqlite.dao.AlunoDAO
import com.developer.nathan.ksqlite.modelo.Aluno

class ListaAlunosActivity : AppCompatActivity() {

    private var listaAlunos: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_alunos)

        listaAlunos = findViewById(R.id.lista_alunos)

        listaAlunos!!.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, id ->
            val aluno = listaAlunos!!.getItemAtPosition(position) as Aluno
            val intentVaiProFormulario = Intent(this@ListaAlunosActivity, FormularioActivity::class.java)
            intentVaiProFormulario.putExtra("aluno", aluno)
            startActivity(intentVaiProFormulario)
        }

        val novoAluno = findViewById<Button>(R.id.novo_aluno)
        novoAluno.setOnClickListener {
            val intentVaiProFormulario = Intent(this@ListaAlunosActivity, FormularioActivity::class.java)
            startActivity(intentVaiProFormulario)
        }

        registerForContextMenu(listaAlunos)
    }

    override fun onResume() {
        super.onResume()
        carregaLista()
    }

    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo) {
        val deletar = menu.add("Deletar")
        deletar.setOnMenuItemClickListener {
            val info = menuInfo as AdapterView.AdapterContextMenuInfo
            val aluno = listaAlunos!!.getItemAtPosition(info.position) as Aluno
            Toast.makeText(this@ListaAlunosActivity, "Deletar o aluno " + aluno.nome, Toast.LENGTH_SHORT).show()

            val dao = AlunoDAO(this@ListaAlunosActivity)
            dao.deleta(aluno)
            dao.close()

            carregaLista()
            false
        }
    }

    private fun carregaLista() {
        val dao = AlunoDAO(this)
        val alunos = dao.buscaAlunos()
        dao.close()

        val adapter = ArrayAdapter<Aluno>(this, android.R.layout.simple_list_item_1, alunos)
        listaAlunos!!.adapter = adapter
    }
}
