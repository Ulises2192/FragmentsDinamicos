package com.ulisesdiaz.fragmentsdinamicos

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MyFragment : Fragment() {

    var listener: NombreListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_my, container, false)
        val boton = view.findViewById<Button>(R.id.boton)
        val editNombre = view.findViewById<EditText>(R.id.editNombre)

        boton.setOnClickListener {
           listener?.obtenerNombre(editNombre.text.toString())
        }
        return view
    }

    interface NombreListener{
        fun obtenerNombre(nombre: String)
    }

    /**
     * Se ejecuta cuando el componente se Attacha mas no esta inicializad
     */
    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            listener = context as NombreListener
        }catch (e: ClassCastException){
            throw ClassCastException(context.toString() + " Debes implementar la interface")
        }
    }
}