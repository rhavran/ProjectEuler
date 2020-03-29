fun main(args: Array<String>) {
    val percentageOfPrimesIn100Elements = 25
    println("Res: " + prime(10_001 * percentageOfPrimesIn100Elements))
}

/**
By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

What is the 10 001st prime number?
 */
private fun prime(n: Int): Int {
    var count = 1
    var value = -1

    EratosthenesSieve(n).numbers.filter { true }.forEachIndexed { index, b ->
        if (index >= 2) {
            if (b) {
                count++
            }

            if (count == 10_001) {
                value = index + 1
            }
        }
    }

    return value
}



