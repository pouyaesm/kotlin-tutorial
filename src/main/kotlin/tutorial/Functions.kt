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
  val mult3 = makeMathFunction(3)
  println("mathFunction(5) = 5 * 3 = ${mult3(5)}")
  mathOnList((1..10).toList(), mult3)

  // Lazy lambdas for performance (specially in android)
  // These functions are executed when the assignee is called for the first time
  // lazy guarantees one execution by locking other threads
  // If you are sure that only one thread will reach this, use lazy(NONE)
  val name : String by lazy(LazyThreadSafetyMode.NONE) { "John" + " Doe" }
  println("Lazy name is $name")  // function is called here as the first access
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

/**
 * Higher-order function that builds a math function
 * for the given coefficient
 */
fun makeMathFunction(coefficient: Int): (Int) -> Int = {num -> num * coefficient}

fun mathOnList(numList: List<Int>, func: (num: Int) -> Int): Unit {
  for (num in numList){
    println("mathOn $num: ${func(num)}")
  }
}