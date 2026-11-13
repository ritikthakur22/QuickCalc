package com.example.quickcalc

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class MainViewModelTest {

    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        viewModel = MainViewModel()
    }

    @Test
    fun testDigitInputAndLivePreview() {
        viewModel.onDigit("1")
        viewModel.onDigit("2")
        viewModel.onDigit("5")

        assertEquals("125", viewModel.expression)
        assertEquals("125", viewModel.resultPreview)
    }

    @Test
    fun testOrderOfOperations_multiplicationBeforeAddition() {
        // 2 + 3 × 4 = 14 (not 20)
        viewModel.onDigit("2")
        viewModel.onOperator("+")
        viewModel.onDigit("3")
        viewModel.onOperator("×")
        viewModel.onDigit("4")

        assertEquals("2+3×4", viewModel.expression)
        assertEquals("14", viewModel.resultPreview)

        viewModel.onEquals()
        assertEquals("14", viewModel.expression)
        assertEquals("", viewModel.resultPreview)
    }

    @Test
    fun testDecimalInput_preventsDuplicateDots() {
        viewModel.onDecimal() // starts with 0.
        viewModel.onDigit("5")
        viewModel.onDecimal() // second dot should be ignored

        assertEquals("0.5", viewModel.expression)
        assertEquals("0.5", viewModel.resultPreview)
    }

    @Test
    fun testDivisionByZero_showsErrorMessage() {
        viewModel.onDigit("1")
        viewModel.onDigit("0")
        viewModel.onOperator("÷")
        viewModel.onDigit("0")

        assertEquals("10÷0", viewModel.expression)
        assertEquals("Cannot divide by zero", viewModel.resultPreview)
        assertTrue(viewModel.isError)
    }

    @Test
    fun testParenthesesEvaluation() {
        // (2 + 3) × 4 = 20
        viewModel.onParentheses() // opens (
        viewModel.onDigit("2")
        viewModel.onOperator("+")
        viewModel.onDigit("3")
        viewModel.onParentheses() // closes )
        viewModel.onOperator("×")
        viewModel.onDigit("4")

        assertEquals("(2+3)×4", viewModel.expression)
        assertEquals("20", viewModel.resultPreview)

        viewModel.onEquals()
        assertEquals("20", viewModel.expression)
    }

    @Test
    fun testOperatorReplacement() {
        viewModel.onDigit("5")
        viewModel.onOperator("+")
        assertEquals("5+", viewModel.expression)

        // User changes mind and taps ×
        viewModel.onOperator("×")
        assertEquals("5×", viewModel.expression)
    }

    @Test
    fun testDeleteAndClear() {
        viewModel.onDigit("1")
        viewModel.onDigit("2")
        viewModel.onDigit("3")
        assertEquals("123", viewModel.expression)

        viewModel.onDelete()
        assertEquals("12", viewModel.expression)

        viewModel.clearAll()
        assertEquals("", viewModel.expression)
        assertEquals("", viewModel.resultPreview)
    }

    @Test
    fun testPercentage() {
        viewModel.onDigit("2")
        viewModel.onDigit("5")
        viewModel.onDigit("0")
        viewModel.onPercentage()

        assertEquals("2.5", viewModel.expression)
    }
}
