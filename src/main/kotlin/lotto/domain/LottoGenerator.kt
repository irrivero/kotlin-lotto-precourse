package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

class LottoGenerator {
    fun generate(count: Int): List<Lotto> {
        return List(count) { createLotto() }
    }

    private fun createLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return Lotto(numbers)
    }
}