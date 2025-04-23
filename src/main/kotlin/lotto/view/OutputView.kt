package lotto.view

import lotto.Lotto

class OutputView {
    fun printPurchasedLottos(lottos: List<Lotto>) {
        println("\nYou have purchased ${lottos.size} tickets.")
        lottos.forEach {
            println(it.getNumbers())
        }
    }
}