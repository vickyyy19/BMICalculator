package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener() {
        calculate()
        }

        buttonReset.setOnClickListener() {
            reset()
        }
    }

     private fun calculate(){

            val result: String
            val weight = editTextWeight.text.toString().toDouble()
            val height = editTextHeight.text.toString().toDouble()

            val bmi = (weight / (height * height))

            if (bmi <= 18.5) {
                result = "Underweight"
                imageViewProfile.setImageResource(R.drawable.under)

            } else if (bmi > 18.5 && bmi <= 24.9) {
                result = "Normal"
                imageViewProfile.setImageResource(R.drawable.normal)

            } else {
                result = "Overweight"
                imageViewProfile.setImageResource(R.drawable.over)
            }

            textViewBMI.text = " %.2f (%s)".format(bmi,result)
      }


    fun reset(){
        editTextWeight.text.clear()
        editTextHeight.text.clear()
        textViewBMI.text = " "
        imageViewProfile.setImageResource(R.drawable.empty)
    }
}

