package com.dzakyhdr.practiceviewmodel

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import java.lang.NumberFormatException
import kotlin.jvm.Throws

class MainViewModelTest {

    private lateinit var viewModel: MainViewModel

    @get:Rule
    var thrown = ExpectedException.none()

    @Before
    fun init() {
        viewModel = MainViewModel()
    }

    @Test
    fun calculate(){
        val height = "1"
        val width = "2"
        val length = "3"
        viewModel.calculate(width, height, length)
        assertEquals(6, viewModel.result)
    }

    @Test
    @Throws(NumberFormatException::class)
    fun calculateDouble(){
        val height = "1"
        val width = "2.4"
        val length = "3"
        thrown.expect(NumberFormatException::class.java)
        thrown.expectMessage("For input string: \"2.4\"")
        viewModel.calculate(width, height, length)
    }

    @Test
    @Throws(java.lang.NumberFormatException::class)
    fun characterInputCalculateTest() {
        val width = "1"
        val length = "A"
        val height = "3"
        thrown.expect(java.lang.NumberFormatException::class.java)
        thrown.expectMessage("For input string: \"A\"")
        viewModel.calculate(width, length, height)
    }


    @Test
    @Throws(java.lang.NumberFormatException::class)
    fun emptyInputCalculateTest() {
        val width = "1"
        val length = ""
        val height = "3"
        thrown.expect(java.lang.NumberFormatException::class.java)
        thrown.expectMessage("For input string: \"\"")
        viewModel.calculate(width, height, length)
    }
}