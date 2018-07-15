@file:JvmName("MyKotlinCode") // java can call MyKotlinCode.<function name>

package tutorial

fun main(args: Array<String>){
  println("add (3, 10) = ${add(3, 10)}")
}

fun add(a: Int, b: Int) : Int = a + b