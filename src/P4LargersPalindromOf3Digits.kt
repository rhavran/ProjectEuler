fun main(args: Array<String>) {
    println("Res: " + largestLargestPalindromeProduct())
}

/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
private fun largestLargestPalindromeProduct(): Int {
    val largest = 999
    val smallest = 100
    // largest number * largest number could be the first largest palindrome result
    val palindrome = largest * largest

    for (x in palindrome downTo 1) {
        for (b in largest downTo smallest step 1) {
            val a = x / b;
            if (x % b == 0 && a <= largest && a >= smallest && isPalindrome(x.toString())) {
                return x
            }
        }
    }

    return 0
}

fun isPalindrome(palindrome: String): Boolean {
    var isPalindrome = true
    for (ch in 0 until (palindrome.length / 2) step 1) {
        isPalindrome = isPalindrome && palindrome[ch] == palindrome[palindrome.length - 1 - ch]
    }
    return isPalindrome;
}

