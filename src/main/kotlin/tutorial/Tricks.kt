package tutorial

import kotlin.system.measureNanoTime

fun main(args: Array<String>){
  // Measuring code block execution time
  var x = 0.0
  val duration = measureNanoTime{
    x = Math.pow(Math.E, 20.0)
  }
  println("Math.pow took $duration ns")
}

/**
 * Explosive Placeholders
 * This is used to avoid syntax error
 * because of unimplemented code
 */
fun connect(type: Boolean) : Int {
  if (type) {
    return 1
  } else {
    TODO("return something else ?")
  }
}

/**
 * Semantic Validation
 * To avoid verbose 'if(not valid) throw exception' used in java
 * Note than null checks are out of concern because of Kotlin's NullSafety
 */
fun calculate(a: Int, b: Int) : Int {
  require(a > 0) {" a must be positive"}
  require(b % 2 == 0) {" b must be even"}
  return 0
}

/**
 * Anything and Nothing
 * All types (even Int) are extended from Any
 * Nothing extends all types!
 */
fun printName(user : User?){
  // User or its name maybe null, also throw returns Nothing
  // so the type of name will be Nothing that extends (String, null, and Nothing)
  val name = user?.name ?: throw IllegalArgumentException("User is null")
  println("Name is $name.")
}

class User (val name : String?)

/**
 * Anything and Nothing
 * The return type 'Nothing' will tell compiler
 * that no code can be accessed after calling this function
 * thus writing a code after checkConnection() will show an error indication
 * just like writing a code after 'return ...' or 'throw ...' does
 * By removing Nothing, compiler cannot figure this out
 */
fun checkConnection() : Nothing {
  while (true){
    connect(true)
  }
}