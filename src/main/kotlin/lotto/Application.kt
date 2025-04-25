package lotto

import lotto.domain.LottoGenerator
import lotto.domain.WinningChecker
import lotto.domain.LottoRank
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val lottoGenerator = LottoGenerator()

    try {
        // Purchase
        val purchaseAmount = inputView.readPurchaseAmount()
        val lottoCount = purchaseAmount / 1000
        val lottos = lottoGenerator.generate(lottoCount)
        outputView.printPurchasedLottos(lottos)

        // Winning numbers
        val winningNumbers = inputView.readWinningNumbers()
        val bonusNumber = inputView.readBonusNumber(winningNumbers)

        // Check results
        val winningChecker = WinningChecker(winningNumbers, bonusNumber)
        val results = lottos.groupingBy { winningChecker.checkRank(it) }
            .eachCount()
            .filter { it.key != LottoRank.NONE }

        // Output
        outputView.printWinningStatistics(results, lottoCount * 1000)
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}