package lotto.view

import camp.nextstep.edu.missionutils.Console
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.io.ByteArrayInputStream
import java.io.InputStream

class InputViewTest {
    private val inputView = InputView()
    private val standardIn: InputStream = System.`in`

    @BeforeEach
    fun setUp() {
        Console.close()
    }

    @AfterEach
    fun tearDown() {
        System.setIn(standardIn)
        Console.close()
    }

    private fun setInput(input: String) {
        val inputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)
    }

    @DisplayName("Should accept valid purchase amount")
    @Test
    fun testReadValidPurchaseAmount() {
        // given
        setInput("8000")

        // when
        val amount = inputView.readPurchaseAmount()

        // then
        assertThat(amount).isEqualTo(8000)
    }

    @DisplayName("Should throw exception when purchase amount is not divisible by 1000")
    @ParameterizedTest
    @ValueSource(strings = ["1500", "2400", "999"])
    fun testReadInvalidPurchaseAmount(invalidAmount: String) {
        // given
        setInput(invalidAmount)

        // then
        assertThatThrownBy { inputView.readPurchaseAmount() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
            .hasMessageContaining("divisible by 1,000")
    }

    @DisplayName("Should throw exception when purchase amount is negative")
    @Test
    fun testReadNegativePurchaseAmount() {
        // given
        setInput("-1000")

        // then
        assertThatThrownBy { inputView.readPurchaseAmount() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
            .hasMessageContaining("must be non-negative")
    }

    @DisplayName("Should accept valid winning numbers")
    @Test
    fun testReadValidWinningNumbers() {
        // given
        setInput("1,2,3,4,5,6")

        // when
        val winningNumbers = inputView.readWinningNumbers()

        // then
        assertThat(winningNumbers).containsExactly(1, 2, 3, 4, 5, 6)
    }

    @DisplayName("Should throw exception when winning numbers are invalid")
    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5", "1,2,3,4,5,6,7", "1,2,3,4,5,90", "1,2,3,2,4,5"])
    fun testReadInvalidWinningNumbers(invalidNumbers: String) {
        // given
        setInput(invalidNumbers)

        // then
        assertThatThrownBy { inputView.readWinningNumbers() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @DisplayName("Should accept valid bonus number")
    @Test
    fun testReadValidBonusNumber() {
        // given
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        setInput("7")

        // when
        val bonusNumber = inputView.readBonusNumber(winningNumbers)

        // then
        assertThat(bonusNumber).isEqualTo(7)
    }

    @DisplayName("Should throw exception when bonus number is in winning numbers")
    @Test
    fun testReadBonusNumberInWinningNumbers() {
        // given
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        setInput("3")

        // then
        assertThatThrownBy { inputView.readBonusNumber(winningNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
            .hasMessageContaining("must not be in winning numbers")
    }

    @DisplayName("Should throw exception when bonus number is out of range")
    @ParameterizedTest
    @ValueSource(strings = ["0", "46", "100", "-1"])
    fun testReadInvalidBonusNumber(invalidBonus: String) {
        // given
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        setInput(invalidBonus)

        // then
        assertThatThrownBy { inputView.readBonusNumber(winningNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
            .hasMessageContaining("must be between 1 and 45")
    }
}