package com.cavalist.inbodycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textInputBodyWeight = findViewById<TextInputEditText>(R.id.textInputEditTextBodyWeight)
        val textInputFatRatio = findViewById<TextInputEditText>(R.id.textInputEditTextFatRatio)
        val textInputMuscleRatio = findViewById<TextInputEditText>(R.id.textInputEditTextMuscleRatio)
        val textViewResult = findViewById<TextView>(R.id.textView10)

        val buttonClear = findViewById<Button>(R.id.buttonClear)
        val buttonCalculater = findViewById<Button>(R.id.buttonCalculate)

        buttonCalculater.setOnClickListener{
            val bodyWeight = textInputBodyWeight.text.toString().toDouble()
            val bodyFatRatio = textInputFatRatio.text.toString().toDouble()
            val bodyMuscleRatio = textInputMuscleRatio.text.toString().toDouble()

            val fatWeight = String.format("%.2f", bodyWeight * bodyFatRatio / 100)
            val muscleWeight = String.format("%.2f", bodyWeight * bodyMuscleRatio / 100)

            val resultString = """
                체지방량: ${fatWeight} kg
                골격근량: ${muscleWeight} kg
            """.trimIndent()

            textViewResult.text = resultString
        }

        buttonClear.setOnClickListener{
            textViewResult.text = ""
        }

    }
}