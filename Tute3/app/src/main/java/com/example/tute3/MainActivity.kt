package com.example.tute3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import models.Calculator


class MainActivity : AppCompatActivity() {


    lateinit var no1: EditText
    lateinit var no2:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        no1 = findViewById(R.id.no1)
        no2 = findViewById(R.id.no2)

    }

    fun buttonClick(v: View){
        var ans = 0.0
        val calculator = Calculator(
            no1.text.toString().toDouble(),
            no2.text.toString().toDouble())
            when(v.id){
                R.id.btnPlus -> ans = calculator.add()
                R.id.btnMinus -> ans = calculator.subtract()
                R.id.btnMultiply -> ans = calculator.multiply()
                R.id.btnDivide -> ans = calculator.divide()
            }
        println(ans)//this will print the output on the terminal

        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("answer", ans)
        startActivity(intent)
        finish()

        var txtAnswer = findViewById<TextView>(R.id.txtAnswer)

        txtAnswer.setText(intent.getDoubleExtra("answer",0.0).toString())
        var btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        }


}
