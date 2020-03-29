import kotlin.math.pow

fun main(args: Array<String>) {
    println("Res: " + findSolution())
}

/**
A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

a^2 + b^2 = c^2
For example, 3^2 + 4^2 = 9 + 16 = 25 = 52.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
 */
private fun findSolution(): Long {
    for (c in 999L downTo 3L) {
        for (b in c - 1 downTo 2L) {
            for (a in b - 1 downTo 1L) {
                if (a.toDouble().pow(2.0).toLong() + b.toDouble().pow(2.0).toLong() == c.toDouble().pow(2).toLong()) {
                    if (a + b + c == 1000L) {
                        return a * b * c
                    }
                }
            }
        }
    }

    return -1
}
