package com.developer.nathan.ksqlite

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.developer.nathan.ksqlite.dao.AlunoDAO
import com.developer.nathan.ksqlite.modelo.Aluno

/**
 * Created by natha on 22/02/2018.
 */
class FormularioActivity : AppCompatActivity() {

    private var helper: FormularioHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        helper = FormularioHelper(this)

        val intent = intent
        val aluno = intent.getSerializableExtra("aluno") as? Aluno

        if (aluno != null) {
            helper!!.preencheFormulario(aluno)
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
                val aluno = helper!!.getAluno()
                val dao = AlunoDAO(this)

                if (aluno.id != 0.toLong()) {
                    dao.altera(aluno)
                } else {
                    dao.insere(aluno)
                }


                dao.close()
                Toast.makeText(this@FormularioActivity, "Aluno " + aluno.nota + " salvo!", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
