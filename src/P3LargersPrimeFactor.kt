fun main(args: Array<String>) {
    println("Res: " + seekForPrime())
}

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 */
// Idea to look only in
private fun seekForPrime(): Long {
    val inNumber = 600851475143L
    return PrimeFactorization.primeFactors(inNumber).entries.stream().max { o1, o2 -> (o1.key - o2.key).toInt() }.get().key
}
