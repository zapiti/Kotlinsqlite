package com.developer.nathan.ksqlite

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.View
import android.widget.*
import com.developer.nathan.ksqlite.adapter.SimpleListItemAdapter

import com.developer.nathan.ksqlite.dao.TarefaDAO
import com.developer.nathan.ksqlite.modelo.Tarefa
import org.jetbrains.anko.setContentView

class ListaTarefasActivity : AppCompatActivity() {
    lateinit var ui: ListaTarefasActivityUi


    private var listaTarefas: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        ui = ListaTarefasActivityUi()
        ui.setContentView(this)

        listaTarefas = findViewById(ListaTarefasActivityUi.lista_de_servico)

        listaTarefas!!.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, id ->
            val tarefa = listaTarefas!!.getItemAtPosition(position) as Tarefa
            val intentVaiProFormulario = Intent(this@ListaTarefasActivity, FormularioActivity::class.java)
            intentVaiProFormulario.putExtra("tarefa", tarefa)
            startActivity(intentVaiProFormulario)
        }

        val novoTarefa = findViewById<Button>(ListaTarefasActivityUi.novo_servico)
        novoTarefa.setOnClickListener {
            val intentVaiProFormulario = Intent(this@ListaTarefasActivity, FormularioActivity::class.java)
            startActivity(intentVaiProFormulario)
        }

        registerForContextMenu(listaTarefas)
    }

    override fun onResume() {
        super.onResume()
        carregaLista()
    }

    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo) {
        val deletar = menu.add("Deletar")
        deletar.setOnMenuItemClickListener {
            val info = menuInfo as AdapterView.AdapterContextMenuInfo
            val tarefa = listaTarefas!!.getItemAtPosition(info.position) as Tarefa
            Toast.makeText(this@ListaTarefasActivity, "Deletar o tarefa " + tarefa.executante, Toast.LENGTH_SHORT).show()

            val dao = TarefaDAO(this@ListaTarefasActivity)
            dao.deleta(tarefa)
            dao.close()

            carregaLista()
            false
        }
    }

    private fun carregaLista() {
       // var arrayTarefas = ArrayList<Tarefa>()
        val dao = TarefaDAO(this)
        val tarefas = dao.buscaTarefas()
        // arrayTarefas.add(Tarefa)
        dao.close()

        val adapter = SimpleListItemAdapter(this,tarefas)//ArrayAdapter<Tarefa>(this, SimpleListItem1Activity, tarefas)
        listaTarefas!!.adapter = adapter
    }
}


