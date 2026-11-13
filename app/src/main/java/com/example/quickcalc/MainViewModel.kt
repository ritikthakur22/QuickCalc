package com.example.quickcalc

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var number1 by mutableStateOf("")
        private set

    var number2 by mutableStateOf("")
        private set

    var resultMessage by mutableStateOf("")
        private set

    fun updateNumber1(value: String) {
        number1 = value
        clearResult()
    }

    fun updateNumber2(value: String) {
        number2 = value
        clearResult()
    }

    private fun clearResult() {
        resultMessage = ""
    }

    fun clearAll() {
        number1 = ""
        number2 = ""
        resultMessage = ""
    }

    fun add() = calculate { a, b -> a + b }

    fun subtract() = calculate { a, b -> a - b }

    fun multiply() = calculate { a, b -> a * b }

    fun divide() {
        val num1 = number1.toDoubleOrNull()
        val num2 = number2.toDoubleOrNull()

        if (num1 == null || num2 == null) {
            resultMessage = "Error: Please enter valid numbers."
            return
        }

        if (num2 == 0.0) {
            resultMessage = "Error: Division by zero"
            return
        }

        setResult(num1 / num2)
    }

    private fun calculate(operation: (Double, Double) -> Double) {
        val num1 = number1.toDoubleOrNull()
        val num2 = number2.toDoubleOrNull()

        if (num1 == null || num2 == null) {
            resultMessage = "Error: Please enter valid numbers."
            return
        }

        setResult(operation(num1, num2))
    }

    private fun setResult(value: Double) {
        resultMessage = if (value % 1.0 == 0.0) {
            "Result: ${value.toLong()}"
        } else {
            "Result: $value"
        }
    }
}
