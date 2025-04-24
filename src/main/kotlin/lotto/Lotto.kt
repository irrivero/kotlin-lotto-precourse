
//You must implement your program using the provided Lotto class.
//You must not add any fields (instance variables) to the Lotto class other than numbers.
//The visibility modifier private on numbers must not be changed.
//You must not change the package of the Lotto class.

package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.distinct().size == 6) { "[ERROR] Lotto numbers must be unique." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
    }

    fun getNumbers(): List<Int> {
        return numbers.sorted()
    }

    fun matches(winningNumbers: List<Int>): Int {
        return numbers.count { it in winningNumbers}
    }

    fun containsNumber(number: Int): Boolean {
        return number in numbers
    }
}
