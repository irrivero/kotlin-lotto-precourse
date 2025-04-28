package lotto.view

import lotto.Lotto
import lotto.domain.LottoRank

class OutputView {
    fun printPurchasedLottos(lottos: List<Lotto>) {
        println("\nYou have purchased ${lottos.size} tickets.")
        lottos.forEach {
            println(it.getNumbers())
        }
    }

    fun printWinningStatistics(results: Map<LottoRank, Int>, totalCost: Int) {
        println("\nWinning Statistics")
        println("---")

        LottoRank.values().filter { it != LottoRank.NONE }.reversed().forEach { rank ->
            val count = results.getOrDefault(rank, 0)
            val message = when (rank) {
                LottoRank.FIFTH -> "3 Matches (5,000 KRW) – $count tickets"
                LottoRank.FOURTH -> "4 Matches (50,000 KRW) – $count tickets"
                LottoRank.THIRD -> "5 Matches (1,500,000 KRW) – $count tickets"
                LottoRank.SECOND -> "5 Matches + Bonus Ball (30,000,000 KRW) – $count tickets"
                LottoRank.FIRST -> "6 Matches (2,000,000,000 KRW) – $count tickets"
                else -> ""
            }
            println(message)
        }

        val totalPrize = results.entries.sumOf { it.key.prize * it.value }
        val returnRate = if (totalCost == 0) 0.0 else totalPrize.toDouble() / totalCost * 100
        val formattedReturnRate = String.format("%.1f", returnRate).replace(",", ".") // Asegura punto decimal
        println("Total return rate is $formattedReturnRate%.")
    }
}