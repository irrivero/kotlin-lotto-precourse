package lotto.domain

import lotto.Lotto

class WinningChecker(private val winningNumbers: List<Int>, private val bonusNumber: Int) {
    fun checkRank(lotto: Lotto): LottoRank {
        val matchCount = lotto.matches(winningNumbers)
        val bonusMatch = lotto.containsNumber(bonusNumber)
        return LottoRank.findByMatch(matchCount, bonusMatch)
    }
}