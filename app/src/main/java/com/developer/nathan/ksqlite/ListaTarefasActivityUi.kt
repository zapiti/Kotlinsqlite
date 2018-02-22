package com.developer.nathan.ksqlite

import android.graphics.Color
import org.jetbrains.anko.*

/**
 * Generate with Plugin
 * @plugin Kotlin Anko Converter For Xml
 * @version 1.2.1
 */
class ListaTarefasActivityUi :  AnkoComponent<ListaTarefasActivity> {
	 companion object {
	     val activity_ordem_de_servico = 1
		 val lista_de_servico = 2
		 val novo_servico = 3
	 }

	override fun createView(ui: AnkoContext<ListaTarefasActivity>) = with(ui) {

		verticalLayout {
			id = activity_ordem_de_servico

			listView {
				id = lista_de_servico
			}.lparams(width = matchParent)
			button {
				id = novo_servico
				text = "+"
				textColor = Color.BLACK
				textSize = 40f //sp
			//	elevation = dip(6).toFloat()
				backgroundResource = R.drawable.fundo
				//android:stateListAnimator = @null //not support attribute
			}.lparams(width = dip(56), height = dip(56)) {
//				alignParentBottom()
//				alignParentRight()
				bottomMargin = dip(16)
				rightMargin = dip(16)
			}
		}
	}
}
