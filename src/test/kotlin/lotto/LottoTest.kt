package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy

class LottoTest {
    @Test
    fun `throws an exception when lotto numbers exceed six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `create lotto with valid numbers`() {
        // When
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        // Then
        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun `create lotto with invalid size`() {
        assertThatThrownBy { Lotto(listOf(1, 2, 3, 4, 5)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR] Lotto must contain exactly 6 numbers.")
    }

    @Test
    fun `create lotto with numbers out of range`() {
        assertThatThrownBy { Lotto(listOf(1, 2, 3, 4, 5, 46)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR] Lotto numbers must be between 1 and 45.")
    }

    @Test
    fun `count matches correctly`() {
        // Given
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 7, 8, 9)

        // When
        val matchCount = lotto.matches(winningNumbers)

        // Then
        assertThat(matchCount).isEqualTo(3)
    }

    @Test
    fun `check if contains number`() {
        // Given
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        // When & Then
        assertThat(lotto.containsNumber(1)).isTrue()
        assertThat(lotto.containsNumber(7)).isFalse()
    }

}
