fun main(args: Array<String>) {
    println("Res: " + findSolution())
}

/**
The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.
 */
private fun findSolution(): String {
    val n = 2_000_000

    var sum = 0L

    EratosthenesSieve(n).numbers.forEachIndexed { index, isPrime ->
        if (index >= 2 && isPrime) {
            sum += index
        }
    }

    return sum.toString()
}
