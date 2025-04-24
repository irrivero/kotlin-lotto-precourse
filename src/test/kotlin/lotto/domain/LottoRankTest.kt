package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoRankTest {
    @Test
    fun `find correct rank by match count and bonus`() {
        // When & Then
        assertThat(LottoRank.findByMatch(6, false)).isEqualTo(LottoRank.FIRST)
        assertThat(LottoRank.findByMatch(5, true)).isEqualTo(LottoRank.SECOND)
        assertThat(LottoRank.findByMatch(5, false)).isEqualTo(LottoRank.THIRD)
        assertThat(LottoRank.findByMatch(4, false)).isEqualTo(LottoRank.FOURTH)
        assertThat(LottoRank.findByMatch(3, false)).isEqualTo(LottoRank.FIFTH)
        assertThat(LottoRank.findByMatch(2, false)).isEqualTo(LottoRank.NONE)
    }

    @Test
    fun `prize amounts are correct`() {
        // When & Then
        assertThat(LottoRank.FIRST.prize).isEqualTo(2_000_000_000)
        assertThat(LottoRank.SECOND.prize).isEqualTo(30_000_000)
        assertThat(LottoRank.THIRD.prize).isEqualTo(1_500_000)
        assertThat(LottoRank.FOURTH.prize).isEqualTo(50_000)
        assertThat(LottoRank.FIFTH.prize).isEqualTo(5_000)
        assertThat(LottoRank.NONE.prize).isEqualTo(0)
    }
}