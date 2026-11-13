package com.example.quickcalc

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var expression by mutableStateOf("")
        private set

    var resultPreview by mutableStateOf("")
        private set

    var isError by mutableStateOf(false)
        private set

    fun onDigit(digit: String) {
        if (isError) clearAll()

        expression += digit
        updateLivePreview()
    }

    fun onDecimal() {
        if (isError) clearAll()

        if (expression.isEmpty() || isLastCharOperator()) {
            expression += "0."
        } else {
            // Find current number segment
            val currentNumber = expression.takeLastWhile { it.isDigit() || it == '.' }
            if (!currentNumber.contains('.')) {
                expression += "."
            }
        }
        updateLivePreview()
    }

    fun onOperator(op: String) {
        if (isError) isError = false

        if (expression.isEmpty()) {
            if (op == "−") {
                expression = "−"
            }
            return
        }

        if (isLastCharOperator()) {
            // Replace the last operator with the new one
            expression = expression.dropLast(1) + op
        } else {
            expression += op
        }
        updateLivePreview()
    }

    fun onPercentage() {
        if (expression.isEmpty() || isLastCharOperator()) return

        try {
            val evaluated = ExpressionEvaluator.evaluate(expression)
            val percentResult = evaluated / 100.0
            expression = formatNumber(percentResult)
            resultPreview = ""
        } catch (e: Exception) {
            resultPreview = "Error"
            isError = true
        }
    }

    fun onParentheses() {
        if (isError) clearAll()

        val openCount = expression.count { it == '(' }
        val closeCount = expression.count { it == ')' }

        val lastChar = expression.lastOrNull()
        if (openCount > closeCount && lastChar != null && (lastChar.isDigit() || lastChar == ')')) {
            expression += ")"
        } else {
            if (lastChar != null && (lastChar.isDigit() || lastChar == ')')) {
                expression += "×("
            } else {
                expression += "("
            }
        }
        updateLivePreview()
    }

    fun onDelete() {
        if (isError) {
            clearAll()
            return
        }

        if (expression.isNotEmpty()) {
            expression = expression.dropLast(1)
            updateLivePreview()
        }
    }

    fun clearAll() {
        expression = ""
        resultPreview = ""
        isError = false
    }

    fun onEquals() {
        if (expression.isEmpty()) return

        try {
            val result = ExpressionEvaluator.evaluate(expression)
            val formatted = formatNumber(result)
            expression = formatted
            resultPreview = ""
            isError = false
        } catch (e: ArithmeticException) {
            resultPreview = "Cannot divide by zero"
            isError = true
        } catch (e: Exception) {
            resultPreview = "Error"
            isError = true
        }
    }

    private fun updateLivePreview() {
        if (expression.isEmpty() || isLastCharOperator()) {
            resultPreview = ""
            return
        }

        try {
            val result = ExpressionEvaluator.evaluate(expression)
            resultPreview = formatNumber(result)
            isError = false
        } catch (e: ArithmeticException) {
            resultPreview = "Cannot divide by zero"
            isError = true
        } catch (e: Exception) {
            resultPreview = ""
        }
    }

    private fun isLastCharOperator(): Boolean {
        val last = expression.lastOrNull() ?: return false
        return last == '+' || last == '−' || last == '×' || last == '÷'
    }

    private fun formatNumber(value: Double): String {
        return if (value % 1.0 == 0.0) {
            value.toLong().toString()
        } else {
            // Trim precision to at most 8 decimal places without trailing zeroes
            val formatted = String.format(java.util.Locale.US, "%.8f", value)
            formatted.trimEnd('0').trimEnd('.')
        }
    }
}
