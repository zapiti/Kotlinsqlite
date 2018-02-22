package com.developer.nathan.ksqlite

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.developer.nathan.ksqlite.dao.TarefaDAO
import com.developer.nathan.ksqlite.modelo.Tarefa

import org.jetbrains.anko.setContentView

/**
 * Created by natha on 22/02/2018.
 */
class FormularioActivity : AppCompatActivity() {

    private var helper: FormularioHelper? = null
    lateinit var ui : FormularioActivityUi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = FormularioActivityUi()
        ui.setContentView(this)


        helper = FormularioHelper(this)

        val intent = intent
        val tarefa = intent.getSerializableExtra("tarefa") as? Tarefa

        if (tarefa != null) {
            helper!!.preencheFormulario(tarefa)
        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_formulario, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_formulario_ok -> {
                val tarefa = helper!!.getTarefa()
                val dao = TarefaDAO(this)

                if (tarefa.id != 0.toLong()) {
                    dao.altera(tarefa)
                } else {
                    dao.insere(tarefa)
                }


                dao.close()
                Toast.makeText(this@FormularioActivity, "Tarefa " + tarefa.executante + " salvo!", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
