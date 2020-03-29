fun main(args: Array<String>) {
    println("Res: " + findSolution())
}

/**
The following iterative sequence is defined for the set of positive integers:

n → n/2 (n is even)
n → 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.
 */
private fun findSolution(): Long {
    val startingPoint = 999_999L
    var maxChain = 0L
    var startingPointWithMaxChain = 0L

    for (x in startingPoint downTo 1L) {
        val collatzSequence = collatzSequence(x)
        if (collatzSequence > maxChain) {
            maxChain = collatzSequence
            startingPointWithMaxChain = x
        }

    }

    return startingPointWithMaxChain
}

fun collatzSequence(startingPoint: Long): Long {
    var result = 1L
    var number = startingPoint
    while (number != 1L) {

        number = nextCollatzNumber(number)
        result++
    }

    return result
}

fun nextCollatzNumber(n: Long): Long {
    return if (n % 2 == 0L) n / 2 else (n * 3) + 1
}
