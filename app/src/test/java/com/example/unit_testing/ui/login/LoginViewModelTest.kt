package com.example.unit_testing.ui.login

import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test


class LoginViewModelTest {
    val viewModel = LoginViewModel()

    @Before
    fun setup() {
        val testDispatcher = UnconfinedTestDispatcher()
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun cleanup() {
        Dispatchers.resetMain()
    }

    @Test
    fun `greet function should return a valid greeting message`() = runTest {
        viewModel.greet("Adrian")

        viewModel.greetings.collect {
            if (it != "") {
                assertEquals("Hello Adrian", it)
            }
        }
    }


    @Test
    fun `email aaa should return an error message`() {
        assert(viewModel.validateEmail("aaa") == null)
    }

    @Test
    fun `email aaa gmail com should return null`() {
        assert(viewModel.validateEmail("aaa@gmail.com") == null)
    }
}