package lotto

import lotto.view.InputView
import lotto.view.OutputView
import lotto.domain.LottoGenerator

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val lottoGenerator = LottoGenerator()
    try {
        val purchaseAmount = inputView.readPurchaseAmount()
        val lottoCount = purchaseAmount / 1000
        val lottos = lottoGenerator.generate(lottoCount)
        outputView.printPurchasedLottos(lottos)
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}
