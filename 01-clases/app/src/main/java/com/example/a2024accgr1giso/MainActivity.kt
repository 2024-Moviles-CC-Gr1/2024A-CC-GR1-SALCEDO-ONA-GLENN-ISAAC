package com.example.a2024accgr1giso

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val botonACicloVida = findViewById<Button>(R.id.btn_ciclo_vida)
        botonACicloVida
            .setOnClickListener {
                irActividad(ACicloVida::class.java)
            }
        val botonBListView = findViewById<Button>(R.id.btn_ir_list_view)
        botonBListView
            .setOnClickListener {
                irActividad(BListView::class.java)
            }
    }

    fun irActividad(
        clase: Class<*>
    ){
        val intent = Intent(this, clase)
        startActivity(intent)
    }
}