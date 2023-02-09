package com.example.binarytodec

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val binaryToDec = Binary()
    private var codeBinaryToDec: String = ""
    private var flag: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numberOfOne = findViewById<Button>(R.id.numberOne)
        val numberOfOZero = findViewById<Button>(R.id.numberZero)
        val coma = findViewById<Button>(R.id.coma)
        val resultBinaryToDec = findViewById<Button>(R.id.resultBinaryToDec)
        val clearText = findViewById<Button>(R.id.clearText)
        val resultNumber = findViewById<TextView>(R.id.resultNumber)

        numberOfOne.setOnClickListener {
            codeBinaryToDec += "1"
            resultNumber.text = codeBinaryToDec
        }
        numberOfOZero.setOnClickListener {
            codeBinaryToDec += "0"
            resultNumber.text = codeBinaryToDec
        }
        coma.setOnClickListener {
            if (flag == 0) {
                codeBinaryToDec += ","
                resultNumber.text = codeBinaryToDec
                flag++
            }
        }
        resultBinaryToDec.setOnClickListener {
            resultNumber.text = binaryToDec.resultConvertedBinaryCodeToDec(codeBinaryToDec)
            flag = 0
            codeBinaryToDec = ""
        }
        clearText.setOnClickListener {
            if (codeBinaryToDec.isNotEmpty()) {
                if (codeBinaryToDec.last() == ',') {
                    flag = 0
                }
                codeBinaryToDec = codeBinaryToDec.dropLast(1)
                resultNumber.text = codeBinaryToDec
            }
        }
    }
}