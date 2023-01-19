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

class MainActivity : AppCompatActivity(), OnFragmentEventListener, View.OnClickListener {
    private lateinit var alumnos:ArrayList<Alumno>
    private lateinit var spinner:Spinner
    private lateinit var btnDatos:Button
    private lateinit var btnFotos:Button
    val fragmento1 = FragmentDatos()
    val fragmento2 = FragmentFotos()
    val manager = supportFragmentManager
    var frag1=true
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

        btnDatos=findViewById(R.id.btnDatos)
        btnFotos=findViewById(R.id.btnFoto)

        btnDatos.setOnClickListener(this)
        btnFotos.setOnClickListener(this)
    }






    override fun onFragmentEvent(alumno: Alumno) {

    }

    override fun onClick(v: View?) {
        val transaction = manager.beginTransaction()
        when(v?.id){
            R.id.btnDatos->{
                frag1=false
                transaction.replace(R.id.frame, fragmento1)
                /**
                 * El addToBackStack lo ponemos para que guarde la informacion de los clicks que le hemos dados
                 * Si cambiamos muchas veces entre fragments y luego vamos para atras, lo que tiene que pasar
                 * es que volvamos hacia atras todas la veces que le hemos dado anteriormente
                 */
                transaction.addToBackStack(null)
                transaction.commit()
            }
            R.id.btnFoto->{
                frag1=true
                transaction.replace(R.id.frame, fragmento2)
                transaction.addToBackStack(null)
                transaction.commit()
            }
        }
    }
}