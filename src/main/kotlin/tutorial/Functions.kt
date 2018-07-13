package tutorial

fun main(args: Array<String>){

    // Inline function definition
    fun add(a: Int = 0, b: Int = 0) : Int = a + b

    println("2 + 3 = ${add(2, 3)}")

    // Default value
    println("0 + 0 = ${add()} (default arguments)")

    // Named parameters
    println("4 + 0 = ${add(a = 4)} (named parameter)")

    // Function without return uses 'Unit'
    fun printThis(s: String) : Unit = println(s)
    printThis("This is a return-less function.")

    // Return multiple values
    val (two, three) = nextTwo(5)
    println("Next two after 5 are $two, and $three")

    // Variable-length arguments
    val sum = getSum(1, 2, 3, 4, 5)
    println("1 + ... + 5 = $sum")

    // Literal function
    val multiply = {a : Int, b : Int -> a * b}
    println("4 x 5 = ${multiply(4, 5)}")

    // Higher-order functions

}

/**
 * Returns next two integers
 */
fun nextTwo(num: Int): Pair<Int, Int> {
    return Pair(num + 1, num + 2)
}

/**
 * Returns sum of arbitrary number of integers
 */
fun getSum(vararg values : Int) : Int {
    var sum = 0
    values.forEach {value -> sum += value}
    return sum
}