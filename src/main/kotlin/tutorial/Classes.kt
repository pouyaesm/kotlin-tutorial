package tutorial

import java.util.concurrent.Executors

fun main(args: Array<String>){
  println("Hello, world!")
  try {
    val invalidAnimal = Animal(name = "c4", height = 12.0, weight = 10.0)
  }catch (e: IllegalArgumentException){
    e.printStackTrace()
  }
  val animal = Animal(name = "dog", height = 12.0, weight = 10.0)
  animal.printInfo()

  // Class inheritance
  val dog = Dog("dog", 15.0, 14.0, "John")
  dog.printInfo()

  // Interface
  val tweety = Bird("tweety")
  tweety.fly(10.0)

  // Function extension (super cool and weird!)
  fun Dog.eat() {
    println("Dog is eating")
  }
  dog.eat()

  // Interface inference: instead of using new Runnable(){public run(){..}}
  // Kotlin places the function inside run(){}
  val printThreadInfo = {println("Current thread is ${Thread.currentThread().name}")}
  printThreadInfo()
  val executor = Executors.newSingleThreadExecutor()
  executor.execute({ printThreadInfo() })
}

/**
 * Classes are final by default unless using 'open'
 * to let inheriting the classes
 */
open class Animal(val name: String, var height: Double, var weight: Double){

  init {
    val hasDigit = Regex(".*\\d+.*")
    require(!name.matches(hasDigit)){"Animal name can't contain numbers"}
    require(height > 0){"height must be greater than zero"}
    require(weight > 0){"weight must be greater than zero"}
  }

  /**
   * Kotlin functions are final by default, use 'open'
   * to allow overriding functions
   */
  open fun printInfo() {
    println("Animal name is $name, $height height and weighs $weight")
  }
}

open class Dog(name: String,
               height: Double,
               weight: Double,
               var owner: String) : Animal(name, height, weight) {
  override fun printInfo() {
    println("Dog name is $name, $height height and weighs $weight, and owned by $owner")
  }
}

interface Flyable{
  var flies: Boolean
  fun fly(distance: Double)
}

open class Bird constructor(var name: String, override var flies : Boolean = true) : Flyable {
  override fun fly(distance: Double) {
    println("$name flied $distance miles")
  }
}