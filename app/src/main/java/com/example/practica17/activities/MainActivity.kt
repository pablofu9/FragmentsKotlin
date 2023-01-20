package com.example.practica17.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
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
    private lateinit var txtDelegado :TextView
    val fragmento1 = FragmentDatos()
    val fragmento2 = FragmentFotos()
    val manager = supportFragmentManager
    var frag1=true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        spinner=findViewById(R.id.spinner)
        alumnos= ArrayList<Alumno>()
        alumnos.add(Alumno("Juan","Lopez","71183498e",R.drawable.chico1))
        alumnos.add(Alumno("Pedro","Dominguez","78876392W",R.drawable.chico2))
        alumnos.add(Alumno("Lucia","Ruiz","78893872e",R.drawable.chica1))
        alumnos.add(Alumno("Maria","Martin","8987762T",R.drawable.chica2))

        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item, alumnos)
        spinner.adapter=adapter
        txtDelegado=findViewById(R.id.txtDelegado)
        btnDatos=findViewById(R.id.btnDatos)
        btnFotos=findViewById(R.id.btnFoto)

        btnDatos.setOnClickListener(this)
        btnFotos.setOnClickListener(this)
    }






    override fun onFragmentEvent(nombre: String) {
        //Recogemos el nombre del textview de nombre del fragment y se lo ponemos al textview de delegado
        txtDelegado.text=nombre
    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.btnDatos->{
                /**
                 * Para pasar la info de la activity al fragment lo que hacemos es:
                 * Creamos un bundle y se lo pasamos como argumentos al fragmento
                 */
                frag1=false
                val bundle = Bundle()
                val alumno = spinner.selectedItem as Alumno
                val transaction = manager.beginTransaction()
                bundle.putSerializable("alumno", alumno)
                fragmento1.arguments=bundle
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
                val transaction = manager.beginTransaction()
                //Creamos el bundle
                val args = Bundle()
                //Sacamos mediante una variable el alumno seleccionado para poder selccionar el id de la foto
                val alumno = spinner.selectedItem as Alumno
                args.putInt(resources.getString(R.string.image), alumno.imageId)
                fragmento2.arguments=args
                //Le pasamos el id mediante argumentos para recogerlo en el fragment
                transaction.replace(R.id.frame, fragmento2)
                transaction.addToBackStack(null)
                transaction.commit()
            }
        }
    }
}