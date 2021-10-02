package com.example.app_03_conversortemperaturas

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtCelsius = findViewById<EditText>(R.id.txtCelsius)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)
        val btnConverter = findViewById<Button>(R.id.btnConverter)

        val dec = DecimalFormat("#,###.00") //2 casas decimais no final separado milhar "." e decimais ","

        btnConverter.setOnClickListener {
            if (txtCelsius.text.isEmpty()){
                txtCelsius.error = "Digite a temperatura em Celsius"
                txtResultado.text = "" //limpa o campo
            } else {
                //entrada de dados
                val celsius = txtCelsius.text.toString().toDouble() //pega o valor de txt e joga na variavel criada
                val resultado: Double

                //processamento
                resultado = (celsius * 9/5) + 32

                //saida
                txtResultado.text = "$celsius ºC equivalem a ${dec.format(resultado)} ºF"
                txtCelsius.text.clear() //limpa o campo
            }
        }

        val txtF = findViewById<EditText>(R.id.txtF)
        val txtResultadoF = findViewById<TextView>(R.id.txtResultadoF)
        val btnConverterF = findViewById<Button>(R.id.btnConverterF)

        val decF = DecimalFormat("##.00") //2 casas decimais no final separado milhar "." e decimais ","

        btnConverterF.setOnClickListener {
            if (txtF.text.isEmpty()){
                txtF.error = "Digite a temperatura em Fahrenheit"
                txtResultadoF.text = ""
            } else {
                val f = txtF.text.toString().toDouble()
                val resF: Double

                resF = (f - 32) * 5/9

                txtResultadoF.text = "$f ºF equivalem a ${decF.format(resF)} ºC"
                txtF.text.clear()
            }
        }
    }
}