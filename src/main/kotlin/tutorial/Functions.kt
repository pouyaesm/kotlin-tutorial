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

  // Getting rid of java Erasure problem using @JvmName
  println("OverloadedInt: ${aggregate(listOf(1, 2, 3))}")
  println("OverloadedString: ${aggregate(listOf("a, ", "b, ", "c"))}")

  // Inline higher-order function for better performance
  execute("Hello, World!", { string -> println(string) })

  // Access generic types in runtime using (inline, reified)
  genericFunction<Int>("Hello")
  genericFunction<Int>(2)
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

/**
 * Erasing Erasure
 * Overload different generic types
 * with the same name by telling Kotlin to replace their name on compile
 * (not possible in java since generics are erased resulting in the same signature)
 */
@JvmName("aggregateInt")
fun aggregate(list: List<Int>) : Int {
  var sum = 0
  list.forEach{value -> sum += value}
  return sum
}

@JvmName("aggregateString")
fun aggregate(list: List<String>) : String {
  var concat = ""
  list.forEach { string -> concat += string }
  return concat
}


/**
 * Use 'inline' only for higher-order functions
 * Compiler replaces the execute(.) call with its internal code
 * which removes one function call leading to better performance
 */
inline fun execute(input: Any, function: (Any) -> Any) {
  println("Before execution")
  function(input)
  println("After execution")
}

/**
 * Use inline with reified
 * to access generic type information at runtime
 * which cannot be done without (inline, reified) due to JVN erasure
 */
inline fun <reified T> genericFunction(x: Any){
  if(x is T){
    println("'$x' type matches the generic type ${T::class}")
  }else{
    println("'$x' type doesn't match the generic ${T::class}")
  }
}