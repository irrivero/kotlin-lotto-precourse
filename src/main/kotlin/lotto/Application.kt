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

    // Purchase
    val purchaseAmount = readPurchaseAmount(inputView)
    val lottoCount = purchaseAmount / 1000
    val lottos = lottoGenerator.generate(lottoCount)
    outputView.printPurchasedLottos(lottos)

    // Winning numbers
    val winningNumbers = readWinningNumbers(inputView)
    val bonusNumber = readBonusNumber(inputView, winningNumbers)

    // Check results
    val winningChecker = WinningChecker(winningNumbers, bonusNumber)
    val results = lottos.groupingBy { winningChecker.checkRank(it) }
        .eachCount()
        .filter { it.key != LottoRank.NONE }

    // Output
    outputView.printWinningStatistics(results, lottoCount * 1000)
}

fun readPurchaseAmount(inputView: InputView): Int {
    while (true) {
        try {
            return inputView.readPurchaseAmount()
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}

fun readWinningNumbers(inputView: InputView): List<Int> {
    while (true) {
        try {
            return inputView.readWinningNumbers()
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}

fun readBonusNumber(inputView: InputView, winningNumbers: List<Int>): Int {
    while (true) {
        try {
            return inputView.readBonusNumber(winningNumbers)
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}