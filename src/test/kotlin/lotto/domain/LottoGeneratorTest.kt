package lotto.domain

import lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoGeneratorTest {

    @DisplayName("Should generate correct number of lottery tickets")
    @ParameterizedTest
    @ValueSource(ints = [1, 5, 10, 20])
    fun testGeneratesCorrectNumberOfLottos(count: Int) {
        // given
        val lottoGenerator = LottoGenerator()

        // when
        val lottos = lottoGenerator.generate(count)

        // then
        assertThat(lottos).hasSize(count)
    }

    @DisplayName("Should generate valid lottery tickets")
    @Test
    fun testGeneratesValidLottos() {
        // given
        val lottoGenerator = LottoGenerator()
        val count = 10

        // when
        val lottos = lottoGenerator.generate(count)

        // then
        lottos.forEach { lotto ->
            val numbers = lotto.getNumbers()
            assertThat(numbers).hasSize(6)
            assertThat(numbers).doesNotHaveDuplicates()
            assertThat(numbers).allMatch { it in 1..45 }
            assertThat(numbers).isSorted()
        }
    }

    @DisplayName("Should generate tickets with unique numbers")
    @Test
    fun testGeneratesUniqueNumbers() {
        // given
        val lottoGenerator = LottoGenerator()

        // when
        val lotto = lottoGenerator.generate(1).first()

        // then
        val numbers = lotto.getNumbers()
        assertThat(numbers).hasSize(6)
        assertThat(numbers.distinct()).hasSize(6)
    }
}