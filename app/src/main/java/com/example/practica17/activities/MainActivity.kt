package com.example.practica17.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.example.practica17.R
import com.example.practica17.fragments.FragmentDatos
import com.example.practica17.fragments.FragmentFotos
import com.example.practica17.interfaces.OnFragmentEventListener
import com.example.practica17.model.Alumno

class MainActivity : AppCompatActivity(), OnFragmentEventListener {
    private lateinit var alumnos:ArrayList<Alumno>
    private lateinit var spinner:Spinner
    private lateinit var btnDatos:Button
    private lateinit var btnFotos:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        spinner=findViewById(R.id.spinner)
        alumnos= ArrayList<Alumno>()
            alumnos.add(Alumno("Juan","Lopez","71183498e",1))
            alumnos.add(Alumno("Pedro","Dominguez","78876392W",2))
            alumnos.add(Alumno("Lucia","Ruiz","78893872e",2))
            alumnos.add(Alumno("Maria","Martin","8987762T",2))

        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item, alumnos)
        spinner.adapter=adapter

        /**var fragment: Fragment? = null
         * fragment = ImageFragment()
        val args = Bundle()
        args.putInt(resources.getString(R.string.image), item.imageId)
        fragment.arguments = args
        // Añade el fragmento
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.add(R.id.layout, fragment)
        transaction.commit()
         */
        btnDatos=findViewById(R.id.btnDatos)
        btnFotos=findViewById(R.id.btnFoto)

    }

    var frag1=true
    fun cambiarFragment(view: View){
        val fragmento1 = FragmentDatos()
        val fragmento2 = FragmentFotos()
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        if(frag1){
            frag1=false
            transaction.replace(R.id.frame, fragmento1)
            transaction.addToBackStack(null)
            transaction.commit()
        }else{
            transaction.replace(R.id.frame, fragmento2)
            transaction.addToBackStack(null)
            transaction.commit()
        }

    }

    override fun onFragmentEvent(alumno: Alumno) {

    }
}