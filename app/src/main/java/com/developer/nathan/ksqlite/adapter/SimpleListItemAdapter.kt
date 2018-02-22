package com.developer.nathan.ksqlite.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.developer.nathan.ksqlite.modelo.Tarefa
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

/**
 * Created by natha on 22/02/2018.
 */

class SimpleListItemAdapter(context: Context, dataSet: ArrayList<Tarefa>) : ArrayAdapter<Tarefa>(context, 0, dataSet){
    private val context = AnkoContext.createReusable(context, this)
    var tarefa = Tarefa()


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {


        var view = convertView
        if (view == null)
            view = SimpleListItemAdapterUi().createView(context)


        //pegando os elementos
        val txNome = view.find(SimpleListItemAdapterUi.nome) as TextView
       // val spinner = view.find<Spinner>(SimpleListItemAdapterUi.spinner)


        val tarefa = getItem(position)
        if(tarefa != null){
            txNome.text = tarefa.executante
         //  spinner.adapter = adapter
        }



        return view
    }

}