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
    fun testAddition_integers() {
        viewModel.updateNumber1("15")
        viewModel.updateNumber2("27")
        viewModel.add()

        assertEquals("Result: 42", viewModel.resultMessage)
    }

    @Test
    fun testAddition_decimals() {
        viewModel.updateNumber1("3.5")
        viewModel.updateNumber2("2.25")
        viewModel.add()

        assertEquals("Result: 5.75", viewModel.resultMessage)
    }

    @Test
    fun testSubtraction_positiveResult() {
        viewModel.updateNumber1("50")
        viewModel.updateNumber2("18")
        viewModel.subtract()

        assertEquals("Result: 32", viewModel.resultMessage)
    }

    @Test
    fun testSubtraction_negativeResult() {
        viewModel.updateNumber1("10")
        viewModel.updateNumber2("25")
        viewModel.subtract()

        assertEquals("Result: -15", viewModel.resultMessage)
    }

    @Test
    fun testMultiplication() {
        viewModel.updateNumber1("7")
        viewModel.updateNumber2("8")
        viewModel.multiply()

        assertEquals("Result: 56", viewModel.resultMessage)
    }

    @Test
    fun testDivision_wholeNumber() {
        viewModel.updateNumber1("100")
        viewModel.updateNumber2("4")
        viewModel.divide()

        assertEquals("Result: 25", viewModel.resultMessage)
    }

    @Test
    fun testDivision_fractionalResult() {
        viewModel.updateNumber1("5")
        viewModel.updateNumber2("2")
        viewModel.divide()

        assertEquals("Result: 2.5", viewModel.resultMessage)
    }

    @Test
    fun testDivisionByZero_returnsErrorMessage() {
        viewModel.updateNumber1("10")
        viewModel.updateNumber2("0")
        viewModel.divide()

        assertEquals("Error: Division by zero", viewModel.resultMessage)
    }

    @Test
    fun testInvalidInput_number1NotANumber() {
        viewModel.updateNumber1("abc")
        viewModel.updateNumber2("10")
        viewModel.add()

        assertEquals("Error: Please enter valid numbers.", viewModel.resultMessage)
    }

    @Test
    fun testInvalidInput_emptyNumber2() {
        viewModel.updateNumber1("10")
        viewModel.updateNumber2("")
        viewModel.multiply()

        assertEquals("Error: Please enter valid numbers.", viewModel.resultMessage)
    }

    @Test
    fun testClearAll_resetsState() {
        viewModel.updateNumber1("100")
        viewModel.updateNumber2("50")
        viewModel.add()
        assertEquals("Result: 150", viewModel.resultMessage)

        viewModel.clearAll()
        assertEquals("", viewModel.number1)
        assertEquals("", viewModel.number2)
        assertEquals("", viewModel.resultMessage)
    }

    @Test
    fun testUpdateNumber_clearsPreviousResult() {
        viewModel.updateNumber1("10")
        viewModel.updateNumber2("20")
        viewModel.add()
        assertTrue(viewModel.resultMessage.isNotEmpty())

        viewModel.updateNumber1("15")
        assertEquals("", viewModel.resultMessage)
    }
}
