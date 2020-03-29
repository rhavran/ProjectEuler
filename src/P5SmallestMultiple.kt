fun main(args: Array<String>) {
    println("Res: " + smallestMultiple())
}

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
private fun smallestMultiple(): Int {
    for (x in 1 until Int.MAX_VALUE) {
        var isDev = true;
        for (dev in 20 downTo 2 step 1) {
            isDev = isDev && x % dev == 0
        }
        if (isDev) {
            return x
        }
    }

    return 0
}
