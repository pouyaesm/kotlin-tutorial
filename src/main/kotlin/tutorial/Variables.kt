package tutorial

fun main(args: Array<String>){
    val name = "Derek"  // val is for immutable variables (cannot be changed)
    var age = 42        // var is for mutable variables

    val bigInt: Int = Int.MAX_VALUE
    val smallInt: Int = Int.MIN_VALUE
    val bigDouble: Double = Double.MAX_VALUE
    val smallDouble: Double = Double.MIN_VALUE
    println("Integer range ($smallInt, $bigInt)")
    println("Double range ($smallDouble, $bigDouble)")

    // variable type check
    println("variable type ${if (bigDouble is Double) "did" else "didn't"} match Double")

    // variable cast
    println("A to Int: ${'A'.toInt()}")
    println("65 to Char: ${65.toChar()}")
    println("3.14 to Int: ${3.14.toInt()}")
}