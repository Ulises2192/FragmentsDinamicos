package com.ulisesdiaz.fragmentsdinamicos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), MyFragment.NombreListener {

    var txtNombre: TextView? = null
    var btnAddFragment: Button? = null
    var btnRemplazar: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtNombre = findViewById(R.id.txtNombre)
        btnAddFragment = findViewById(R.id.btnAnadirFragment)
        btnRemplazar = findViewById(R.id.btnRemplazar)

        val fragmentManager = supportFragmentManager


        btnAddFragment?.setOnClickListener {
            val fragmentTransaction = fragmentManager.beginTransaction()
            val nuevoFragmento = MyFragment()
            fragmentTransaction.add(R.id.container, nuevoFragmento)

            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        btnRemplazar?.setOnClickListener {
            val fragmentTransaction = fragmentManager.beginTransaction()
            val nuevoFraagmento = Componente2Fragment()
            fragmentTransaction.replace(R.id.container, nuevoFraagmento)

            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
    }

    override fun obtenerNombre(nombre: String) {
        txtNombre?.text = nombre
    }
}