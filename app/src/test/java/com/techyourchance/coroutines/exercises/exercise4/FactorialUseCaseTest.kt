package com.techyourchance.coroutines.exercises.exercise4

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.math.BigInteger

@OptIn(ExperimentalCoroutinesApi::class)
class FactorialUseCaseTest {

    private lateinit var SUT: FactorialUseCase

    companion object {
        private const val TIMEOUT = 1000
    }

    @Before
    fun setup() {
        SUT = FactorialUseCase()
    }

    @Test
    fun computeFactorial_0_returns1() = runTest {
        // Arrange
        // Act
        val result = SUT.computeFactorial(0, TIMEOUT)
        // Assert
        assertThat((result as FactorialUseCase.Result.Success).result, `is`(BigInteger("1")))
    }

    @Test
    fun computeFactorial_1_returns1() = runTest {
        // Arrange
        // Act
        val result = SUT.computeFactorial(1, TIMEOUT)
        // Assert
        assertThat((result as FactorialUseCase.Result.Success).result, `is`(BigInteger("1")))
    }

    @Test
    fun computeFactorial_10_returnsCorrectAnswer() = runTest {
        // Arrange
        // Act
        val result = SUT.computeFactorial(10, TIMEOUT)
        // Assert
        assertThat((result as FactorialUseCase.Result.Success).result, `is`(BigInteger("3628800")))
    }

    @Test
    fun computeFactorial_30_returnsCorrectAnswer() = runTest {
        // Arrange
        // Act
        val result = SUT.computeFactorial(30, TIMEOUT)
        // Assert
        assertThat((result as FactorialUseCase.Result.Success).result, `is`(BigInteger("265252859812191058636308480000000")))
    }
}