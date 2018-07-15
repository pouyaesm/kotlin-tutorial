package tutorial

import java.util.concurrent.Executors

fun main(args: Array<String>){
  println("Hello, world!")

  // Create a class by setting the variables defined in constructor
  val animal = Animal(name = "dog", height = 12.0, weight = 10.0)
  animal.printInfo()
  // Create a class with a name that violates the name validation in init{}
  try {
    val invalidAnimal = Animal(name = "c4", height = 12.0, weight = 10.0)
  }catch (e: IllegalArgumentException){
    e.printStackTrace()
  }

  // Class inheritance
  val dog = Dog("dog", 15.0, 14.0, "John")
  dog.printInfo()

  // Function extension (super cool and weird!)
  fun Dog.eat() {
    println("Dog is eating")
  }
  dog.eat()

  // Infix function use
  println("Is John the dog's owner? ${dog isOwnedBy "John"}.")

  // Interface
  val tweety = Bird("tweety")
  tweety.fly(10.0)

  // A 'data' class gives .toString(), .equals(), and .copy() for free
  // In java you need a lot of boiler plate for these methods
  val product1 = Product(name="Soap", price=1.0)
  val product2 = Product(name="Soap", price=1.0)
  println("Data class isEqual: ${product1 == product2}")
  println("Data class toString: $product1")
  val productCopy = product1.copy(name = "Liquid Soap") // deep copy
  println("Data class original (${product1.name}), copy {${productCopy.name})")

  // Interface inference: instead of using new Runnable(){public run(){..}}
  // Kotlin places the function inside run(){}
  val printThreadInfo = {println("Current thread is ${Thread.currentThread().name}")}
  printThreadInfo()
  val executor = Executors.newSingleThreadExecutor()
  executor.execute { printThreadInfo() }
}

/**
 * Classes are final by default unless using 'open'
 * to let other classes inheriting them
 */
open class Animal(val name: String){

  var height : Double = 0.0
  var weight : Double = 0.0

  /**
   * This secondary constructor calls the first constructor to
   * set the name. First constructor is defined next to the class name: Animal(<here>)
   */
  constructor(name: String, height: Double, weight: Double) : this(name) {
    require(height > 0){"height must be greater than zero"}
    require(weight > 0){"weight must be greater than zero"}
    this.height = height
    this.weight = weight
  }

  init {
    println("init Animal")
    val hasDigit = Regex(".*\\d+.*")
    require(!name.matches(hasDigit)){"Animal name can't contain numbers"}
  }

  /**
   * Kotlin functions are final by default, use 'open'
   * to allow overriding functions
   */
  open fun printInfo() {
    println("Animal name is $name, $height height and weighs $weight")
  }
}

/**
 * Class Dog extends class Animal
 */
open class Dog(name: String,
               height: Double,
               weight: Double,
               private var owner: String) : Animal(name, height, weight) {
  /**
   * First Animal init is executed then
   * Dog init
   */
  init {
    println("init Dog")
  }

  override fun printInfo() {
    println("Dog name is $name, $height height and weighs $weight, and owned by $owner")
  }

  /**
   * Infix function f can be used as 'a f b' instead of 'a.f(b)'
   */
  infix fun isOwnedBy(name : String) = owner == name
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

/**
 * 'data' modifier provides toString(), equals(), copy()
 * functions, freeing use from writing boiler-plates
 */
data class Product(var name: String, var price: Double)