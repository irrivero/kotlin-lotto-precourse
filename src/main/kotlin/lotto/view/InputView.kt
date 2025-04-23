package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()
        try {
            val amount = input.toInt()
            require(amount >= 0) { "[ERROR] Purchase amount must be non-negative." }
            require(amount % 1000 == 0) { "[ERROR] Purchase amount must be divisible by 1,000." }
            return amount
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Invalid input. Please enter a valid number.")
        }
    }
}