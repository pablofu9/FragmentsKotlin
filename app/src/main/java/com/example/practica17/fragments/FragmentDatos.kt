package com.example.practica17.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.practica17.R



class FragmentDatos : Fragment() {

    private lateinit var txtNombre:TextView
    private lateinit var txtApellidos:TextView
    private lateinit var txtDni:TextView
    private lateinit var btnDelegado:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_datos, container, false)
        txtNombre=view.findViewById(R.id.txtNombre)
        txtApellidos=view.findViewById(R.id.txtApellidos)
        txtDni=view.findViewById(R.id.txtDni)

        return view

    }
}