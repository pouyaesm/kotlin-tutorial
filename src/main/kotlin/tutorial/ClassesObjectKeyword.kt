package tutorial

fun main(args: Array<String>){
  // Call static function of a class
  println(OperationCenter.info())

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

class OperationCenter {
  /**
   * Use 'companion object {}' block to declare
   * static variables and functions
   */
  companion object {
    val id = 12345  // static variable
    /**
     * @JvmStatic is used to let Java access
     * the static function using OperationCenter.info()
     */
    @JvmStatic
    fun info(): String{
      return "center id: $id, status: running"
    }
  }
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