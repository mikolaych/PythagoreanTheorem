package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        calc()
    }

    fun calc() {
        binding.apply {
            start.setOnClickListener {
                if (!horizontalCatet.text.isNullOrBlank() && !verticalCatet.text.isNullOrBlank() && !hipotenuza.text.isNullOrBlank()) info.text =
                    "Все поля заполнены!"
                else if (horizontalCatet.text.isNullOrBlank() && verticalCatet.text.isNullOrBlank() && hipotenuza.text.isNullOrBlank()) info.text =
                    "Поля пусты!"
                else {
                    when {
                        hipotenuza.text.isNullOrBlank() -> {
                            if (horizontalCatet.text.isNullOrBlank() || verticalCatet.text.isNullOrBlank()) info.text =
                                "Заполните еще одно поле!"
                            else {
                                var result = sqrt(
                                    verticalCatet.text.toString().toDouble().pow(2.0) +
                                            horizontalCatet.text.toString().toDouble().pow(2.0)
                                )

                                hipotenuza.hint = (((result * 10.0).roundToInt() / 10.0).toString())
                                verticalCatet.hint = verticalCatet.text
                                horizontalCatet.hint = horizontalCatet.text
                                verticalCatet.text = null
                                horizontalCatet.text = null
                                info.text = null
                            }
                        }
                        verticalCatet.text.isNullOrBlank() -> {
                            if (horizontalCatet.text.isNullOrBlank()) info.text =
                                "Введите значение одного из катетов"
                            else if (horizontalCatet.text.toString()
                                    .toDouble() > hipotenuza.text.toString().toDouble()
                            ) info.text = "Катет больше гипотенузы!"
                            else {
                                var result = sqrt(
                                    hipotenuza.text.toString().toDouble().pow(2.0) -
                                            horizontalCatet.text.toString().toDouble().pow(2.0)
                                )

                                verticalCatet.hint =
                                    (((result * 10.0).roundToInt() / 10.0).toString())
                                horizontalCatet.hint = horizontalCatet.text
                                hipotenuza.hint = hipotenuza.text
                                hipotenuza.text = null
                                horizontalCatet.text = null
                                info.text = null

                            }
                        }
                        horizontalCatet.text.isNullOrBlank() -> {
                            if (verticalCatet.text.toString()
                                    .toDouble() > hipotenuza.text.toString().toDouble()
                            ) info.text = "Катет больше гипотенузы!"
                            else {
                                var result = sqrt(
                                    hipotenuza.text.toString().toDouble().pow(2.0) -
                                            verticalCatet.text.toString().toDouble().pow(2.0)
                                )

                                horizontalCatet.hint =
                                    ((result * 10.0).roundToInt() / 10.0).toString()
                                hipotenuza.hint = hipotenuza.text
                                verticalCatet.hint = verticalCatet.text
                                hipotenuza.text = null
                                verticalCatet.text = null
                                info.text = null
                            }
                        }
                    }
                }


            }

        }


    }
}