package mx.edu.itson.practica4_247037_imc

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val peso = findViewById<android.widget.EditText>(R.id.etPeso)
        val estatura = findViewById<android.widget.EditText>(R.id.etEstatura)
        val calcular = findViewById<android.widget.Button>(R.id.btnCalcular)
        val resultado = findViewById<android.widget.TextView>(R.id.textViewResultado)
        calcular.setOnClickListener{
            val pesoStr = peso.text.toString()
            val estaturaStr = estatura.text.toString()
            if(pesoStr.isNotEmpty() && estaturaStr.isNotEmpty()){
                if (pesoStr.toFloat() <= 0 || estaturaStr.toFloat() <= 0){
                    resultado.text = "Datos incorrectos"
                    return@setOnClickListener
                }
                val peso = pesoStr.toFloat()
                val estatura = estaturaStr.toFloat()
                val imc = peso / (estatura * estatura)
                resultado.text = "$imc"
            }

        }
    }
}