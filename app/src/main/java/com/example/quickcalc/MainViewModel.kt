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

    fun add() {
        calculate { a, b -> a + b }
    }

    fun subtract() {
        calculate { a, b -> a - b }
    }

    fun multiply() {
        calculate { a, b -> a * b }
    }

    fun divide() {
        calculate { a, b ->
            if (b == 0.0) throw ArithmeticException("Division by zero")
            a / b
        }
    }

    private fun calculate(operation: (Double, Double) -> Double) {
        val num1 = number1.toDoubleOrNull()
        val num2 = number2.toDoubleOrNull()

        if (num1 == null || num2 == null) {
            resultMessage = "Error: Please enter valid numbers."
            return
        }

        try {
            val result = operation(num1, num2)
            resultMessage = if (result % 1.0 == 0.0) {
                "Result: ${result.toLong()}"
            } else {
                "Result: $result"
            }
        } catch (e: ArithmeticException) {
            resultMessage = "Error: ${e.message}"
        } catch (e: Exception) {
            resultMessage = "Error: Invalid operation."
        }
    }
}
