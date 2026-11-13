package com.example.quickcalc

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MainViewModelTest {

    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        viewModel = MainViewModel()
    }

    @Test
    fun testBasicArithmeticOperations() {
        // Addition
        viewModel.updateNumber1("12")
        viewModel.updateNumber2("8")
        viewModel.add()
        assertEquals("Result: 20", viewModel.resultMessage)

        // Subtraction
        viewModel.updateNumber1("25")
        viewModel.updateNumber2("10")
        viewModel.subtract()
        assertEquals("Result: 15", viewModel.resultMessage)

        // Multiplication
        viewModel.updateNumber1("6")
        viewModel.updateNumber2("7")
        viewModel.multiply()
        assertEquals("Result: 42", viewModel.resultMessage)

        // Division
        viewModel.updateNumber1("100")
        viewModel.updateNumber2("4")
        viewModel.divide()
        assertEquals("Result: 25", viewModel.resultMessage)
    }

    @Test
    fun testDecimalHandling() {
        viewModel.updateNumber1("3.5")
        viewModel.updateNumber2("2.25")
        viewModel.add()
        assertEquals("Result: 5.75", viewModel.resultMessage)

        viewModel.updateNumber1("5")
        viewModel.updateNumber2("2")
        viewModel.divide()
        assertEquals("Result: 2.5", viewModel.resultMessage)
    }

    @Test
    fun testDivisionByZero() {
        viewModel.updateNumber1("10")
        viewModel.updateNumber2("0")
        viewModel.divide()
        assertEquals("Error: Division by zero", viewModel.resultMessage)
    }

    @Test
    fun testInputValidation() {
        viewModel.updateNumber1("abc")
        viewModel.updateNumber2("5")
        viewModel.add()
        assertEquals("Error: Please enter valid numbers.", viewModel.resultMessage)

        viewModel.updateNumber1("10")
        viewModel.updateNumber2("")
        viewModel.multiply()
        assertEquals("Error: Please enter valid numbers.", viewModel.resultMessage)
    }

    @Test
    fun testClearAllAndReset() {
        viewModel.updateNumber1("50")
        viewModel.updateNumber2("20")
        viewModel.add()
        assertEquals("Result: 70", viewModel.resultMessage)

        viewModel.clearAll()
        assertEquals("", viewModel.number1)
        assertEquals("", viewModel.number2)
        assertEquals("", viewModel.resultMessage)
    }
}
