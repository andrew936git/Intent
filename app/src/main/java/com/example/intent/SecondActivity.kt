package com.example.intent

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var firstOperand: EditText
    private lateinit var secondOperand: EditText

    private lateinit var resultTV: TextView

    private lateinit var plusButton: Button
    private lateinit var minusButton: Button
    private lateinit var multButton: Button
    private lateinit var divButton: Button
    private lateinit var getDataButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        init()
    }

    private fun init() {
        firstOperand = findViewById(R.id.firstOperand)
        secondOperand = findViewById(R.id.secondOperand)

        resultTV = findViewById(R.id.resultTV)

        plusButton = findViewById(R.id.plusButton)
        minusButton = findViewById(R.id.minusButton)
        multButton = findViewById(R.id.multButton)
        divButton = findViewById(R.id.divButton)
        getDataButton = findViewById(R.id.getDataButton)

        plusButton.setOnClickListener(this)
        minusButton.setOnClickListener(this)
        multButton.setOnClickListener(this)
        divButton.setOnClickListener(this)
        getDataButton.setOnClickListener {
            if(resultTV.text.isEmpty())return@setOnClickListener
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("key", resultTV.text.toString())
            startActivity(intent)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        val check = true
        if (firstOperand.text.isEmpty() || secondOperand.text.isEmpty()) return
        val first = firstOperand.getText().toString()
        val second = secondOperand.getText().toString()
        val result = when (v?.id) {
            R.id.plusButton -> Calculation(first, second).sum()
            R.id.minusButton -> Calculation(first, second).minus()
            R.id.multButton -> Calculation(first, second).mult()
            R.id.divButton -> Calculation(first, second).div()

            else -> "0"
        }

        if (!check) resultTV.text = "Результат" else resultTV.text = result

    }
}