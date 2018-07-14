package tutorial

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

fun main(args: Array<String>){
  val member = Member()
  println("Member name initial: ${member.name}")
  member.name = "a12" // does not work!
  println("Member name set to a12: ${member.name}")
  member.name = "abc"
  println("Member name set to abc: ${member.name}")

  // A custom delegate
  println("Member address initial: ${member.address}")
  member.address = "alley 2, street 123"
  println("Member address set: ${member.address}")
}

class Member {
  /**
   * Ignore (or veto) name assignments that contain digits!
   * Basically we are saying a wrong code to be ignored without error
   * which in my opinion is a wrong practice
   */
  var name : String by Delegates.vetoable("unknown") {
    property, oldValue, newValue -> !newValue.matches(Regex(".*\\d+.*"))
  }

  var address : String by MyStringDelegate()
}

/**
 * A custom delegate must determine the type of
 * object on which works (here Any object)
 * and the type of property (here String)
 * an implements getValue and setValue functions
 */
class MyStringDelegate {
  var value = "not set"
  operator fun getValue(obj: Any, property: KProperty<*>) : String {
    println("getValue accessed, object: $obj, property: ${property.name}")
    return value
  }

  operator fun setValue(obj: Any, property: KProperty<*>, value: String){
    println("setValue accessed, object: $obj, property: ${property.name}")
    this.value = value
  }

}