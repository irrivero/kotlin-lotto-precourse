package lotto.view

import lotto.Lotto
import lotto.domain.LottoRank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputViewTest {
    private val outputView = OutputView()
    private val outputStream = ByteArrayOutputStream()
    private val originalOut = System.out

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStream))
    }

    @Test
    @DisplayName("Should correctly print purchased lottos")
    fun testPrintPurchasedLottos() {
        // given
        val lottos = listOf(
            createLotto(listOf(1, 2, 3, 4, 5, 6)),
            createLotto(listOf(7, 8, 9, 10, 11, 12))
        )

        // when
        outputView.printPurchasedLottos(lottos)
        val output = outputStream.toString()

        // then
        assertThat(output).contains("You have purchased 2 tickets")
        assertThat(output).contains("[1, 2, 3, 4, 5, 6]")
        assertThat(output).contains("[7, 8, 9, 10, 11, 12]")
    }

    @Test
    @DisplayName("Should correctly print winning statistics")
    fun testPrintWinningStatistics() {
        // given
        val results = mapOf(
            LottoRank.FIFTH to 1,
            LottoRank.FOURTH to 0,
            LottoRank.THIRD to 0,
            LottoRank.SECOND to 0,
            LottoRank.FIRST to 0
        )
        val totalCost = 8000

        // when
        outputView.printWinningStatistics(results, totalCost)
        val output = outputStream.toString()

        // then
        assertThat(output).contains("Winning Statistics")
        assertThat(output).contains("3 Matches (5,000 KRW) – 1 tickets")
        assertThat(output).contains("4 Matches (50,000 KRW) – 0 tickets")
        assertThat(output).contains("5 Matches (1,500,000 KRW) – 0 tickets")
        assertThat(output).contains("5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets")
        assertThat(output).contains("6 Matches (2,000,000,000 KRW) – 0 tickets")
        // 5,000 / 8,000 * 100 = 62.5%
        assertThat(output).contains("Total return rate is 62.5%")
    }

    @Test
    @DisplayName("Should format return rate with one decimal place")
    fun testReturnRateFormatting() {
        // given
        val results = mapOf(
            LottoRank.FIFTH to 2,
            LottoRank.FOURTH to 1
        )
        val totalCost = 5000

        // when
        outputView.printWinningStatistics(results, totalCost)
        val output = outputStream.toString()

        // then
        // (2 * 5,000 + 1 * 50,000) / 5,000 * 100 = 1200.0%
        assertThat(output).contains("Total return rate is 1200.0%")
    }

    @Test
    @DisplayName("Should handle zero matches")
    fun testNoWinnings() {
        // given
        val results = emptyMap<LottoRank, Int>()
        val totalCost = 5000

        // when
        outputView.printWinningStatistics(results, totalCost)
        val output = outputStream.toString()

        // then
        assertThat(output).contains("3 Matches (5,000 KRW) – 0 tickets")
        assertThat(output).contains("Total return rate is 0.0%")
    }

    private fun createLotto(numbers: List<Int>): Lotto {
        return Lotto(numbers)
    }

    @Test
    @DisplayName("Should restore System.out after test")
    fun tearDown() {
        System.setOut(originalOut)
    }
}