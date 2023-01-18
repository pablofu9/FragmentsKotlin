package com.example.practica17.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.practica17.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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

    }
}