package tutorial

import kotlin.properties.Delegates

fun main(args: Array<String>){
  val member = Member()
  println("Member name initial: ${member.name}")
  member.name = "a12" // does not work!
  println("Member name set to a12: ${member.name}")
  member.name = "abc"
  println("Member name set to abc: ${member.name}")
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
}