import kotlin.math.sqrt

/**
 * https://www.youtube.com/watch?v=V08g_lkKj6Q
 */
class EratosthenesSieve(n: Int) {
    val numbers: List<Boolean>

    init {
        val numbersArray = BooleanArray(n + 1)
        numbersArray.fill(true)

        var potentialPrime = 2
        while (potentialPrime * potentialPrime <= n) {
            // If prime[p] is not changed, then it is a prime
            if (numbersArray[potentialPrime]) { // Update all multiples of p

                var nextPow = potentialPrime * potentialPrime
                while (nextPow <= n) {
                    numbersArray[nextPow] = false
                    nextPow += potentialPrime
                }
            }
            potentialPrime++
        }

        numbers = numbersArray.toList()
    }

    fun isPrime(n: Int): Boolean {
        return numbers[n]
    }
}

object PrimeFactorization {
    private val incrementFunc: (t: Long, u: Long?) -> Long? = { _, old -> if (old == null) 1L else old + 1L }

    fun primeFactors(n: Long): Map<Long, Long> {
        val numberToPower = hashMapOf<Long, Long>()

        // Add the number of 2s that divide n.
        var number = n
        while (number % 2L == 0L) {
            numberToPower.compute(2L, incrementFunc)

            number /= 2L
        }

        // n must be odd at this point.  So we can
        // skip one element (Note i = i +2) as per sieve of Eratosthenes.
        var i = 3L
        while (i <= sqrt(number.toDouble())) {

            // While i divides n, add i and divide n
            while (number % i == 0L) {
                numberToPower.compute(i, incrementFunc)

                number /= i
            }
            i += 2L
        }

        // This condition is to handle the case when
        // n is a prime number greater than 2
        if (number > 2L) {
            numberToPower.compute(number, incrementFunc)
        }
        return numberToPower
    }
}

/**
 * σ0(N)
 * https://en.wikipedia.org/wiki/Divisor_function
 */
fun Long.dividers(): Long {
    var dividers = 1L
    val numberToPower = PrimeFactorization.primeFactors(this)

    for (entry in numberToPower) {
        dividers *= (entry.value + 1)
    }

    return dividers
}

fun Long.sequenceSumStartingFrom(a0: Long): Long {
    return sumFromTo(a0, this)
}

fun sumFromTo(a0: Long, aN: Long): Long {
    val n = aN - a0 + 1
    return (n.toDouble() / 2.0 * (a0 + aN)).toLong()
}