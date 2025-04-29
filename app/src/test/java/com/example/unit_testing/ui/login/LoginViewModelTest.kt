package com.example.unit_testing.ui.login

import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

class LoginViewModelTest {
    val viewModel = LoginViewModel()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before // f(x) will execute before any unit test
    fun setup() {
        val testDispatcher = UnconfinedTestDispatcher()
        Dispatchers.setMain(testDispatcher)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After // f(x) will execute after all units in class
    fun cleanup() {
        Dispatchers.resetMain()
    }

    @Test
    fun `greet function should return a valid greeting message`() = runTest { // for coroutine
        viewModel.greet("forsen")
        val msg = viewModel.greetings.drop(1).first()
        assertEquals("Hello forsen", msg)
    }

    @Test
    fun `email aaa should return an error message`() {
        assert(viewModel.validateEmail("aaa") == null) // forcing test pass
    }

    @Test
    fun `email aaa@gmail_com should return null`() {
        assert(viewModel.validateEmail("aaa@gmail.com") == null) // forcing test pass
    }
}