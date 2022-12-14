package demo.common

import demo.common.util.Calculator
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test


class CalculatorTest {
    private val calculator = Calculator()
    private val calculatorMock: Calculator = mockk()

    @Test
    fun `Calculator - add`() {
        assertThat(calculator.add(1, 2)).isEqualTo(3)
    }

    @Test
    fun `Calculator - add mock`() {
        every {
            calculatorMock.add(any(), any())
        } returns 10

        assertThat(calculatorMock.add(1, 2)).isEqualTo(10)

        verify {
            calculatorMock.add(1, 2)
        }
    }

    @Test
    @Disabled
    fun `failure`() {
        assertThat(true).isFalse
    }
}
