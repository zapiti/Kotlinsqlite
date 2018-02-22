package com.developer.nathan.ksqlite

import android.widget.EditText
import com.developer.nathan.ksqlite.modelo.Tarefa

/**
 * Created by natha on 22/02/2018.
 */
class FormularioHelper(activity: FormularioActivity) {

    private val campoFProblema: EditText
    private val campoFCodParceiro: EditText
    private val campoFPrioridade: EditText
    private val campoFSolucao: EditText
    private val campoFAgendamentoDT: EditText
    private val campoFExecutante: EditText
    private val campoFExecucaoDT: EditText
    private val campoFHInicial: EditText
    private val campoFHFinal: EditText
    private val campoFProduto: EditText
    private val campoFServico: EditText
    private val campoFStatus: EditText
    private val campoFClassicacao: EditText
    private val campoFMotivo: EditText
    private val campoFIntervalo: EditText
    private val campoFHPausaAppDT: EditText



    private var tarefa: Tarefa? = null

    init {
        campoFProblema = activity.findViewById(FormularioActivityUi.formulario_problema) as EditText
        campoFCodParceiro = activity.findViewById(FormularioActivityUi.formulario_cod_parceiro) as EditText
        campoFPrioridade = activity.findViewById(FormularioActivityUi.formulario_prioridade) as EditText
        campoFSolucao = activity.findViewById(FormularioActivityUi.formulario_solucao) as EditText
        campoFAgendamentoDT = activity.findViewById(FormularioActivityUi.formulario_agendamento_data) as EditText
        campoFExecutante = activity.findViewById(FormularioActivityUi.formulario_executante_usuario) as EditText
        campoFExecucaoDT = activity.findViewById(FormularioActivityUi.formulario_executante_data) as EditText
        campoFHInicial = activity.findViewById(FormularioActivityUi.formulario_hora_inicial) as EditText
        campoFHFinal= activity.findViewById(FormularioActivityUi.formulario_hora_final) as EditText
        campoFProduto = activity.findViewById(FormularioActivityUi.formulario_produto) as EditText
        campoFServico = activity.findViewById(FormularioActivityUi.formulario_servico) as EditText
        campoFStatus = activity.findViewById(FormularioActivityUi.formulario_status) as EditText
        campoFClassicacao = activity.findViewById(FormularioActivityUi.formulario_classificacao) as EditText
        campoFMotivo = activity.findViewById(FormularioActivityUi.formulario_motivo) as EditText
        campoFIntervalo = activity.findViewById(FormularioActivityUi.formulario_intervalo) as EditText
        campoFHPausaAppDT = activity.findViewById(FormularioActivityUi.formulario_data_hora_pausa) as EditText



        tarefa = Tarefa()
    }

    fun getTarefa(): Tarefa {
        tarefa!!.problema = (campoFProblema.text.toString())
        tarefa!!.cod_parceiro = (campoFCodParceiro.text.toString())
        tarefa!!.prioridade = (campoFPrioridade.text.toString())
        tarefa!!.solucao = (campoFSolucao.text.toString())
        tarefa!!.executante = campoFExecutante.text.toString()
        tarefa!!.dt_execucao = campoFExecucaoDT.text.toString()
        tarefa!!.hora_inicial = campoFHInicial.text.toString()
        tarefa!!.hora_final = campoFHFinal.text.toString()
        tarefa!!.produto = campoFProduto.text.toString()
        tarefa!!.servico = campoFServico.text.toString()
        tarefa!!.status = campoFStatus.text.toString()
        tarefa!!.classificacao= campoFClassicacao.text.toString()
        tarefa!!.motivo = campoFMotivo.text.toString()
        tarefa!!.intervalo = campoFIntervalo.text.toString()
        tarefa!!.data_hora_pausa_aplicativo = campoFHPausaAppDT.text.toString()

        return tarefa as Tarefa
    }

    fun preencheFormulario(tarefa: Tarefa) {
        campoFProblema.setText(tarefa.problema)
        campoFCodParceiro.setText(tarefa.cod_parceiro.toInt())
        campoFPrioridade.setText(tarefa.prioridade)
        campoFSolucao.setText(tarefa.solucao)
        campoFAgendamentoDT.setText(tarefa.agendamento)
        campoFExecutante.setText(tarefa.executante)
        campoFExecucaoDT.setText(tarefa.dt_execucao)
        campoFHInicial.setText(tarefa.hora_inicial)
        campoFHFinal.setText(tarefa.hora_final)
        campoFProduto.setText(tarefa.produto)
        campoFServico.setText(tarefa.servico)
        campoFStatus.setText(tarefa.status)
        campoFClassicacao.setText(tarefa.classificacao)
        campoFMotivo.setText(tarefa.motivo)
        campoFIntervalo.setText(tarefa.intervalo)
        campoFHPausaAppDT.setText(tarefa.data_hora_pausa_aplicativo)


        this.tarefa = tarefa
    }
}
