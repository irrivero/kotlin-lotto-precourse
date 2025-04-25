package lotto.domain

import lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningCheckerTest {
    @Test
    fun `check first rank`() {
        // Given
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val checker = WinningChecker(winningNumbers, bonusNumber)

        // When
        val rank = checker.checkRank(lotto)

        // Then
        assertThat(rank).isEqualTo(LottoRank.FIRST)
    }

    @Test
    fun `check second rank`() {
        // Given
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val checker = WinningChecker(winningNumbers, bonusNumber)

        // When
        val rank = checker.checkRank(lotto)

        // Then
        assertThat(rank).isEqualTo(LottoRank.SECOND)
    }

    @Test
    fun `check third rank`() {
        // Given
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 8))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val checker = WinningChecker(winningNumbers, bonusNumber)

        // When
        val rank = checker.checkRank(lotto)

        // Then
        assertThat(rank).isEqualTo(LottoRank.THIRD)
    }
}