package com.developer.nathan.ksqlite.adapter

import android.view.Gravity

import org.jetbrains.anko.*

/**
 * Created by natha on 22/02/2018.
 */
class SimpleListItemAdapterUi : AnkoComponent<SimpleListItemAdapter> {
    companion object {
        val nome = 1
        val spinner = 2

    }

    override fun createView(ui: AnkoContext<SimpleListItemAdapter>) = with(ui) {
        textView {
            id = nome
            textSize = 22F
            height = dip(52)
            gravity = Gravity.CENTER_VERTICAL

        }

//        spinner{
//            id = spinner
//            prompt = "Select a Category"
//
//
//        }
    }
}
