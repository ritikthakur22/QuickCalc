package com.example.quickcalc

object ExpressionEvaluator {

    fun evaluate(expression: String): Double {
        val sanitized = expression
            .replace("×", "*")
            .replace("÷", "/")
            .replace("−", "-")
            .replace(" ", "")

        if (sanitized.isEmpty()) return 0.0

        val parser = Parser(sanitized)
        return parser.parse()
    }

    private class Parser(private val input: String) {
        private var pos = 0

        private fun peek(): Char? = if (pos < input.length) input[pos] else null
        private fun consume(): Char = input[pos++]

        fun parse(): Double {
            val result = parseExpression()
            return result
        }

        // expr = term (( '+' | '-' ) term)*
        private fun parseExpression(): Double {
            var value = parseTerm()
            while (true) {
                when (peek()) {
                    '+' -> {
                        consume()
                        value += parseTerm()
                    }
                    '-' -> {
                        consume()
                        value -= parseTerm()
                    }
                    else -> return value
                }
            }
        }

        // term = factor (( '*' | '/' | '%' ) factor)*
        private fun parseTerm(): Double {
            var value = parseFactor()
            while (true) {
                when (peek()) {
                    '*' -> {
                        consume()
                        value *= parseFactor()
                    }
                    '/' -> {
                        consume()
                        val divisor = parseFactor()
                        if (divisor == 0.0) throw ArithmeticException("Cannot divide by zero")
                        value /= divisor
                    }
                    '%' -> {
                        consume()
                        val divisor = parseFactor()
                        if (divisor == 0.0) throw ArithmeticException("Cannot divide by zero")
                        value %= divisor
                    }
                    else -> return value
                }
            }
        }

        // factor = [ '+' | '-' ] ( '(' expr ')' | number )
        private fun parseFactor(): Double {
            if (peek() == '+') {
                consume()
                return parseFactor()
            }
            if (peek() == '-') {
                consume()
                return -parseFactor()
            }
            if (peek() == '(') {
                consume()
                val inner = parseExpression()
                if (peek() == ')') {
                    consume()
                }
                return inner
            }

            val start = pos
            while (peek()?.let { it.isDigit() || it == '.' } == true) {
                consume()
            }
            if (start == pos) {
                return 0.0
            }
            val numStr = input.substring(start, pos)
            return numStr.toDoubleOrNull() ?: 0.0
        }
    }
}
