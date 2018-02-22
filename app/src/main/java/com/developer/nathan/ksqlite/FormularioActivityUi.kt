package com.developer.nathan.ksqlite

import android.widget.LinearLayout
import org.jetbrains.anko.*

/**
 * Created by natha on 22/02/2018.
 */
class FormularioActivityUi: AnkoComponent<FormularioActivity> {
    companion object {
        val formulario_problema = 1
        val formulario_cod_parceiro = 2
        val formulario_prioridade = 3
        val formulario_solucao = 4
        val spinner = 6
        val formulario_agendamento_data = 7
        val formulario_executante_usuario = 8
        val formulario_executante_data = 9
        val formulario_hora_inicial = 10
        val formulario_hora_final = 11
        val formulario_produto = 12
        val formulario_servico = 13
        val formulario_status = 14
        val formulario_classificacao = 15
        val formulario_motivo = 16
        val formulario_intervalo = 17
        val formulario_data_hora_pausa = 18

    }

    override fun createView(ui: AnkoContext<FormularioActivity>) = with(ui) {

        scrollView {
            linearLayout {
                orientation = LinearLayout.VERTICAL

                    editText {
                        hint = "Problema"
                        id = formulario_problema
                    }.lparams {
                        width = matchParent
                        height = wrapContent

                    }

                editText {
                    hint = "cod.parceiro"
                    id = formulario_cod_parceiro
                }.lparams(width = matchParent, height = wrapContent)
                editText {
                    hint = "Prioridade"
                    id = formulario_prioridade
                }.lparams(width = matchParent, height = wrapContent)
                editText {
                    hint = "Solucao"
                    id = formulario_solucao
                }.lparams(width = matchParent, height = 70)

                editText {
                    hint = "AgendamentoDT"
                    id = formulario_agendamento_data
                }.lparams(width = matchParent, height = wrapContent)

                editText {
                    hint = "UserExecutante"
                    id = formulario_executante_usuario
                }.lparams(width = matchParent, height = wrapContent)

                editText {
                    hint = "DtExecutante"
                    id = formulario_executante_data
                }.lparams(width = matchParent, height = wrapContent)

                editText {
                    hint = "horaInicial"
                    id = formulario_hora_inicial
                }.lparams(width = matchParent, height = wrapContent)

                editText {
                    hint = "horaFinal"
                    id = formulario_hora_final
                }.lparams(width = matchParent, height = wrapContent)

                editText {
                    hint = "produto"
                    id = formulario_produto
                }.lparams(width = matchParent, height = wrapContent)

                editText {
                    hint = "servico"
                    id = formulario_servico
                }.lparams(width = matchParent, height = wrapContent)

                editText {
                    hint = "status"
                    id = formulario_status
                }.lparams(width = matchParent, height = wrapContent)

                editText {
                    hint = "classificaçao"
                    id = formulario_classificacao
                }.lparams(width = matchParent, height = wrapContent)

                editText {
                    hint = "motivo"
                    id = formulario_motivo
                }.lparams(width = matchParent, height = wrapContent)

                editText {
                    hint = "intervalo"
                    id = formulario_intervalo
                }.lparams(width = matchParent, height = wrapContent)


                editText {
                    hint = "data hora pausa"
                    id = formulario_data_hora_pausa
                }.lparams(width = matchParent, height = wrapContent)







//                spinner{
//                    id = spinner
//                    prompt = "Select a Category"
//                }
            }.lparams(width = matchParent, height = matchParent)
        }
    }


}