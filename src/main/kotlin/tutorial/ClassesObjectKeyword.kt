package tutorial

fun main(args: Array<String>){
  // A singleton using 'object' keyword
  NameList.names.add("John")
  NameList.names.add("Barbara")
  println(NameList.names)

  // Anonymous class
  val einsteinEq = object : Equation {
    override fun display() {
      println("E = M x C ^ 2")
    }
  }
  einsteinEq.display()


}

/**
 * A singleton class of names
 */
object NameList{
  val names : MutableList<String> = mutableListOf()
}

/**
 * An interface to be implemented in an anonymous class
 */
interface Equation{
  fun display()
}