package com.developer.nathan.ksqlite

import android.widget.EditText
import android.widget.RatingBar
import com.developer.nathan.ksqlite.modelo.Aluno

/**
 * Created by natha on 22/02/2018.
 */
class FormularioHelper(activity: FormularioActivity) {

    private val campoNome: EditText
    private val campoEndereco: EditText
    private val campoTelefone: EditText
    private val campoSite: EditText
    private val campoNota: RatingBar

    private var aluno: Aluno? = null

    init {
        campoNome = activity.findViewById(R.id.formulario_nome) as EditText
        campoEndereco = activity.findViewById(R.id.formulario_endereco) as EditText
        campoTelefone = activity.findViewById(R.id.formulario_telefone) as EditText
        campoSite = activity.findViewById(R.id.formulario_site) as EditText
        campoNota = activity.findViewById(R.id.formulario_nota) as RatingBar
        aluno = Aluno()
    }

    fun getAluno(): Aluno {
        aluno!!.nome = (campoNome.text.toString())
        aluno!!.endereco = (campoEndereco.text.toString())
        aluno!!.telefone = (campoTelefone.text.toString())
        aluno!!.site = (campoSite.text.toString())
        aluno!!.nota = campoNota.progress.toDouble()

        return aluno as Aluno
    }

    fun preencheFormulario(aluno: Aluno) {
        campoNome.setText(aluno.nome)
        campoEndereco.setText(aluno.endereco)
        campoTelefone.setText(aluno.telefone)
        campoSite.setText(aluno.site)
        campoNota.progress = aluno.nota!!.toInt()
        this.aluno = aluno
    }
}
