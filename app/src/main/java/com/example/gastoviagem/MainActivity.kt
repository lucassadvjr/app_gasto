package com.example.gastoviagem

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var dist: EditText
    private lateinit var price: EditText
    private lateinit var auto: EditText
    private lateinit var total: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        dist = findViewById(R.id.edit_dist)
        price = findViewById(R.id.edit_price)
        auto = findViewById(R.id.edit_autonomia)
        total = findViewById(R.id.view_total)

        val btnCalc: Button = findViewById(R.id.btn_calcular)
        btnCalc.setOnClickListener {
            calcular()
        }
    }

    private fun calcular() {
        val distValue = dist.text.toString().toFloatOrNull() ?: 0f
        val priceValue = price.text.toString().toFloatOrNull() ?: 0f
        val autoValue = auto.text.toString().toFloatOrNull() ?: 0f

        val result = (distValue / autoValue) * priceValue
        val formattedResult = String.format("%.2f", result)
        total.text = formattedResult
    }
}
